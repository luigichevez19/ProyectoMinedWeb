/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Denuncias;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Walter
 */
public class DenunciasCtrl {
    
    public boolean guarDenu(Denuncias obje, String opci){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            
            if (null != opci) switch (opci) {
                case "Archivar":
                    
                    PreparedStatement cons = cn.prepareStatement("INSERT INTO denuncia(fecha_denu, hora_denu, nom_vict, edad_vict, gene_vict, nume_vict, id_tema_denu, id_inst, viable) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 0)");
                    cons.setString(1, obje.getFecha());
                    cons.setString(2, obje.getHora());
                    cons.setString(3, !"".equals(obje.getNombVict()) ? obje.getNombVict() : null);
                    cons.setString(4, !"0".equals(String.valueOf(obje.getEdad())) ? String.valueOf(obje.getEdad()) : null);
                    cons.setString(5, !"".equals(obje.getGenero()) ? obje.getGenero() : null);;
                    cons.setString(6, !"0".equals(String.valueOf(obje.getNumTele())) ? String.valueOf(obje.getNumTele()) : null);
                    cons.setString(7, !"0".equals(String.valueOf(obje.getCodTema())) ? String.valueOf(obje.getCodTema()) : null);
                    cons.setString(8, !"0".equals(String.valueOf(obje.getCodInst())) ? String.valueOf(obje.getCodInst()) : null);
                    cons.executeUpdate();
                    resp=true;
                    
                    break;
                case "Remitir":
                    
                    PreparedStatement cmd = cn.prepareStatement("INSERT INTO denuncia(fecha_denu, hora_denu, nom_vict, edad_vict, gene_vict, nume_vict, id_tema_denu, id_inst, id_auto, viable) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 1)");
                    cmd.setString(1, obje.getFecha());
                    cmd.setString(2, obje.getHora());
                    cmd.setString(3, obje.getNombVict());
                    cmd.setString(4, String.valueOf(obje.getEdad()));
                    cmd.setString(5, obje.getGenero());
                    cmd.setString(6, String.valueOf(obje.getNumTele()));
                    cmd.setString(7, String.valueOf(obje.getCodTema()));
                    cmd.setString(8, String.valueOf(obje.getCodInst()));
                    cmd.setString(9, String.valueOf(obje.getCodAuto()));
                    cmd.executeUpdate();
                    resp=true;
                    break;
                case "Contactar":
                    
                    PreparedStatement sql = cn.prepareStatement("INSERT INTO denuncia(fecha_denu, hora_denu, nom_vict, edad_vict, gene_vict, nume_vict, id_tema_denu, id_inst, viable) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 1)");
                    sql.setString(1, obje.getFecha());
                    sql.setString(2, obje.getHora());
                    sql.setString(3, obje.getNombVict());
                    sql.setString(4, String.valueOf(obje.getEdad()));
                    sql.setString(5, obje.getGenero());
                    sql.setString(6, String.valueOf(obje.getNumTele()));
                    sql.setString(7, String.valueOf(obje.getCodTema()));
                    sql.setString(8, String.valueOf(obje.getCodInst()));
                    sql.executeUpdate();                    
                    resp=true;
                    break;
                default:
                    break;
            }
            
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
    
}
