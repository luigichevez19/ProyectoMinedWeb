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
    private String muni,depa;
    private int idDept;

    public String getDepa() {
        return depa;
    }

    public void setDepa(String depa) {
        this.depa = depa;
    }
    
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

    public Municipios(int idMuni, String muni, String depa) {
        this.idMuni = idMuni;
        this.muni = muni;
        this.depa = depa;
    }

    
    
    
}
