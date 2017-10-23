<%-- 
    Document   : Departamento
    Created on : 10-11-2017, 07:08:07 PM
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
        <title>Departamento</title>
        <script>
            function cargarDatos(txtidDep,txtNombreDep,txtCupos)
            {
                $('#txtidDep').val(txtidDep);
                $('#txtNombreDep').val(txtNombreDep);
                $('#txtCupos').val(txtCupos);                   
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
        CrudDepartamento cdep = new CrudDepartamento();
    %>
    <body>
        <main>            
            <%@include file="menuPrin.jsp" %>
            <div class="container">            
                <div class="row">
                    <div class="col s1"></div>
                    <div class="col s10">
                        <h2 class="blue-text text-darken-4" id="Tlogin">Mantenimiento Departamento</h2>
                    </div>
                    <div class="col s1"></div>
                </div>
                <div class="row">
                    <div class="col s2"></div>
                    <div class="col s8">
                         <form action="procesarDepartamento" method="POST" name="frmDepartamento">
                            <table class="highlight  responsive-table">
                                <tr>
                                    <td>Codigo Departamento</td>
                                    <td><input type="number" name="txtidDep" id="txtidDep" required=""></td>
                                </tr>
                                <tr>
                                    <td>Nombre Departamento</td>
                                    <td><input type="text" name="txtNombreDep" id="txtNombreDep" required=""></td>
                                </tr>
                                <tr>
                                    <td>Cupos</td>
                                    <td><input type="number" name="txtCupos" id="txtCupos" required=""></td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="submit" name="btnInsertar" value="Insertar">
                                        <input type="submit" name="btnModificar" value="Modificar" onclick="return modificar()">
                                        <input type="submit" name="btnEliminar" value="Eliminar" onclick="return eliminar()">
                                        <input type="reset" name="btnCancelar" value="Cancelar">
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
                                <td>Id departamento</td>
                                <td>Nombre</td>
                                <td>Cupos</td>
                                <td>Seleccionar</td>
                            </tr>
                             <%
                                    List<Departamento>depa=cdep.mostrarDepartamento();
                                    for(Departamento dep:depa)
                                    {
                                %>
                                <tr>
                                    <td><%= dep.getIdDepartamento()%></td>
                                    <td><%= dep.getNombreDep()%></td>
                                    <td><%= dep.getCupos()%></td>
                                    <td><a href="javascript:cargarDatos(<%= dep.getIdDepartamento() %>,'<%= dep.getNombreDep()%>',<%= dep.getCupos() %>)" >Seleccionar</a></td>
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
