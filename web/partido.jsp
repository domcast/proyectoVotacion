<%-- 
    Document   : partido
    Created on : 12-oct-2017, 9:36:50
    Author     : pedro
--%>

<%@page import="com.modelo.Partido"%>
<%@page import="java.util.List"%>
<%@page import="com.modelo.crudPartido"%>
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
    </head>
    <script>
        
        function cargarDatos(idpertido, nombre,ban)
            {
                document.partido.idPartido.value=idpertido;
                document.partido.nombre.value=nombre;
                document.partido.imgen.value=ban
               
                
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
            <script>
                function mostrar(el){
                        var file=el.files[0];
                        var hid=document.partido.imgen;
                        hid.value=file.name;
                        
                    }
            </script>
                
    
     <script>
                    
                    
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
                
                
                <%
                
crudPartido crud=new crudPartido();

                %>
    <body>
        <form action="procPartido" method="POST" name="partido" >
        <h1>Partido</h1>
        <table border="1">
            <tr>
                <td>Codigo Partido:</td>
                <td><input type="number" name="idPartido"></td>
            </tr>
            <tr>
                <td>Nombre Partido</td>
                <td><input type="text" name="nombre"></td>
                
            </tr>
            <tr>
                <td>Imegen de partido:</td>
                <td><input type="file"   onchange="mostrar(this)" name="foto"></td>
                              <input type="hidden" name="imgen">
                
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
        </form>
        <table border="1">
            <thead>
            <th>Codigo</th>
            <th>Nombre</th>
            <th>Bandera</th>
            <th>Seleccionar</th>
            </thead>
            <tbody>
                <%
                    List<Partido> par=crud.mostrarPartido();
                    for(Partido pa:par)
                    {
                    %>
                <tr>
                    <td><%= pa.getIdPartido()  %></td>
                    <td><%= pa.getParNombre()  %></td>
                    <td><img src="img/partido/<%= pa.getBandera() %>  " width="40px" height="40px"  ></td>
                    <td><a href="javascript:cargarDatos(<%= pa.getIdPartido() %>,'<%= pa.getParNombre()  %>','<%= pa.getBandera() %>')">Seleccionar</a></td>
                </tr>
                <% } %>
                
            </tbody>
            
        </table>
    </body>
</html>
<% 
}else{
    response.sendRedirect("loguin.jsp");
}
%>