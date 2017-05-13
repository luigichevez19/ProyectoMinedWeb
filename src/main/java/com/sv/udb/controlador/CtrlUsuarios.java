/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Usuarios;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oscar
 */
public class CtrlUsuarios {
     public boolean guarUsu(Usuarios obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
             
              PreparedStatement cmd = cn.prepareStatement("INSERT INTO usuarios VALUES(NULL,?,?,?,?,?)");
            cmd.setString(1, String.valueOf(obje.getIdTipoUsu()));
              cmd.setString(2, obje.getUsuario());            
            cmd.setString(3, obje.getNombres());
            cmd.setString(4, obje.getApellidos());
            cmd.setString(5, new CtrlContras().encrypt(obje.getContra()));
            
            cmd.executeUpdate();
            resp=true;
            
        } catch (Exception ex) 
        {
            System.err.println("Error al guardar Usuario: " + ex.getMessage());
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
    public boolean eliminarUsu(int id){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
              PreparedStatement cmd = cn.prepareStatement("DELETE FROM usuarios WHERE id_usuario = ?");
            cmd.setString(1,String.valueOf(id));         
            cmd.executeUpdate();
            resp=true;
            
        } catch (Exception ex) 
        {
            System.err.println("Error al eliminar municipio: " + ex.getMessage());
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
    
    public boolean editarUsu(Usuarios obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
              PreparedStatement cmd = cn.prepareStatement("UPDATE usuarios Set usuario = ?, id_tipo_usu = ?, nombre = ?, apellido = ? WHERE id_usuario = ?");
             cmd.setString(1, obje.getUsuario());
             cmd.setString(2, String.valueOf(obje.getIdTipoUsu()));             
            cmd.setString(3, obje.getNombres());
            cmd.setString(4, obje.getApellidos());
            cmd.setString(5, String.valueOf(obje.getIdUsuario()));
            
            cmd.executeUpdate();
            resp=true;
            
        } catch (Exception ex) 
        {
            System.err.println("Error al editar Usuario: " + ex.getMessage());
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
    
    
    public List<Usuarios> consTodo()
    {
        List<Usuarios> resp = new ArrayList();
        Connection cn =new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("select * from usuarios");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Usuarios(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
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
    
     public Usuarios consUno(int id)
    {
        Usuarios resp = new Usuarios();
        Connection cn =new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("select * from usuarios where id_usuario = ?");
             cmd.setString(1, String.valueOf(id));
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp = new Usuarios(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
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
