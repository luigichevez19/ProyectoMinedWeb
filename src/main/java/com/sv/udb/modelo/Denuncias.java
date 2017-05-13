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
public class Denuncias {
    int codDenu, codTema, codInst, codAuto, edad, numTele, viable;
    String fecha, hora, nombVict, genero;

    public Denuncias() {
    }

    public Denuncias(int codDenu, int codTema, int codInst, int codAuto, int edad, int numTele, String fecha, String hora, String nombVict, String genero, int viable) {
        this.codDenu = codDenu;
        this.codTema = codTema;
        this.codInst = codInst;
        this.codAuto = codAuto;
        this.edad = edad;
        this.numTele = numTele;
        this.fecha = fecha;
        this.hora = hora;
        this.nombVict = nombVict;
        this.genero = genero;
        this.viable = viable;
    }

    public int getViable() {
        return viable;
    }

    public void setViable(int viable) {
        this.viable = viable;
    }

    public int getCodDenu() {
        return codDenu;
    }

    public void setCodDenu(int codDenu) {
        this.codDenu = codDenu;
    }

    public int getCodTema() {
        return codTema;
    }

    public void setCodTema(int codTema) {
        this.codTema = codTema;
    }

    public int getCodInst() {
        return codInst;
    }

    public void setCodInst(int codInst) {
        this.codInst = codInst;
    }

    public int getCodAuto() {
        return codAuto;
    }

    public void setCodAuto(int codAuto) {
        this.codAuto = codAuto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumTele() {
        return numTele;
    }

    public void setNumTele(int numTele) {
        this.numTele = numTele;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombVict() {
        return nombVict;
    }

    public void setNombVict(String nombVict) {
        this.nombVict = nombVict;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return nombVict;
    }
    
}
