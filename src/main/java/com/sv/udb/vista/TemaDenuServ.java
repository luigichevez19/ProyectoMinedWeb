package com.sv.udb.vista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sv.udb.controlador.TemasCtrl;
import com.sv.udb.modelo.Temas;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Walter
 */
@WebServlet(urlPatterns = {"/TemaDenuServ"})
public class TemaDenuServ extends HttpServlet {

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
             response.sendRedirect(request.getContextPath()+"/TemaDenu.jsp");
        }
        else
        {
            String CRUD = request.getParameter("btnTema");
            if (CRUD.equals("Guardar"))
            {
                 Temas obj = new Temas();
                 obj.setTema(request.getParameter("tema"));
                 if (new TemasCtrl().guarTema(obj)) 
                 {
                     mens = "Guardado";
                 }
                 else
                 {
                     mens = "Error Guardado";
                 }

             }
            if (CRUD.equals("Actualizar"))
            {
                 Temas obj = new Temas();
                 obj.setIdTema(Integer.parseInt(request.getParameter("codi").isEmpty()?"-1":request.getParameter("codi")));
                 obj.setTema(request.getParameter("tema"));
                 if (new TemasCtrl().editTema(obj)) 
                 {
                     mens = "Actualizado";
                 }
                 else
                 {
                     mens = "Error al actualizar";
                 }

             }
            if (CRUD.equals("Eliminar"))
            {
                 Temas obj = new Temas();
                obj.setIdTema(Integer.parseInt(request.getParameter("codiTemaRadi").isEmpty()?"-1":request.getParameter("codiTemaRadi")));
                if (new TemasCtrl().elimTema(obj.getIdTema())) 
                 {
                     mens = "Eliminar";
                 }
                 else
                 {

                     mens = "Error al eliminar";
                 }

             }
            if(CRUD.equals("Consultar"))
            {
                int codi = Integer.parseInt(request.getParameter("codiTemaRadi").isEmpty()?"-1":request.getParameter("codiTemaRadi"));
                Temas obje = new TemasCtrl().consUno(codi);

                if(obje != null)
                {
                     request.setAttribute("codi", obje.getIdTema());
                     request.setAttribute("tema", obje.getTema());
                }
                else
                 {
                     mens = "Error al consultar";
                 }

            }
                 request.setAttribute("mensAlert", mens);
                 request.getRequestDispatcher("/TemaDenu.jsp").forward(request, response);
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
