/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Autoridad;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class AutoridadCtrl {
    
    public List<Autoridad> consTodo ()
    {
        List<Autoridad> resp = new ArrayList();
        Connection con = new Conexion().getConn();
            try 
            {
                PreparedStatement cmd = con.prepareStatement("select id_auto,nomb_auto, correo_auto,case estado WHEN 1 THEN 'Habilitado' WHEN  0 THEN 'Desahabilitado' END "
                + " from autoridad");
                ResultSet rs = cmd.executeQuery();
                while(rs.next())
                {
                    resp.add(new Autoridad(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
                }
            }
            catch (Exception e)
            {
                System.out.println("Erro:"+e.getMessage());
            }

        return resp;
    }
     public Autoridad consUno(int codi)
    {
        Autoridad resp = null;
        Connection con = new Conexion().getConn();
            try 
            {
                PreparedStatement cmd = con.prepareStatement("select id_auto,nomb_auto, correo_auto,case estado WHEN 1 THEN 'Habilitado' WHEN  0 THEN 'Desahabilitado' END "
                + " from autoridad where id_auto=?");
                cmd.setInt(1, codi);
                ResultSet rs = cmd.executeQuery();
                while(rs.next())
                {
                    resp=(new Autoridad(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
                }
            }
            catch (Exception e)
            {
                System.out.println("Error:"+e.getMessage());
            }

        return resp;
    }
    public List<Autoridad> consEstado(Autoridad obj)
    {
        List<Autoridad> resp = new ArrayList();
        Connection con = new Conexion().getConn();
            try 
            {
             PreparedStatement cmd = con.prepareStatement("select a.estado from autoridad a where a.id_auto=?");
             cmd.setInt(1,obj.getCodi());
             ResultSet rs = cmd.executeQuery();
             while(rs.next())
             {
                resp.add(new Autoridad(rs.getBoolean(1)));
             }
                
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,"Error:"+e.getMessage());
            }
        return resp;
    }
    public boolean guar(Autoridad obj)
    {
        boolean resp = false;
        Connection con = new Conexion().getConn();
        try 
        {
            PreparedStatement cmd = con.prepareStatement("Insert into autoridad values (null,?,?,?)");
            cmd.setString(1,obj.getNomb());
            cmd.setString(2,obj.getCorreo());
            cmd.setBoolean(3, obj.getEstado());
            cmd.executeUpdate();
            resp =true;
        }
        catch (Exception e) 
        {
            System.out.println("Error:"+e.getMessage());
        }
        return resp;
    }
      public boolean actu(Autoridad obj)
    {
        boolean resp = false;
        Connection con = new Conexion().getConn();
        try 
        {
            PreparedStatement cmd = con.prepareStatement("update autoridad set nomb_auto=?,correo_auto=? where id_auto=?");
            cmd.setString(1,obj.getNomb());
            cmd.setString(2,obj.getCorreo());
           cmd.setInt(3,obj.getCodi());
            cmd.executeUpdate();
            resp =true;
        }
        catch (Exception e) 
        {
            System.out.println("Error:"+e.getMessage());
        }
        return resp;
    }
        public boolean eliminar(Autoridad obj)
    {
        boolean resp = false;
        Connection con = new Conexion().getConn();
        try 
        {
            PreparedStatement cmd = con.prepareStatement("update autoridad set estado=? where id_auto=?");
            cmd.setBoolean(1,obj.getEstado());
            cmd.setInt(2,obj.getCodi());
            cmd.executeUpdate();
            resp =true;
        }
        catch (Exception e) 
        {
            System.out.println("Error:"+e.getMessage());
        }
        return resp;
    }
}
