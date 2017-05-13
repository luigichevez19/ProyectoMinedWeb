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
public class Departamentos {
    private int idDepa;
    private String NombreDepa;

    public int getIdDepa() {
        return idDepa;
    }

    public void setIdDepa(int idDepa) {
        this.idDepa = idDepa;
    }

    public String getNombreDepa() {
        return NombreDepa;
    }

    public void setNombreDepa(String NombreDepa) {
        this.NombreDepa = NombreDepa;
    }
    
    public Departamentos()
    {
        
    }
      public Departamentos(int id, String nombre)
    {
        this.idDepa = id;
        this.NombreDepa = nombre;
    }      

    @Override
    public String toString() {
        return NombreDepa;
    }
    
    
    
}
