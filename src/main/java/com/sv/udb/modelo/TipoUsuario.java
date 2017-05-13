/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author oscar
 */
public class TipoUsuario {
    
    private int idTipoUsu;
    private String tipoUsu;
    
    public int getIdTipoUsu() {
        return idTipoUsu;
    }

    public void setIdTipoUsu(int idTipoUsu) {
        this.idTipoUsu = idTipoUsu;
    }

    public String getTipoUsu() {
        return tipoUsu;
    }

    public void setTipoUsu(String tipoUsu) {
        this.tipoUsu = tipoUsu;
    }
    
    
    public TipoUsuario()
    {
        
    }
    
    public TipoUsuario( int id, String tipo)
    {
        this.idTipoUsu = id;
        this.tipoUsu = tipo;
    }

    @Override
    public String toString() {
        return this.tipoUsu;
    }
    
}
