/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.DenunciasCtrl;
import com.sv.udb.modelo.Denuncias;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Walter
 */
@WebServlet(name = "DenunciasServ", urlPatterns = {"/DenunciasServ"})
public class DenunciasServ extends HttpServlet {

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
            response.sendRedirect(request.getContextPath()+"/Denuncias.jsp");
       }
       else
       {
           String CRUD = request.getParameter("btnEqui");
           if (CRUD.equals("Guardar"))
           {
                String acci = "";
                Denuncias obj = new Denuncias();
                String nomb, edad, genero, tele, tema, auto, inst;
                int accion;
                accion = Integer.parseInt(request.getParameter("cmbAccion"));
                
                if(accion > 0){
                    nomb = request.getParameter("vict");
                }
               
                if (!request.getParameter("vict").isEmpty()) {
                   nomb = request.getParameter("vict");
                }
                if (!request.getParameter("edad").isEmpty()) {
                   edad = request.getParameter("edad");
                }
                if (!request.getParameter("genero").isEmpty()) {
                   genero = request.getParameter("genero");
                }
                if (!request.getParameter("tele").isEmpty()) {
                   tele = request.getParameter("tele");
                }
                if (!request.getParameter("cmbTema").isEmpty()) {
                   tema = request.getParameter("cmbTema");
                }
                if (!request.getParameter("cmbAuto").isEmpty()) {
                   auto = request.getParameter("cmbAuto");
                }
                if (!request.getParameter("cmbInst").isEmpty()) {
                   inst = request.getParameter("cmbInst");
                }
               
if (new DenunciasCtrl().guarDenu(obj, acci)) 
{
    mens = "Guardado";
}
else
{
    mens = "Error Guardado";
}
               
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
