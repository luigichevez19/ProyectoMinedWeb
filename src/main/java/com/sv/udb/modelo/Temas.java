/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author Walter
 */
public class Temas {
    private int idTema;
    private String Tema;

    public Temas() {
    }

    public Temas(int idTema, String Tema) {
        this.idTema = idTema;
        this.Tema = Tema;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public String getTema() {
        return Tema;
    }

    public void setTema(String Tema) {
        this.Tema = Tema;
    }    

    @Override
    public String toString() {
        return Tema;
    }
}
