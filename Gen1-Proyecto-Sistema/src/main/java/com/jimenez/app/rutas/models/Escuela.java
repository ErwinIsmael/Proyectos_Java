package com.jimenez.app.rutas.models;

public class Escuela {

    private Long id;
    private String nombre;
    private String escudo;
    private String direccion;
    private  String CCT;
    private String nivel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCCT() {
        return CCT;
    }

    public void setCCT(String CCT) {
        this.CCT = CCT;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
