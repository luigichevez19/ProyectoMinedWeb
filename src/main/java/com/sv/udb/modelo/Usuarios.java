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
public class Usuarios {
    private int idUsuario;
    private String usuario;
    private String nombres;
    private String apellidos;
    private String contra;
    private int idTipoUsu;

    public int getIdTipoUsu() {
        return idTipoUsu;
    }

    public void setIdTipoUsu(int idTipoUsu) {
        this.idTipoUsu = idTipoUsu;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    public Usuarios()
    {
        
    }
    
    public Usuarios(int id,int idTipo, String usuario, String nombre, String apellido, String contra)
    {
        this.idUsuario = id;
        this.usuario = usuario;
        this.nombres = nombre;
        this.apellidos = apellido;
        this.contra = contra;
        this.idTipoUsu = idTipo;
    }

    @Override
    public String toString() {
        return this.usuario;
    }
    
    
    
}
