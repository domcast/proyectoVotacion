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
        <title>Analista</title>
    </head>
    <body>
        <main>
            <div class="container">
                <div class="row">
                    <div class="col s2"></div>
                    <div class="col s8">
                        <h1 class="blue-text text-darken-4">Menu</h1>
                        <table class="responsive-table centered">
                            <tr>
                                <td></td>
                                <td>
                                    <a href="pronto.jsp"><img src="img/reporte.png" alt="" height="100"></a>
                                    <p class="blue-text text-darken-4">Reportes</p>
                                </td>
                                <td>
                                    <a href="resultado.jsp"><img src="img/resultado.png" alt="" height="100"></a>
                                    <p class="blue-text text-darken-4">resultados</p>
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