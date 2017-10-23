package com.controlador;

import com.modelo.CrudMunicipio;
import com.modelo.Departamento;
import com.modelo.Municipio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Nombre del Servlet: ProcesarMunicipio
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
public class ProcesarMunicipio extends HttpServlet {

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
        Departamento dep=new Departamento();
        Municipio mun=new Municipio();
        CrudMunicipio cmun=new CrudMunicipio();
        String val=null;
        try {
            mun.setIdMunicipio(Integer.parseInt(request.getParameter("txtidMun")));
            mun.setNombreMuni(request.getParameter("txtNombreMun"));
            mun.setDepartamento(new Departamento(Integer.parseInt(request.getParameter("departamento"))));
            
            if(request.getParameter("btnInsertar")!=null)
            {
                cmun.insertarMunicipio(mun);
                val="Datos Ingresados Correctamente";
            }
            else if(request.getParameter("btnModificar")!=null)
            {
                cmun.modificarMunicipio(mun);
                val="Datos Modificados correctamente";
            }
            else if(request.getParameter("btnEliminar")!=null)
            {                
                cmun.eliminarMunicipio(mun);
                val="Datos Eliminados correctamente";
            }
            
            request.getSession().setAttribute("valor", val);
            
            response.sendRedirect("Municipio.jsp");
        } catch (Exception e) {
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