/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.InstitucionCtrl;
import com.sv.udb.modelo.Institucion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luis
 */
@WebServlet(name = "InstitucionesServ", urlPatterns = {"/InstitucionesServ"})
public class InstitucionesServ extends HttpServlet {

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
            response.sendRedirect(request.getContextPath()+"/Instituciones.jsp");
       }
       else
       {
            String CRUD = request.getParameter("btnInsti");
                      
           if (CRUD.equals("Guardar"))
           {
               Institucion obj = new Institucion();
               obj.setNomb(request.getParameter("nomb"));
               obj.setCorreo(request.getParameter("correo"));
               obj.setDireccion(request.getParameter("dire"));
               obj.setMunicipio(Integer.parseInt( request.getParameter("cmbMuni")));
               obj.setEstado(true);
                if (new InstitucionCtrl().guar(obj)) 
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
               Institucion obj = new Institucion();
               obj.setCodigo(Integer.parseInt(request.getParameter("codi")));
               obj.setNomb(request.getParameter("nomb"));
               obj.setCorreo(request.getParameter("correo"));
               obj.setDireccion(request.getParameter("dire"));
               obj.setMunicipio(Integer.parseInt( request.getParameter("cmbMuni")));
                if (new InstitucionCtrl().actu(obj)) 
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
                Institucion obj = new Institucion();
               obj.setCodigo(Integer.parseInt(request.getParameter("codi_muni").isEmpty()?"-1":request.getParameter("codi_muni")));
                for(Institucion temp: new InstitucionCtrl().consEstado(obj))
                {
                  obj.setEstado((temp.getEstado())?false:true);
                                     
                }
               if (new InstitucionCtrl().elim(obj)) 
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
               int codi = Integer.parseInt(request.getParameter("codi_muni").isEmpty()?"-1":request.getParameter("codi_muni"));
               Institucion obje = new InstitucionCtrl().consUno(codi);
             
               if(obje != null)
               {
                    request.setAttribute("codi", obje.getCodigo());
                    request.setAttribute("nomb", obje.getNomb());
                    request.setAttribute("dire", obje.getDireccion());
                    request.setAttribute("correo", obje.getCorreo());
                    request.setAttribute("id_muni", obje.getMunicipio());
                             
               }
               else
                {
                    mens = "Error al consultar";
                }
               
           }
            request.setAttribute("mensAlert", mens);
            request.getRequestDispatcher("/Instituciones.jsp").forward(request, response);
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
