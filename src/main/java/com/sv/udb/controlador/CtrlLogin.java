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

/**
 *
 * @author oscar
 */
public class CtrlLogin {
     public int verificarUsua(String usua, String contra)
    {
        CtrlContras objeContra = new CtrlContras();
        Usuarios resp = new Usuarios();
        int idTipo=0;
        Connection cn =new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("select * from usuarios where usuario = ? ");
             cmd.setString(1, usua);
             
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp = new Usuarios(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            }
            if(resp.getIdUsuario() == 0)
            {
                idTipo =0;
            }
            else
            {
                if(objeContra.decrypt(resp.getContra()).equals(contra))
                {
                     idTipo = resp.getIdTipoUsu();
                }
                else
                {
                    idTipo = 0;
                }
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
        return idTipo;
        
    }
    
}
