package com.controlador;
import com.controlador.*;
import com.modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Nombre del Servlet: ProcesarPersona
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
public class ProcesarPersona extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Persona per = new Persona();
        Municipio muni = new Municipio();
        CrudPersona cper = new CrudPersona();
        String val=null;
        
        try 
        {
            per.setIdPersona(Integer.parseInt(request.getParameter("txtCodigoP")));
            per.setNombre(request.getParameter("txtNombreP"));
            per.setApellidos(request.getParameter("txtApellido"));
            per.setDui(request.getParameter("txtDUI"));
            per.setEdad(Integer.parseInt(request.getParameter("txtEdad")));
            per.setGenero(request.getParameter("genero"));
            per.setMunicipio(new Municipio(Integer.parseInt(request.getParameter("municipio"))));
            
            if(request.getParameter("btnInsertar")!=null)
            {
                cper.insertarPersona(per);
                val="Datos Ingresados Correctamente";
            }
            else if(request.getParameter("btnModificar")!=null)
            {
                cper.modificarPersona(per);
                val="Datos Modificados correctamente";
            }
            else if(request.getParameter("btnEliminar")!=null)
            {                
                cper.eliminarPersona(per);
                val="Datos Eliminados correctamente";
            }
            
            request.getSession().setAttribute("valor", val);
            
            response.sendRedirect("Persona.jsp");
        } 
        catch (Exception e) 
        {
            request.setAttribute("Error", e.toString());
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
