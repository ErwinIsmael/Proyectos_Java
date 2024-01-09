package com.jimenez.app.generics.celulares;

import com.jimenez.app.generics.enums.Color;

public class CelularApple {
    //atributos
    private String modelo;
    private String imei;
    private Float memoriaRam;
    private Float memoriaRom;
    private boolean botonSilencioEstado;
    private Float capacidadBateria;
    private Color color;

    //metodosd
    public void realizarLlamada(){
        System.out.println("Soy un celular apple y hago una llamada");
    }

    //Constructor


    public CelularApple() {
    }

    public CelularApple(String modelo, String imei, Float memoriaRam, Float memoriaRom, boolean botonSilencioEstado, Float capacidadBateria, Color color) {
        this.modelo = modelo;
        this.imei = imei;
        this.memoriaRam = memoriaRam;
        this.memoriaRom = memoriaRom;
        this.botonSilencioEstado = botonSilencioEstado;
        this.capacidadBateria = capacidadBateria;
        this.color = color;
    }

    //getter and setter
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Float getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(Float memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public Float getMemoriaRom() {
        return memoriaRom;
    }

    public void setMemoriaRom(Float memoriaRom) {
        this.memoriaRom = memoriaRom;
    }

    public boolean getBotonSilencioEstado() {
        return botonSilencioEstado;
    }

    public void setBotonSilencioEstado(boolean botonSilencioEstado) {
        this.botonSilencioEstado = botonSilencioEstado;
    }

    public Float getCapacidadBateria() {
        return capacidadBateria;
    }

    public void setCapacidadBateria(Float capacidadBateria) {
        this.capacidadBateria = capacidadBateria;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
