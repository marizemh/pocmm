package com.venturicg.poc.service.model;

public class Persona {

    private String id;
    private String nombres;
    private String apellidos;
    private String pais;

    public Persona() {
    }

    public Persona(String id, String nombres, String apellidos, String pais) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.pais = pais;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

}
