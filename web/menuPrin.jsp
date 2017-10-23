<%
    HttpSession car =request.getSession(false);
    String cargo=(String) car.getAttribute("cargo");
    String link;
     if(cargo.equals("Administrador"))
     {
         link = "admin.jsp";
     }else if(cargo.equals("Analista"))
     {
         link = "analista.jsp";
     }
     
     else if(cargo.equals("Supervisor"))
     {
         link = "supervisor.jsp";
     }
     else
     {
        link = ".jsp";
     }
    %>
<div>
           <nav>
                <div class="nav-wrapper  light-blue darken-4">
                    <a href="#" class="brand-logo"><img src="img/tse.png" alt=""></a>
                  <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="<%= link %>">Menu</a></li>
                    <li><a href="loguin.jsp?cerrar=true">Cerrar Session</a></li>                    
                    <li><a href=""></a><%=cargo %></li>
                  </ul>
                </div>
            </nav>
        </div>