<%-- 
    Document   : Persona
    Created on : 10-07-2017, 02:45:59 PM
    Author     : Carlos
--%>
<% 
        response.setHeader("Cache-Control","no-store");
        HttpSession obj=request.getSession(false);
        String usuario=(String) obj.getAttribute("cuenta");
        String contra=(String) obj.getAttribute("contra");
        
        if(usuario!=null && contra!=null)
        {
            
        
%>
<%@page import="java.util.*" %>
<%@page import="com.modelo.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="links.jsp" %>
        <title>JSP Page</title>
        <script>
           $( document ).ready(function(){
     $('select').material_select();
    
     }); 
        </script>
        <script>
            function cargarDatos(txtCodigoP,txtNombreP,txtApellido,txtDUI,txtEdad,genero,municipio)
            {
                $('#txtCodigoP').val(txtCodigoP);
                $('#txtNombreP').val(txtNombreP);
                $('#txtApellido').val(txtApellido);
                $('#txtDUI').val(txtDUI);
                $('#txtEdad').val(txtEdad);
                $('#municipio').val(municipio);

                if (genero=='Masculino') {
                    $('#masc').attr('checked', 'true');
                }else if (genero=='Femenino') {
                    $('#fem').attr('checked', 'true');
                }
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
        <%
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
    </head>
    <%
        CrudPersona cper = new CrudPersona();
    %>
    <body>
        <main>
            <%@include file="menuPrin.jsp" %>
            <div class="container">
                <div class="row">
                    <div class="col s1"></div>
                    <div class="col s10">
                        <h2 class="blue-text text-darken-4" id="Tlogin">Mantenimiento de Persona</h2>
                        <div class="row">
                            <form class="col s12" action="procesarPersona" method="POST" name="frmPersona">
                                
                                <div class="row">
                                    <div class="input-field col s4">
                                        <input type="text" name="txtCodigoP" id="txtCodigoP" class="validate" >
                                        <label for="txtCodigoP" data-error="wrong" data-success="right">Codigo</label>
                                    </div> 
                                    <div class="input-field col s4">
                                      <input type="text" name="txtNombreP" id="txtNombreP" placeholder="" class="validate" >
                                      <label for="txtNombreP" data-error="wrong" data-success="right">Nombre</label>
                                    </div>
                                    <div class="input-field col s4">
                                      <input type="text" name="txtApellido" id="txtApellido" class="validate" >
                                      <label for="txtApellido" data-error="wrong" data-success="right">Apellido</label>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="input-field col s6">
                                        <input type="text" name="txtDUI" id="txtDUI" class="validate" >
                                        <label for="txtDUI" data-error="wrong" data-success="right">Dui</label>
                                    </div> 
                                    <div class="input-field col s3">
                                      <input type="number" name="txtEdad" id="txtEdad" class="validate" >
                                      <label for="txtEdad" data-error="wrong" data-success="right">Edad</label>
                                    </div>
                                    <div class="input-field col s3">
                                      <select name="municipio" id="selectMuni" >
                                            <option value="" disabled selected>Escoja una opcion</option>
                                            <%
                                                List<Municipio>ls = cper.listaMunicipio();
                                                for(Municipio mun:ls)
                                                {
                                            %>
                                            <option value="<%= mun.getIdMunicipio() %>"><%= mun.getNombreMuni()%></option>
                                            <%
                                                }
                                            %>
                                        </select>  
                                    </div>
                                </div>
                                    <div class="row">
                                    <div class=" col s6">
                                        <div class="center">
                                            <br>
                                            <input class="with-gap" name="genero" type="radio" id="masc" value="Masculino"/>
                                            <label for="masc">Masculino</label>
                                            
                                            <input class="with-gap" name="genero" type="radio" id="fem" value="Femenino" checked=""/>
                                           <label for="fem">Femenino</label>
                                      </div>
                                    </div> 
                                    <div class="input-field col s3"></div>
                                    <div class="input-field col s3" >
                                      <input class="btn" type="submit" name="btnInsertar" value="Insertar">
                                    </div>
                                </div>
                                     <div class="row">
                                         <div class="col s1"></div>
                                         <div class="col s10">
                                             
                                          <input class="btn" type="submit" name="btnModificar" value="Modificar" onclick="return modificar()">
                                                <input class="btn" type="submit" name="btnEliminar" value="Eliminar" onclick="return eliminar()">
                                                <input class="btn" type="reset" name="btnCancelar" value="Cancelar">   
                                         </div>
                                         <div class="col s1"></div>
                                     </div>
                            </form>
                        </div>
                    </div>
                    <div class="col s1"></div>
                </div>
                
              <div class="row">
                  <div class="col s1"></div>
                  <div class="col s10">
                      <table class="responsive-table centered">
                            <thead>
                                <tr>
                                    <th>Codigo Persona</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>DUI</th>
                                    <th>Edad</th>
                                    <th>Genero</th>
                                    <th>Municipio</th>
                                    <th>Seleccionar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    List<Persona>ls2=cper.mostrarPersona();
                                    for(Persona pe:ls2)
                                    {
                                %>
                                <tr>
                                    <td><%= pe.getIdPersona() %></td>
                                    <td><%= pe.getNombre() %></td>
                                    <td><%= pe.getApellidos() %></td>
                                    <td><%= pe.getDui() %></td>
                                    <td><%= pe.getEdad() %></td>
                                    <td><%= pe.getGenero() %></td>
                                    <td><%= pe.getMunicipio().getNombreMuni()%></td>
                                    <td><a href="javascript:cargarDatos(<%= pe.getIdPersona() %>,'<%= pe.getNombre() %>','<%= pe.getApellidos() %>','<%= pe.getDui() %>','<%= pe.getEdad() %>','<%= pe.getGenero() %>','<%= pe.getMunicipio().getIdMunicipio() %>')">Seleccionar</a></td>
                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                  </div>
                  <div class="col s1"></div>
              </div>
            </div>
        </main>
    </body>
    <%@include file="footer.jsp" %>
</html>
<% 
}else{
    response.sendRedirect("loguin.jsp");
}
%>