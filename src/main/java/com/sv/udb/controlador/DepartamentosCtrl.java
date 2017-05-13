/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Departamentos;
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
public class DepartamentosCtrl {
    public boolean guarDepart(Departamentos obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
              PreparedStatement cmd = cn.prepareStatement("INSERT INTO departamento VALUES(NULL,?)");
            cmd.setString(1, obje.getNombreDepa());
            cmd.executeUpdate();
            resp=true;
            
        } catch (Exception ex) 
        {
            System.err.println("Error al guardar departamento: " + ex.getMessage());
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
    public boolean eliminarDepa(int id){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
              PreparedStatement cmd = cn.prepareStatement("DELETE FROM departamento WHERE id_dept = ?");
            cmd.setString(1,String.valueOf(id));         
            cmd.executeUpdate();
            resp=true;
            
        } catch (Exception ex) 
        {
            System.err.println("Error al eliminar departamento: " + ex.getMessage());
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
    
    public boolean editarDepa(Departamentos obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
              PreparedStatement cmd = cn.prepareStatement("UPDATE departamento Set dept = ? WHERE id_dept = ?");
             cmd.setString(1, obje.getNombreDepa());
            cmd.setString(2, String.valueOf(obje.getIdDepa()));
            cmd.executeUpdate();
            resp=true;
            
        } catch (Exception ex) 
        {
            System.err.println("Error al editar Departamento: " + ex.getMessage());
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
    
    
    public List<Departamentos> consTodo()
    {
        List<Departamentos> resp = new ArrayList();
        Connection cn =new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("select * from departamento");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
              
                resp.add(new Departamentos(rs.getInt(1),rs.getString(2)));
                
                
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
   
     public Departamentos consUno(int id)
    {
        Departamentos resp = new Departamentos();
        Connection cn =new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("select * from departamento where id_dept = ?");
             cmd.setString(1, String.valueOf(id));
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp = new Departamentos(rs.getInt(1),rs.getString(2));
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
