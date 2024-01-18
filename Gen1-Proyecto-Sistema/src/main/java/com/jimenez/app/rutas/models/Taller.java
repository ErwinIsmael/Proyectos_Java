package com.jimenez.app.rutas.models;

public class Taller {

    private Long id;
    private Integer numTaller;
    private String nombre;
    private String direccion;
    private String telefono;
    private Integer numeroTrabajadores;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumTaller() {
        return numTaller;
    }

    public void setNumTaller(Integer numTaller) {
        this.numTaller = numTaller;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getNumeroTrabajadores() {
        return numeroTrabajadores;
    }

    public void setNumeroTrabajadores(Integer numeroTrabajadores) {
        this.numeroTrabajadores = numeroTrabajadores;
    }
}
