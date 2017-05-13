/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Municipios;
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
public class CtrlMunicipios {
     public boolean guarMuni(Municipios obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
              PreparedStatement cmd = cn.prepareStatement("INSERT INTO municipio VALUES(NULL,?,?)");
            cmd.setString(1, obje.getMuni());
            cmd.setString(2, String.valueOf(obje.getIdDept()));
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
    public boolean eliminarMuni(int id){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
              PreparedStatement cmd = cn.prepareStatement("DELETE FROM municipio WHERE id_muni = ?");
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
    
    public boolean editarMuni(Municipios obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
              PreparedStatement cmd = cn.prepareStatement("UPDATE municipio Set muni = ?, id_dept = ? WHERE id_muni = ?");
             cmd.setString(1, obje.getMuni());
            cmd.setString(2, String.valueOf(obje.getIdDept()));
            cmd.setString(3, String.valueOf(obje.getIdMuni()));
            cmd.executeUpdate();
            resp=true;
            
        } catch (Exception ex) 
        {
            System.err.println("Error al editar municipio: " + ex.getMessage());
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
    
    
    public List<Municipios> consTodo()
    {
        List<Municipios> resp = new ArrayList();
        Connection cn =new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("select * from municipio");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Municipios(rs.getInt(1),rs.getString(2),rs.getInt(3)));
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
    public Municipios consUno(int id)
    {
        Municipios resp = new Municipios();
        Connection cn =new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("select * from municipio where id_muni = ?");
             cmd.setString(1, String.valueOf(id));
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp = new Municipios(rs.getInt(1),rs.getString(2),rs.getInt(3));
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
    
     public List<Municipios> consUnoV2(int id)
    {
        List<Municipios> resp = new ArrayList<>();
        Connection cn =new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("select * from municipio where id_dept = ?");
             cmd.setString(1, String.valueOf(id));
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
               resp.add(new Municipios(rs.getInt(1),rs.getString(2),rs.getInt(3)));
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

