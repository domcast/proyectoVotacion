/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.Contrasenia;
import com.modelo.CrudContrasenia;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Nombre del Servlet: ProcesarContrasenia
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */
public class ProcesarContrasenia extends HttpServlet {
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
        
        Contrasenia con=new Contrasenia();
        CrudContrasenia cc = new CrudContrasenia();
        String val=null;
        try 
        {
            con.setIdContrasenia(Integer.parseInt(request.getParameter("txtId")));
            con.setContrasenia(request.getParameter("txtContra1"));
            con.setEstado(Integer.parseInt(request.getParameter("estado")));
            
            if(request.getParameter("btnEnviar")!=null)
            {
                cc.insertarcontra(con);
                val="contrasenia nueva";
            }else if(request.getParameter("btnModificar")!=null)
            {
                cc.modificarPersona(con);
                val="contrasenia actualizada";
            }else if(request.getParameter("btnEliminar")!=null){
                    cc.eliminar(con);
                            val="contrasenia elimanda";
        }
            request.getSession().setAttribute("valor", val);
            response.sendRedirect("contrasenia.jsp");
            
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
