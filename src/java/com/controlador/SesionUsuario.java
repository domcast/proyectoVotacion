package com.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.logging.Logger;
import java.util.logging.Level;
import com.modelo.LoguinUsuarios;
import com.modelo.Usuario;
import javax.servlet.http.HttpSession;

/**
 * Nombre del Servlet: SesionUsuario
 * fecha de creacion: 07/10/2017
 * copyrigth: Magnos Enterprise. Todos los derechos reservados
 * version:1.0
 * @author Carlos, Luis, Zamora, Pedro, Fernando
 */

public class SesionUsuario extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            Usuario us=new Usuario();
            us.setCuenta(request.getParameter("txtCuenta"));
            us.setContrasenia(request.getParameter("txtContra"));
            LoguinUsuarios lo=new LoguinUsuarios();            
        if(request.getParameter("btnIngresar")!=null)
        {
            if(lo.ValidarUsuario(us)==1)
            {
                HttpSession obj=request.getSession(false);
                HttpSession obj2=request.getSession(false);
                obj.setAttribute("cuenta", us.getCuenta());
                obj2.setAttribute("contra", us.getContrasenia());
                HttpSession obj3=request.getSession(false);
                obj3.setAttribute("cargo","Administrador");
                response.sendRedirect("admin.jsp");
            }else if(lo.ValidarUsuario(us)==2)
            {
                 HttpSession obj=request.getSession(false);
                HttpSession obj2=request.getSession(false);
                obj.setAttribute("cuenta", us.getCuenta());
                obj2.setAttribute("contra", us.getContrasenia());
                HttpSession obj3=request.getSession(false);
                obj3.setAttribute("cargo","Supervisor");
                
                response.sendRedirect("supervisor.jsp");
            }else if(lo.ValidarUsuario(us)==3)
            {
                HttpSession obj=request.getSession(false);
                HttpSession obj2=request.getSession(false);
                obj.setAttribute("cuenta", us.getCuenta());
                obj2.setAttribute("contra", us.getContrasenia());
                HttpSession obj3=request.getSession(false);
                obj3.setAttribute("cargo","Analista");
                
                response.sendRedirect("analista.jsp");
            }else{
                response.sendRedirect("UsuarioNoEncontrado.jsp");
            }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SesionUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SesionUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
