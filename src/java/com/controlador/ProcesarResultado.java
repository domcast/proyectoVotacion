package com.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.modelo.*;
/**
 *
 * Nombre del Servlet: ProcesarResultado
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
public class ProcesarResultado extends HttpServlet {

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
        
        Resultado re=new Resultado();
        CrudResultado cr=new CrudResultado();
        String val=null;
        
        try 
        {
            re.setIdResultado(Integer.parseInt(request.getParameter("txtId")));
            re.setIdCandidato(new Candidato(Integer.parseInt(request.getParameter("candidato"))));
            re.setTotalVotos(Double.parseDouble(request.getParameter("txtvotos")));
            re.setResultado(request.getParameter("txtResultado"));
            
            if(request.getParameter("btnInsertar")!=null)
            {
                cr.insertar(re);
                val="resultado nuevo";
            }else if(request.getParameter("btnModificar")!=null){
                cr.modificar(re);
                val="resultado modificado";
            }else if(request.getParameter("btnElimibar")!=null)
            {
                cr.eliminar(re);
                val="resulatdo eliminado";
            }
            
            request.getSession().setAttribute("valor", val);
            response.sendRedirect("resultado.jsp");
        }
        catch (Exception e)
        {
            
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