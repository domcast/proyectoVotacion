<%-- 
    Document   : loguin
    Created on : 04-oct-2017, 21:54:25
    Author     : alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="links.jsp" %>         
        <title>login</title>
    </head>
    <body>
        <main>
            <div>
           <nav>
                <div class="nav-wrapper  light-blue darken-4">
                    <a href="#" class="brand-logo"><img src="img/tse.png" alt=""></a>
                  <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="IngresoPoblacion.jsp">Ingrese  Sesion</a></li>
                    <li><a href=""></a></li>
                    <li><a href=""></a></li>
                  </ul>
                </div>
            </nav>
        </div>
        <div>
            <div class="container">
                <div class="row">
                    <div class="col s1"></div>
                    <div class="col s10">
                        <h3  class="blue-text text-darken-4" id="Tlogin">Bienvenido a su sistema de Votaciones</h3>                        
                    </div>
                    <div class="col s1"></div>
                </div> 
                
                <div class="carousel carousel-slider center" data-indicators="true">                    
                    <div class="carousel-fixed-item center">
                        <a class="waves-effect waves-light btn" onclick="window.location.href ='IngresoPoblacion.jsp'">Iniciar Sesion</a>
                    </div>
                    <div class="carousel-item red white-text" href="#one!">
                      <img src="img/carrusel/carrucel1.jpg" alt="" height="100%">
                    </div>
                    <div class="carousel-item amber white-text" href="#two!">
                        <img src="img/carrusel/carrucel2.jpg" alt="" height="100%">
                    </div>
                    <div class="carousel-item green white-text" href="#three!">
                        <img src="img/carrusel/carrucel3.JPG" alt="" height="100%">
                    </div>
                    <div class="carousel-item blue white-text" href="#four!">
                        <img src="img/carrusel/carrucel4.jpg" alt="" height="100%">
                    </div>
              </div>
                <div class="row">
                    <div class="col s1"></div>
                    <div class="col s10">
                        <br>
                        <img src="img/logo-elecciones-2018.jpg" alt="" width="100%">
                    </div>
                    <div class="col s1"></div>
                </div>
            </div>
        </div>
        </main>
    </body>
    <%@include file="footer.jsp" %>
</html>
