<%-- 
    Document   : resultados
    Created on : 12-oct-2017, 5:36:41
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
<%@page import="com.modelo.*" %>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultados</title>
        <script>
            
            function cargar(id,candi, voto, resu)
            {
                document.frmResultados.txtId.value=id;
                document.frmResultados.candidato.value=candi;
                document.frmResultados.txtvotos.value=voto;
                document.frmResultados.txtResultado.value=resu;
                
            }
            
            function modificar()
            {
                if(confirm("¿Desea modifiar los datos?"))
                {
                    return true;
                }
                else 
                {
                    return false;
                }
            }
            
            function eliminar()
            {
                if(confirm("¿Desea eliminar los datos?"))
                {
                    return true;
                }
                else 
                {
                    return false;
                }
            }
            
        </script>
    </head><%
            if(request.getSession().getAttribute("valor")!=null)
            {
        %>
        <script>
            alert('<%= request.getSession().getAttribute("valor") %>')
        </script>
        <%
            request.getSession().setAttribute("valor", null);
            }
        %>
    <% CrudResultado cr=new CrudResultado(); %>
    <body>
    <center>
        <h1>Gestion de Resultados</h1>
        <form action="procesarResultado" method="post" name="frmResultados">
            <table>
                <tr>
                    <td>Id Resultados</td>
                    <td><input type="text" name="txtId"></td>
                </tr>
                <tr>
                    <td>Candidato</td>
                    <td>
                        <select name="candidato">
                            <% List<Candidato> can=cr.mostrarpersona();
                                for(Candidato c:can)
                                {
                                    %>
                                    <option value="<%= c.getIdCandidato() %>"><%= c.getPersona().getNombre() %></option>            
                                    <%
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Total votos</td>
                    <td><input type="text" name="txtvotos"></td>
                </tr>
                <tr>
                    <td>Resultados</td>
                    <td><input type="text" name="txtResultado"></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="btnInsertar" value="Insertar" >
                        <input type="submit" name="btnModificar" value="Modificar" onclick="return modificar()">
                        <input type="submit" name="btnElimibar" value="Elimniar" onclick="return eliminar()">
                        <input type="reset" values='limpiar'>
                    </td>
                </tr>
            </table>
        </form>
                        <table border='1'>
                            <tr>
                                <td>Id Resultado</td>
                                <td>Candidato</td>
                                <td>Puntaje</td>
                                <td>Resultado</td>
                                <td>Seleccione</td>
                            </tr>
                            <tr>
                                <%
                                    List<Resultado> res=cr.mostrarResultado();
                                    for(Resultado r:res)
                                    {
                                        %>
                                        <td><%= r.getIdResultado() %></td>
                                        <td><%= r.getIdCandidato().getIdCandidato()%></td>
                                        <td><%= r.getTotalVotos() %></td>
                                        <td><%= r.getResultado() %></td>
                                        <td><a href="javascript:cargar(<%= r.getIdResultado() %>,<%= r.getIdCandidato().getIdCandidato()%>,<%= r.getTotalVotos() %>,'<%= r.getResultado() %>')">Seleccionar</a></td>
                                        </tr>
                                        <%
                                    }
                                %>
                            
                        </table>
    </center>
    </body>
</html>
<% 
}else{
    response.sendRedirect("loguin.jsp");
}
%>