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
public class Municipios {

    private int idMuni;
    private String muni;
    private int idDept;
    
    public int getIdMuni() {
        return idMuni;
    }

    public void setIdMuni(int idMuni) {
        this.idMuni = idMuni;
    }

    public String getMuni() {
        return muni;
    }

    public void setMuni(String muni) {
        this.muni = muni;
    }

    public int getIdDept() {
        return idDept;
    }

    public void setIdDept(int idDept) {
        this.idDept = idDept;
    }
    
    public Municipios()
    {
        
    }
    public Municipios(int id, String muni,int idDept)
    {
        this.idMuni = id;
        this.muni = muni;
        this.idDept = idDept;
    }
    

    @Override
    public String toString() {
        return this.muni;
    }
    
    
}
