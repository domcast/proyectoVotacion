<%-- 
    Document   : analista
    Created on : 04-oct-2017, 22:30:48
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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="links.jsp" %>
        <title>Menu Administrador</title>
    </head>
    <body>
        <main>
            <div class="container">               
                <div class="row">
                    <div class="col s2"></div>
                    <div class="col s8" aligne="center">
                        <h1 class="blue-text text-darken-4">Menu</h1>
                        <table class="responsive-table centered">
                            <tr>
                                <td>
                                    <a href="Persona.jsp"><img src="img/personas.jpg" alt="" height="100"></a>
                                    <p class="blue-text text-darken-4">Persona</p>
                                </td>
                                <td>
                                    <a href="pronto.jsp"><img src="img/reporte.png" alt="" height="100"></a>
                                    <p class="blue-text text-darken-4">Reportes</p>
                                </td>
                                <td>
                                    <a href="candidato.jsp"><img src="img/candidato.jpg" alt="" height="100"></a>
                                    <p class="blue-text text-darken-4">Candidatos</p>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                   <a href="contrasenia.jsp"><img src="img/contra.jpg" alt="" height="100"></a>
                                    <p class="blue-text text-darken-4">generar contraseña</p> 
                                </td>
                                <td>
                                    <a href="pronto.jsp"><img src="img/ciudadano.jpg" alt="" height="100"></a>
                                    <p class="blue-text text-darken-4">Ciudadano</p>
                                </td>
                                <td>
                                    <a href="partido.jsp"><img src="img/partido.jpg" alt="" height="100"></a>
                                    <p class="blue-text text-darken-4">partidos Politicos</p>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                   <a href="Departamento.jsp"><img src="img/departa.png" alt="" height="100"></a>
                                    <p class="blue-text text-darken-4">Departamento</p>
                                </td>
                                <td>
                                    <a href="municipio.jsp"><img src="img/muni.png" alt="" height="100"></a>
                                    <p class="blue-text text-darken-4">Municipio</p>
                                </td>
                                <td>
                                     
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="col s2"></div>
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