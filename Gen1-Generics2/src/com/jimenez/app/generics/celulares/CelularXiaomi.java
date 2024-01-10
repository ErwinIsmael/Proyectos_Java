package com.jimenez.app.generics.celulares;

import com.jimenez.app.generics.enums.Color;

public class CelularXiaomi {
    //atributos
    private String modelo;
    private String imei;
    private Float memoriaRam;
    private Float memoriaRom;
    private Float capacidadBateria;
    private Color color;

    //metodos
    public void realizarLlamada(){
        System.out.println("Soy un celular Xiaomi y hago una llamada mediante ");
    }

    //Constructores


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
