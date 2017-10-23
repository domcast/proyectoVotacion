<%-- 
    Document   : contrasenia
    Created on : 12-oct-2017, 3:15:55
    Author     : alejandro
--%>
<% 
        response.setHeader("Cache-Control","no-store");
        HttpSession obj=request.getSession(false);
        String usuario=(String) obj.getAttribute("cuenta");
        String contra=(String) obj.getAttribute("contra");
        
        if(usuario!=null && contra!=null)
        {
            
        
%>
<%@page import="com.modelo.*" %>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%@include file="links.jsp" %>
        
        <title>contrasenia</title>
        <script>
            $( document ).ready(function(){
     $('select').material_select();
    
     });
        </script>
        <script>
            function cargar(id, contra, esta)
            {
                document.frmContra.txtId.value=id;
                document.frmContra.txtContra1.value=contra;
                document.frmContra.estado.value=esta;
            }
            function modificar()
            {
                if(confirm("¿Desea modifiar los datos?"))
                {
                    return true;
                }
                else 
                {
                    return false;
                }
            }
            
            function eliminar()
            {
                if(confirm("¿Desea eliminar los datos?"))
                {
                    return true;
                }
                else 
                {
                    return false;
                }
            }
        </script>
        <%
            if(request.getSession().getAttribute("valor")!=null)
            {
        %>
        <script>
            alert('<%= request.getSession().getAttribute("valor") %>')
        </script>
        <%
            request.getSession().setAttribute("valor", null);
            }
        %>
    </head>
    <% CrudContrasenia cc=new CrudContrasenia(); %>
    <body>
        <main>
            <div>
               <nav>
                    <div class="nav-wrapper  light-blue darken-4">
                        <a href="#" class="brand-logo"><img src="img/tse.png" alt=""></a>
                        
                      <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <li><a href="pronto.jsp">Cerrar Session</a></li>
                        <li><a href=""></a></li>
                        <li><a href=""></a></li>
                      </ul>
                    </div>
                </nav>
            </div>
            <div class="container">            
                <div class="row">
                    <div class="col s1"></div>
                    <div class="col s10">
                        <h2 class="blue-text text-darken-4" id="Tlogin">Mantenimiento Contraseña</h2>
                    </div>
                    <div class="col s1"></div>
                </div>
                <div class="row">
                    <div class="col s2"></div>
                    <div class="col s8">
                         <form action="procesarContrasenia" method="post" name="frmContra">
                            <table class="highlight  responsive-table">
                                <tr>
                                    <td>Id de contrasenia</td>
                                    <td><input type="text" name="txtId"></td>
                                </tr>
                                <tr>
                                    <td>contraseña</td>
                                    <td><input type="password" name="txtContra1"></td>
                                </tr>

                                <tr>
                                    <td>Estado</td>
                                    <td>
                                        <select name="estado">
                                            <option value="" disabled selected>Escoja una opcion</option>
                                            <option value="1">Libre</option>
                                            <option value="2">Usuada</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input class="btn" type="submit" name="btnEnviar" value="Insertar">
                                        <input class="btn" type="submit" name="btnModificar" value="Modificar" onclick="return modificar()">
                                        <input class="btn" type="submit" name="btnEliminar" value="Eliminar" onclick="return eliminar()">
                                        <input class="btn" type="reset" name="btnLimpiar" value="limpiar">
                                    </td>
                                </tr>
                            </table>           
                        </form>    
                    </div>
                    <div class="col s2"></div>
                </div>
                <div class="row">
                    <div class="col s1"></div>
                    <div class="col s10">
                        <table class="bordered  responsive-table">
                            <tr>
                                <td>Id Contrasenia</td>
                                <td>Contrasenia </td>
                                <td>Estado</td>
                                <td>Seleccionar</td>
                            </tr>
                            <tr>
                                <% 
                                    List<Contrasenia> lis=cc.mostarContrasenia();
                                    for(Contrasenia l:lis)
                                    {

                                        %>
                                        <td><%= l.getIdContrasenia() %></td>
                                        <td><%= l.getContrasenia() %></td>
                                        <td><%= l.getEstado() %></td>
                                        <td><a href="javascript:cargar(<%= l.getIdContrasenia() %>,'<%= l.getContrasenia() %>',<%= l.getEstado() %> )">Seleccione</a></td>
                                        </tr>
                                        <%
                                    }
                                %>
                        </table>
                    </div>
                    <div class="col s1"></div>
                </div>
            </div>
        </main>
    </body>
    <%@include file="footer.jsp" %>
</html>
    <% 
}else{
    response.sendRedirect("loguin.jsp");
}
%>