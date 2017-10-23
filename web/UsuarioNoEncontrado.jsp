<%-- 
    Document   : UsuarioNoEncontrado
    Created on : 10-oct-2017, 23:09:26
    Author     : alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="links.jsp" %>
        <title>Error de Ingreso</title>
    </head>
    <script>
        $(document).ready(function() {          

            window.setInterval($(location).attr('href','loguin.jsp'), 10000);
        });
    </script>
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
                        <h2 class="blue-text text-darken-4" id="Tlogin">Usuario no Encontrado</h2>                        
                        <h5 class="blue-text text-darken-4" id="Tlogin">Esta pagina se autoredireccionara al login en 10 Segundos o haga clic en el boton redireccionar</h5>
                        <br>
                        <a class="btn" href="loguin.jsp">Redireccionar</a>                                                
                    </div>
                    <div class="col s1"></div>
                </div>
            </div>
        </main>
    </body>
    <%@include file="footer.jsp" %>
</html>
