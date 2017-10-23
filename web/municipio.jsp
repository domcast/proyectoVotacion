<%-- 
    Document   : Municipio
    Created on : 10-11-2017, 11:08:51 PM
    Author     : SILENTSv
--%>
<% 
        response.setHeader("Cache-Control","no-store");
        HttpSession obj=request.getSession(false);
        String usuario=(String) obj.getAttribute("cuenta");
        String contra=(String) obj.getAttribute("contra");
        
        if(usuario!=null && contra!=null)
        {
            
        
%>
<%@page import="java.util.*" %>
<%@page import="com.modelo.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="links.jsp" %>
        <title>JSP Page</title>
        <script>
            $( document ).ready(function(){
     $('select').material_select();
    
     });
        </script>
        <script>
            function cargarDatos(txtidMun,txtNombreMun,departamento)
            {
                document.frmMunicipio.txtidMun.value=txtidMun;
                document.frmMunicipio.txtNombreMun.value=txtNombreMun;
                document.frmMunicipio.departamento.value=departamento;                   
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
    <%
        CrudMunicipio cmun = new CrudMunicipio();
    %>
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
                        <h2 class="blue-text text-darken-4" id="Tlogin">Mantenimiento Municipio</h2>
                    </div>
                    <div class="col s1"></div>
                </div>
                <div class="row">
                    <div class="col s2"></div>
                    <div class="col s8">
                         <form action="procesarMunicipio" method="POST" name="frmMunicipio">
                            <table class="highlight  responsive-table">
                                <tr>
                                    <td>Codigo Municipio</td>
                                    <td><input type="number" name="txtidMun" required=""></td>
                                </tr>
                                <tr>
                                    <td>Nombre Municipio</td>
                                    <td><input type="text" name="txtNombreMun" required=""></td>
                                </tr>
                                <tr>
                                    <td>Departamento</td>
                                    <td>
                                        <select name="departamento">
                                            <option value="" disabled selected>Escoja una opcion</option>
                                            <%
                                                List<Departamento>ls=cmun.listarDepartamento();
                                                for(Departamento dep:ls){
                                            %>
                                            <option value="<%=dep.getIdDepartamento()%>"><%=dep.getNombreDep()%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input class="btn" type="submit" name="btnInsertar" value="Insertar">
                                        <input class="btn"  type="submit" name="btnModificar" value="Modificar" onclick="return modificar()">
                                        <input class="btn"  type="submit" name="btnEliminar" value="Eliminar" onclick="return eliminar()">
                                        <input class="btn"  type="reset" name="btnCancelar" value="Cancelar">
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
                                <td>Id Municipio</td>
                                <td>Nombre Municipio</td>
                                <td>Departamento</td>
                                <td>Seleccionar</td>
                            </tr>
                             <%
                                    List<Municipio>ls2=cmun.mostrarMunicipio();
                                    for(Municipio mun:ls2)
                                    {
                                %>
                                <tr>
                                    <td><%= mun.getIdMunicipio()%></td>
                                    <td><%= mun.getNombreMuni()%></td>
                                    <td><%= mun.getDepartamento().getNombreDep() %></td>
                                    <td><a href="javascript:cargarDatos(<%= mun.getIdMunicipio()%>,'<%= mun.getNombreMuni()%>',<%= mun.getDepartamento().getIdDepartamento() %>)">Seleccionar</a></td>
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