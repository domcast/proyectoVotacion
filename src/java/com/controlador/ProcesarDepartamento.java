package com.controlador;

import com.modelo.CrudDepartamento;
import com.modelo.Departamento;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Nombre del Servlet: ProcesarDepartamento
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
public class ProcesarDepartamento extends HttpServlet {

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
        CrudDepartamento cdep=new CrudDepartamento();
        String val=null;
        
        try {
            dep.setIdDepartamento(Integer.parseInt(request.getParameter("txtidDep")));
            dep.setNombreDep(request.getParameter("txtNombreDep"));
            dep.setCupos(Integer.parseInt(request.getParameter("txtCupos")));
            
            if(request.getParameter("btnInsertar")!=null){
                cdep.insertarDepartamento(dep);
                val="Datos Ingresados Correctamente";
            }
            else if(request.getParameter("btnModificar")!=null){
                cdep.modificarDepartamento(dep);
                val="Datos Modificados correctamente";
            }
            else if(request.getParameter("btnEliminar")!=null){                
                cdep.eliminarDepartamento(dep);
                val="Datos Eliminados correctamente";
            }
            
            request.getSession().setAttribute("valor", val);
            response.sendRedirect("Departamento.jsp");
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