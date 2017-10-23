
package com.controlador;


import com.modelo.*;
import com.modelo.Persona;
import com.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pedro
 */
public class ProcUsuario extends HttpServlet {

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
        
        CrudUsuario crud = new CrudUsuario();
        Usuario us=new Usuario();
        String mensaje=null;
        String contra1=null;
        String contra2=null;
        
        
         try {
              us.setIdUsurio(Integer.parseInt(request.getParameter("idUsuario")));
                     us.setCuenta(request.getParameter("cuenta"));
                     us.setContrasenia(request.getParameter("contra1"));
                     us.setCargo(Integer.parseInt(request.getParameter("cargo")));
                     us.setIdPersona(new Persona(Integer.parseInt(request.getParameter("idPersona"))));
                     
             if(request.getParameter("insertar") !=null)
             {
                    
                     crud.insertarUsuario(us);
                     mensaje ="Datos ingresados correctamente";
        
                 
                 
             } else  if(request.getParameter("modificar") !=null)
             {
                 
               
                     crud.modificarUsuario(us);
                     mensaje="Datos modificados con exito";
                 
             }else if(request.getParameter("eliminar")!=null)
             {
                 
                
                     crud.EliminarUsuario(us);
                     mensaje="usuario Eliminado con exito";
             }
             
             request.getSession().setAttribute("mensaje", mensaje);
            response.sendRedirect("usuario.jsp");
        } catch (Exception e) {
            
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

