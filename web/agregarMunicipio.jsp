<%-- 
    Document   : agregarMunicipio
    Created on : 10-17-2017, 08:38:18 PM
    Author     : general
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <main>
            
        </main>
    </body>
</html>
<% 
}else{
    response.sendRedirect("loguin.jsp");
}
%>