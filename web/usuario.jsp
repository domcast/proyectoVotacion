<%-- 
    Document   : usuario
    Created on : 11-oct-2017, 15:16:25
    Author     : pedro
--%>

<%@page import="com.modelo.Persona"%>
<%@page import="com.modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="com.modelo.CrudUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
        response.setHeader("Cache-Control","no-store");
        HttpSession obj=request.getSession(false);
        String usuario=(String) obj.getAttribute("cuenta");
        String contra=(String) obj.getAttribute("contra");
        
        if(usuario!=null && contra!=null)
        {
            
        
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            CrudUsuario crud=new CrudUsuario();
        %>
    </head>
            <script>
            
            function cargarDatos(idUsuario,cuenta,contrasenia,idCargo,idNombre,)
            {
                document.usuario.idUsuario.value=idUsuario;
                document.usuario.cuenta.value=cuenta;
                document.usuario.contra1.value=contrasenia;
                
                document.usuario.cargo.value=idCargo;
                document.usuario.idPersona.value=idNombre;
                
            }
            
            
            
            function confirmar()
            {
                if(confirm("Esta seguro de realixar esta accion"))
                {
                    return true;
                }else
                {
                    return false;
                }
            }
            
        </script>
    
    
    
    <% if(request.getSession().getAttribute("mensaje") !=null)
            {
               
            %>
        <script>
           alert('<%= request.getSession().getAttribute("mensaje") %>');
            </script>
            <%
                }
            %>
    <body>
        <h1>Usuario</h1>
        <form action="procUsuario" method="POST" name='usuario'>
            
           
    
            <table border="1">
                <tr>
                    <td>Codigo Usuario:</td>
                    <td><input type="number" name="idUsuario"></td>
                </tr>
            
          
                <tr>
                    <td>Cuenta:</td>
                    <td><input type="text" name="cuenta"></td>
                </tr>
                <tr>
                    <td>Contraña:</td>
                    <td><input type="Password" name="contra1"></td>
                </tr>
            
          
            
            
                <tr>
                    <td>Cargo:</td>
                    <td> <select name="cargo">
                    <option value='1'>Administraador </option>
                    <option value='2'>Supervisor </option>
                    <option value="3">Analista</option>
                        </select></td>
            </tr>
            
            <tr>
                <td>Nombre:</td>
                <td>
                <select name="idPersona">
                    <% 
                    List<Persona>pers=crud.mostrarPersona();
                    for(Persona per:pers)
                    {
                    %>
                    <option value="<%= per.getIdPersona() %>"> <%= per.getNombre() %>  <%= per.getApellidos() %></option>
                    <% }  %>
                </select></td>
                
                </tr>
           
                <tr>
                    <td colspan="2">
            <input type="submit" value="Ingresar" name="insertar">     
            <input type="submit" name="modificar" value="Modificar" onclick="return confirmar()">   
            <input type="submit" name="eliminar" value="Eliminar" onclick="return confirmar()">  
             <input type="reset" name="limpiar" value="Limpiar"> 
                    </td>
             </tr>
            </table>
            </table>
            <table border='1'>
                <thead>
                <th>Codigo Usuario</th>
                <th>Nombre</th>
                <th>Cuenta</th>
                <th>Seleccionar</th>
                </thead>
                <tbody>
                    <% 
                    List<Usuario>user=crud.mostrarUsuario();
                    for(Usuario us:user)
                    {
                    %>
                    <tr>
                <td><%= us.getIdUsurio() %></td>
                <td><%= us.getIdPersona().getNombre() %> <%= us.getIdPersona().getApellidos()  %></td>
                <td><%= us.getCuenta() %></td>
                <td><a href="javascript:cargarDatos(<%= us.getIdUsurio() %>,'<%=  us.getCuenta() %>','<%= us.getContrasenia() %>',<%= us.getCargo() %>,<%= us.getIdPersona().getIdPersona() %>)">Seleccionar</a></td>
                    </tr>
                <%
                    }
                    %>
                </tbody>
            </table>
             
        </form>
    </body>
</html>


<% 
}else{
    response.sendRedirect("loguin.jsp");
}
%>