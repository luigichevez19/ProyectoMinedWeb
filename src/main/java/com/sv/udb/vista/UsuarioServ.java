/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.CtrlUsuarios;
import com.sv.udb.modelo.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oscar
 */
@WebServlet(name = "UsuarioServ", urlPatterns = {"/UsuarioServ"})
public class UsuarioServ extends HttpServlet {

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
        boolean esValido= request.getMethod().equals("POST");
        String mens= "";
        if(!esValido)
        {
            response.sendRedirect(request.getContextPath()+ "/Usuarios.jsp");
        }
        else
        {
            String crud = request.getParameter("btnUsua");
          
           // obtains the upload file part in this multipart request
               
            if(crud.equals("Guardar"))
            {
                
                if(!request.getParameter("nombre").isEmpty() && !request.getParameter("usuario").isEmpty() && !request.getParameter("apellido").isEmpty() && !request.getParameter("contra").isEmpty())
                {
                     Usuarios obje = new Usuarios();
                     obje.setUsuario(request.getParameter("usuario"));
                     obje.setNombres(request.getParameter("nombre"));
                     obje.setApellidos(request.getParameter("apellido"));
                     obje.setContra(request.getParameter("contra"));
                                             
    
                    /////////////////////////////////////

                    if(new CtrlUsuarios().guarUsu(obje))
                    {
                           mens= "Datos guardados";
                    }
                    else
                    {
                           mens= "Error al guardar";
                    }
                }
                else
                {
                     mens= "No ha ingresado todos los datos";
                }
                
             
            }
            else if(crud.equals("Consultar"))
            {
                
                int codi= Integer.parseInt(request.getParameter("codiUsuaRadi") == null ? "-1" : request.getParameter("codiUsuaRadi"));
                Usuarios obje = new CtrlUsuarios().consUno(codi);
               
                if(obje.getIdUsuario()!= 0)
                {
                    request.setAttribute("codi", obje.getIdUsuario());
                    request.setAttribute("usuario", obje.getUsuario());
                request.setAttribute("nombre", obje.getNombres());
                request.setAttribute("apellido", obje.getApellidos());
                
                
                request.setAttribute("accion", "Editar");
                }
                else
                {
                    mens = "Error al consultar"; 
                }
                
                
            }
            else if(crud.equals("Editar"))
            {
                
                 Usuarios obje = new Usuarios();
                 obje.setIdUsuario(Integer.parseInt(request.getParameter("codi").isEmpty() ? "-1" : request.getParameter("codi")) );
             obje.setUsuario(request.getParameter("usuario")); 
             obje.setNombres(request.getParameter("nombre"));
             obje.setApellidos(request.getParameter("apellido"));             
            
             
             if(new CtrlUsuarios().editarUsu(obje))
             {
                 mens= "Datos Editados";
             }
             else
             {
                 mens= "Error al editar";
             }
            }
            if(crud.equals("Eliminar"))
            {
                
             if(new CtrlUsuarios().eliminarUsu(Integer.parseInt(request.getParameter("codi").isEmpty() ? "-1" : request.getParameter("codi"))))
             {
                 mens= "Datos Eliminados";
             }
             else
             {
                 mens= "Error al Eliminar";
             }
            }
            
            request.setAttribute("mensAlert", mens);
             request.getRequestDispatcher("/usuarios.jsp").forward(request, response);
           
             
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
