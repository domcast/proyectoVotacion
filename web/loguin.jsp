<%-- 
    Document   : loguin
    Created on : 04-oct-2017, 21:54:25
    Author     : alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    if(request.getParameter("cerrar")!=null)
    {
        session.invalidate();
    }
    %>
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
                    <a href="index.jsp" class="brand-logo"><img src="img/tse.png" alt=""></a>
                  <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="#">Iniciar Session</a></li>
                    <li><a href=""></a></li>
                    <li><a href=""></a></li>
                  </ul>
                </div>
            </nav>
        </div>
        <div>
            <div class="container">
                <div class="row">
                    <div class="col s2"></div>
                    <div class="col s8">
                        <h3  class="blue-text text-darken-4" id="Tlogin">Bienvenido al Sistema</h3>
                        <br>
                        <br>
                        <br>
                        <p  class="blue-text text-darken-4">Ingrese su usuario y contraseña</p>
                    </div>
                    <div class="col s2"></div>
                </div>
                <div class="row">
                    <form class="col s12" action="sesionUsuario" method="post">
                        <div class="row">
                            <div class="col s3"></div>
                            <div class="input-field col s3">
                              <input  id="txtCuenta" name="txtCuenta" type="text" class="validate">
                              <label for="cuenta">usuario</label>
                            </div>          
                            <div class="input-field col s3">
                              <input id="password" type="password" class="validate" name="txtContra">
                              <label for="password">contraseña</label>
                            </div>
                            <div class="col s3"></div>
                        </div> 
                        <div class="row">
                            <div class="col s4"></div>
                                <div class="col s4" align="center">
                                        <button class="btn waves-effect light-blue darken-4" type="submit" name="btnIngresar" value="Ingresar">
                                            Ingresar
                                        </button>
                                        <button class="btn waves-effect light-blue darken-4" type="reset" name="btnCancelar" value="Cancelar">
                                            Cancelar
                                        </button>                                    
                                </div>
                            <div class="col s4"></div>
                        </div>                    
                    </form>
                </div>
            </div>
        </div>
        </main>
    </body>
    <%@include file="footer.jsp" %>
</html>
