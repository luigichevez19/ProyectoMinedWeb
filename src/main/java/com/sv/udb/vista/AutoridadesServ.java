/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.AutoridadCtrl;
import com.sv.udb.modelo.Autoridad;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luis
 */
@WebServlet(name = "AutoridadesServ", urlPatterns = {"/AutoridadesServ"})
public class AutoridadesServ extends HttpServlet {

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
        boolean esValido = request.getMethod().equals("POST");
       String mens="";
       
       if(!esValido)
       {
            response.sendRedirect(request.getContextPath()+"/Autoridades.jsp");
       }
       else
       {
            String CRUD = request.getParameter("btnAuto");
                      
           if (CRUD.equals("Guardar"))
           {
               Autoridad obj = new Autoridad();
               obj.setNomb(request.getParameter("nomb"));
               obj.setCorreo(request.getParameter("correo"));
               obj.setEstado(true);
                if (new AutoridadCtrl().guar(obj)) 
                {
                    mens = "Guardado";
                }
                else
                {
                    mens = "Error al guardado";
                }
           }
            if (CRUD.equals("Actualizar"))
           {
               Autoridad obj = new Autoridad();
               obj.setCodi(Integer.parseInt(request.getParameter("codi")));
               obj.setNomb(request.getParameter("nomb"));
               obj.setCorreo(request.getParameter("correo"));
               if (new AutoridadCtrl().actu(obj)) 
                {
                    mens = "Actualizado";
                }
                else
                {
                    mens = "Error al actualizar";
                }
           }
           if (CRUD.equals("Modificar Estado"))
           {
                Autoridad obj = new Autoridad();
               obj.setCodi(Integer.parseInt(request.getParameter("codi_auto").isEmpty()?"-1":request.getParameter("codi_auto")));
                for(Autoridad temp: new AutoridadCtrl().consEstado(obj))
                {
                  obj.setEstado((temp.getEstado())?false:true);
                                     
                }
               if (new AutoridadCtrl().eliminar(obj)) 
                {
                    mens = "Estado Actualizado";
                }
                else
                {
               
                    mens = "Error al eliminar";
                }
               
            }
            if(CRUD.equals("Consultar"))
           {
               int codi = Integer.parseInt(request.getParameter("codi_auto").isEmpty()?"-1":request.getParameter("codi_auto"));
               Autoridad obje = new AutoridadCtrl().consUno(codi);
             
               if(obje != null)
               {
                   request.setAttribute("codi", obje.getCodi());
                   request.setAttribute("nomb", obje.getNomb());
                   request.setAttribute("correo", obje.getCorreo());          
               }
               else
                {
                    mens = "Error al consultar";
                }
               
           }
            request.setAttribute("mensAlert", mens);
            request.getRequestDispatcher("/Autoridades.jsp").forward(request, response);
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
