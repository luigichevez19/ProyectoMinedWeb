/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author Luis
 */
public class Autoridad {
    int codi;
    String nomb,correo,estadoS;
    boolean estado;

    @Override
    public String toString() {
        return  nomb ;
    }

    public Autoridad(boolean estado) {
        this.estado = estado;
    }

    public String getEstadoS() {
        return estadoS;
    }

    public void setEstadoS(String estadoS) {
        this.estadoS = estadoS;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Autoridad(int codi, String nomb, String correo,String EstadoS) {
        this.codi = codi;
        this.nomb = nomb;
        this.correo = correo;
        this.estadoS = EstadoS;
    }

    public Autoridad() {
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getNomb() {
        return nomb;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
   
    
}
