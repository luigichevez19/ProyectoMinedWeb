/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.TipoUsuario;
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
public class CtrlTipoUsu {
    public List<TipoUsuario> consTodo()
    {
        List<TipoUsuario> resp = new ArrayList();
        Connection cn =new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("select * from tipo_usuario");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new TipoUsuario(rs.getInt(1),rs.getString(2)));
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
    
     public TipoUsuario consUno(int id)
    {
        TipoUsuario resp = new TipoUsuario();
        Connection cn =new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("select * from tipo_usuario where id_tipo_usu = ?");
             cmd.setString(1, String.valueOf(id));
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp = new TipoUsuario(rs.getInt(1),rs.getString(2));
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
