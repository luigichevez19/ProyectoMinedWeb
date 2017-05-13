/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Temas;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Walter
 */
public class TemasCtrl {
    public boolean guarTema(Temas obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
              PreparedStatement cmd = cn.prepareStatement("INSERT INTO tema_denuncia VALUES(NULL,?)");
            cmd.setString(1, obje.getTema());
            cmd.executeUpdate();
            resp=true;
            
        } catch (Exception ex) 
        {
            System.err.println("Error al guardar: " + ex.getMessage());
        }
        finally
        {
            try 
            {
                if(cn != null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }    
                }
               
            } 
            catch (SQLException err) {
                err.printStackTrace();
            }
    
        }
        return resp;   
    }
    public boolean elimTema(int id){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
              PreparedStatement cmd = cn.prepareStatement("DELETE FROM tema_denuncia WHERE id_tema_denu = ?");
            cmd.setString(1,String.valueOf(id));         
            cmd.executeUpdate();
            resp=true;
            
        } catch (Exception ex) 
        {
            System.err.println("Error al eliminar: " + ex.getMessage());
        }
        finally
        {
            try 
            {
                if(cn != null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }    
                }
               
            } 
            catch (SQLException err) {
                err.printStackTrace();
            }
    
        }
        return resp;   
    }
    
    public boolean editTema(Temas obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
              PreparedStatement cmd = cn.prepareStatement("UPDATE tema_denuncia SET tema_denu = ? WHERE id_tema_denu = ?");
             cmd.setString(1, obje.getTema());
            cmd.setString(2, String.valueOf(obje.getIdTema()));
            cmd.executeUpdate();
            resp=true;
            
        } catch (Exception ex) 
        {
            System.err.println("Error al editar: " + ex.getMessage());
        }
        finally
        {
            try 
            {
                if(cn != null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }    
                }
               
            } 
            catch (SQLException err) {
                err.printStackTrace();
            }
    
        }
        return resp;   
    }
    
    
    public List<Temas> consTodo()
    {
        List<Temas> resp = new ArrayList();
        Connection cn =new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("select * from tema_denuncia");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Temas(rs.getInt(1),rs.getString(2)));
            }
        } catch (Exception err) 
        {
            err.printStackTrace();
        }
        finally
        {
            try {
                 if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
                
            } catch (SQLException err) {
                err.printStackTrace();
            }
            
        }
        return resp;
        
    }
    
     public Temas consUno(int id)
    {
        Temas resp = new Temas();
        Connection cn =new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("select * from tema_denuncia where id_tema_denu = ?");
             cmd.setString(1, String.valueOf(id));
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp = new Temas(rs.getInt(1),rs.getString(2));
            }
        } catch (Exception err) 
        {
            err.printStackTrace();
        }
        finally
        {
            try {
                 if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
                
            } catch (SQLException err) {
                err.printStackTrace();
            }
            
        }
        return resp;
        
    }
}
