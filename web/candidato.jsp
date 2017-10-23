<%-- 
    Document   : Candidato
    Created on : 10-oct-2017, 22:51:18
    Author     : pedro
--%>
<% 
        response.setHeader("Cache-Control","no-store");
        HttpSession obj=request.getSession(false);
        String usuario=(String) obj.getAttribute("cuenta");
        String contra=(String) obj.getAttribute("contra");
        
        if(usuario!=null && contra!=null)
        {
            
        
%>
<%@page import="com.modelo.Persona"%>
<%@page import="com.modelo.Partido"%>
<%@page import="com.modelo.Candidato"%>
<%@page import="java.util.List"%>
<%@page import="com.modelo.CrudCandidato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            
            function cargarDatos(idCandidato, idPersona, partido, img1)
            {
                document.candidato.idCandidato.value=idCandidato;
                document.candidato.idPersona.value=idPersona;
                document.candidato.partido.value=partido;
                document.candidato.img1.value=img1;
                document.candidato.img2.value=img1;
                
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
                
                <script>
                    function mos(ele){
                        var file=ele.files[0];
                        var hid=document.candidato.img1;
                        hid.value=file.name;
                        
                    }
                    
                    
                </script>
                
    </head>
    <%
        CrudCandidato crud= new CrudCandidato();
        %>
    <body>
        <h1>Candidato</h1>
        
        <form  name="candidato" action="procCandidato" method="POST">
            
            
            <table border="1">
                <tr>
       
          <td>Codigo Candidato</td>
          <td><input type="number" name="idCandidato" required></td>
            </tr>
  
        
            <tr>
                <td>nombre de Candidato: </td> 
                <td>
            <select name="idPersona">
                <%
                    List<Persona>pers=crud.mostrarPersona();
                    for(Persona per:pers)
                    {
                    %>
                    <option value="<%= per.getIdPersona()  %>"> <%= per.getNombre() %>   <%=  per.getApellidos() %> </option>
        
                    <% }  %>
            </select></td>
            </tr>
        
        
            <tr>
                <td> partido: </td>
                <td>
            <select name="partido">
                 <%  
            List<Partido>part=crud.MostrarPartido();
            
            for(Partido par:part)
            {
            %>
            
            <option value="<%= par.getIdPartido() %>"> <%= par.getParNombre() %></option>
            
                <% } %>
                
            </select>
                </td>
            </tr>
        
       
            <tr>
                <td> Foto del Candidato:</td>  <td> <input  type="file" onchange="mos(this)" name="foto"></td>
              <input type="hidden" name="img1">
              </tr>
        
              <tr>
                  <td colspan="2">
             <input type="submit" value="Ingresar" name="insertar">     
             <input type="submit" name="modificar" value="Modificar" onclick="return confirmar();">   
             <input type="submit" name="eliminar" value="Eliminar" onclick="return confirmar();">  
             <input type="reset" name="limpiar" value="Limpiar">  </td>
             </tr>
         
             </table>
        </form>
               
        <table border="1">
            
                <thead>
                    <tr>
                        <th>Codigo Candidato</th>
                        <th>Nombre</th>
                        <th>Nombre de Partido</th>
                      <th>Foto</th>
                      <th>Seleccionar</th>
                      
                    </tr>
                
            </thead>
            
            <tbody>
                <% 
                    List<Candidato>can=crud.mostrarCandidato();
                    for(Candidato c:can)
                    {
                    %>
                
                    <tr>
                        <td><%=  c.getIdCandidato() %></td>
                          <td><%=  c.getPersona().getNombre() %></td>
                          <td><%=  c.getPartido().getParNombre() %></td>
                          <td><img src="img/candidatos/<%= c.getFoto()  %>" width="40px" height="40px"></td>
                          <td><a href="javascript:cargarDatos(<%= c.getIdCandidato() %>,'<%= c.getPersona().getIdPersona() %>','<%= c.getPartido().getIdPartido() %>','<%= c.getFoto() %>')">Seleccionar</td>
                    </tr>
                    
                    
                    <%
                }
                %>
                       
            </tbody>
            
            
        </table>
        
    </body>
</html>
    <% 
}else{
    response.sendRedirect("loguin.jsp");
}
%>