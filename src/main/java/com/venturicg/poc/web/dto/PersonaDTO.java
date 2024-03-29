package com.venturicg.poc.web.dto;

import java.io.Serializable;

public class PersonaDTO implements Serializable {
    private String id;
    private String nombres;
    private String apellidos;
    private String pais;

    public PersonaDTO(String id, String nombre, String apellido, String pais) {
        this.id = id;
        this.nombres = nombre;
        this.apellidos = apellido;
        this.pais = pais;

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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
