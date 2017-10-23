<%-- 
    Document   : pronto
    Created on : 12/10/2017, 04:08:49 AM
    Author     : desconocido
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="links.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <main>
            <%@include file="menuPrin.jsp" %>
            <div class="container">
                <div class="row">
                    <div class="col s1"></div>
                    <div class="col s10">
                        <h2 class="blue-text text-darken-4" id="Tlogin">Espere Pronto la Actualizacion</h2>                        
                        <h5 class="blue-text text-darken-4" id="Tlogin">Si tiene dudas contacte al Administrador</h5>
                        <br>
                        <br>
                        <br>
                        <img src="img/error.png" alt="">
                    </div>
                    <div class="col s1"></div>
                </div>
            </div>
        </main>
    </body>
    <%@include file="footer.jsp" %>
</html>
