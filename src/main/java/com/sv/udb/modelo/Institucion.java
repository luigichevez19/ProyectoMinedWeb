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
public class Institucion {
    int codigo,Municipio,Departamento;
    boolean estado;
    String nomb,correo,direccion,MunicipioN,DepartamentoN,estadoS;

    public String getEstadoS() {
        return estadoS;
    }

    public void setEstadoS(String estadoS) {
        this.estadoS = estadoS;
    }

    public int getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(int Departamento) {
        this.Departamento = Departamento;
    }

    public String getMunicipioN() {
        return MunicipioN;
    }

    public void setMunicipioN(String MunicipioN) {
        this.MunicipioN = MunicipioN;
    }

    public String getDepartamentoN() {
        return DepartamentoN;
    }

    public void setDepartamentoN(String DepartamentoN) {
        this.DepartamentoN = DepartamentoN;
    }

    public Institucion() {
    }

    public Institucion(int codigo,String nomb,String correo,String direccion,int Departamento,String DepartamentoN, int Municipio,String MunicipioN,String estadoS ) {
        this.codigo = codigo;
        this.nomb = nomb;
        this.correo = correo;
        this.direccion = direccion;
        this.Departamento = Departamento;
        this.DepartamentoN = DepartamentoN;
        this.Municipio = Municipio;
        this.MunicipioN = MunicipioN;
        this.estadoS = estadoS;  
        
    }
   

    @Override
    public String toString() {
       return nomb;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(int Municipio) {
        this.Municipio = Municipio;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
