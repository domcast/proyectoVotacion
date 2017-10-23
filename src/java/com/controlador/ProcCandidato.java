
package com.controlador;

import com.modelo.Candidato;
import com.modelo.CrudCandidato;
import com.modelo.Partido;
import com.modelo.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Nombre del Servlet: ProcCandidato
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
public class ProcCandidato extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        CrudCandidato crud = new CrudCandidato();
        Candidato ca = new Candidato();
        String mensaje=null;
        
        try {
            ca.setIdCandidato(Integer.parseInt(request.getParameter("idCandidato")));
            ca.setPersona(new Persona(Integer.parseInt(request.getParameter("idPersona"))));
            ca.setPartido(new Partido(Integer.parseInt(request.getParameter("partido"))));
            ca.setFoto(request.getParameter("img1"));
            if(request.getParameter("insertar")!=null)
            {
                crud.insertarCandidato(ca);
                mensaje="Datos insertados con exito";
            }
            else if(request.getParameter("modificar")!=null)
            {
                crud.modificarCandidato(ca);
                mensaje="Datos modificados correctamente";
            }
            else if(request.getParameter("eliminar")!=null){
                crud.eliminarCandidato(ca);
                mensaje="datos eliminados";
            }
            request.getSession().setAttribute("mensaje",mensaje);
            response.sendRedirect("candidato.jsp");
        } catch (Exception e) {
            out.print(e.toString());
            request.setAttribute("error", e.toString());
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
