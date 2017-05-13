/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Institucion;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class InstitucionCtrl {
    public List<Institucion> consTodo()
    {
        List<Institucion> resp = new ArrayList();
        Connection con = new Conexion().getConn();
            try 
            {
             PreparedStatement cmd = con.prepareStatement("select ins.id_inst,ins.nomb_inst,ins.correo_inst,"
               + "ins.dire_inst,m.id_dept,d.dept,m.id_muni,m.muni,CASE   ins.estado WHEN 1 THEN 'Habilitado' WHEN  0 THEN 'Desahabilitado' END  " 
              +"from departamento d inner join  municipio m on  m.id_dept=d.id_dept inner join instituciones ins on ins.id_muni = m.id_muni");
             
             ResultSet rs = cmd.executeQuery();
             while(rs.next())
             {
             resp.add(new Institucion(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6)
             ,rs.getInt(7),rs.getString(8),rs.getString(9)));
             }
                
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,"Error:"+e.getMessage());
            }
        return resp;
    }
    public Institucion consUno(int codi)
    {
        Institucion resp = null;
        Connection con = new Conexion().getConn();
            try 
            {
             PreparedStatement cmd = con.prepareStatement("select ins.id_inst,ins.nomb_inst,ins.correo_inst,"
               + "ins.dire_inst,m.id_dept,d.dept,m.id_muni,m.muni,CASE   ins.estado WHEN 1 THEN 'Habilitado' WHEN  0 THEN 'Desahabilitado' END  " 
              +"from departamento d inner join  municipio m on  m.id_dept=d.id_dept inner join instituciones ins on ins.id_muni = m.id_muni"
                     + " where ins.id_inst=? ");
             cmd.setInt(1, codi);
             ResultSet rs = cmd.executeQuery();
             while(rs.next())
             {
             resp=(new Institucion(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6)
             ,rs.getInt(7),rs.getString(8),rs.getString(9)));
             }
                
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,"Error:"+e.getMessage());
            }
        return resp;
    }
    public List<Institucion> consEstado(Institucion obj)
    {
        List<Institucion> resp = new ArrayList();
        Connection con = new Conexion().getConn();
            try 
            {
             PreparedStatement cmd = con.prepareStatement("select ins.estado from instituciones ins where ins.id_inst=?");
             cmd.setInt(1,obj.getCodigo());
             ResultSet rs = cmd.executeQuery();
             while(rs.next())
             {
                resp.add(new Institucion(rs.getBoolean(1)));
             }
                
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,"Error:"+e.getMessage());
            }
        return resp;
    }
     public int Index(String Nombre)
    {
       int resp = 0;
        Connection con = new Conexion().getConn();
            try 
            {
             PreparedStatement cmd = con.prepareStatement("select count(*) from departamento where id_dept <= (select id_dept from departamento where dept=?)");
             cmd.setString(1, Nombre);
             ResultSet rs = cmd.executeQuery();
             while(rs.next())
             {
              resp = rs.getInt(1);
             }
                
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,"Error:"+e.getMessage());
            }
        return resp;
    }
      public int Index2(String NombreD,String NombreM)
    {
       int resp = 0;
        Connection con = new Conexion().getConn();
            try 
            {
             PreparedStatement cmd = con.prepareStatement("select count(*) from municipio "
             + "where id_dept in (select id_dept from departamento where dept=?) and id_muni <= (select id_muni from municipio where muni=?)");
             cmd.setString(1, NombreD);
             cmd.setString(2, NombreM);
             ResultSet rs = cmd.executeQuery();
             while(rs.next())
             {
              resp = rs.getInt(1);
             }
                
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,"Error:"+e.getMessage());
            }
        return resp;
    }
    public boolean guar(Institucion obje)
    {
    boolean resp = false;
    Connection con = new Conexion().getConn();
        try 
        {
            PreparedStatement cmd = con.prepareStatement("Insert into instituciones values(null,?,?,?,?,?)");
            cmd.setString(1,obje.getNomb());
            cmd.setString(2, obje.getCorreo());
            cmd.setString(3, obje.getDireccion());
            cmd.setInt(4, obje.getMunicipio());
            cmd.setBoolean(5,obje.getEstado());
            cmd.executeUpdate();
            resp=true;
        }
        catch (Exception e) 
        {
            System.out.println("Error:"+e.getMessage());
        }
         finally
        {
        try
        {
        if(con != null)
        {
        if(!con.isClosed())
        {
        con.close();
        }
        }
        }
        catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
    return resp;
    }
    public boolean actu(Institucion obje)
    {
    boolean resp = false;
    Connection con = new Conexion().getConn();
        try 
        {
            PreparedStatement cmd = con.prepareStatement("Update  instituciones set nomb_inst=?, correo_inst=?,dire_inst=?,id_muni=? where id_inst = ?");
            cmd.setString(1,obje.getNomb());
            cmd.setString(2, obje.getCorreo());
            cmd.setString(3, obje.getDireccion());
            cmd.setInt(4, obje.getMunicipio());
           cmd.setInt(5,obje.getCodigo());
            cmd.executeUpdate();
            resp=true;
        }
        catch (Exception e) 
        {
            System.out.println("Error:"+e.getMessage());
        }
         finally
        {
        try
        {
        if(con != null)
        {
        if(!con.isClosed())
        {
        con.close();
        }
        }
        }
        catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
    return resp;
    }
    public boolean elim(Institucion obje)
    {
    boolean resp = false;
    Connection con = new Conexion().getConn();
        try 
        {
            PreparedStatement cmd = con.prepareStatement("Update  instituciones set estado=? where id_inst = ?");
            cmd.setBoolean(1,obje.getEstado());
            cmd.setInt(2,obje.getCodigo());
            cmd.executeUpdate();
            resp=true;
        }
        catch (Exception e) 
        {
            System.out.println("Error:"+e.getMessage());
        }
         finally
        {
        try
        {
        if(con != null)
        {
        if(!con.isClosed())
        {
        con.close();
        }
        }
        }
        catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
    return resp;
    }
}
