package com.jimenez.app.generics.establecimientos;

import com.jimenez.app.generics.enums.Dias;

import java.time.LocalTime;
import java.util.List;

public abstract class BaseEstablecimiento {
    //atributos
    protected String giroComercial;
    protected String direccion;
    protected String fundador;
    protected String tamanoEstablecimiento;
    protected LocalTime horaApertura;
    protected LocalTime horaCierre;
    protected Dias dialaboral;


    //metodos
    public abstract List<String> realizarVenta(String pedido);
    public abstract String abrir();


    //setter and getter


    public String getGiroComercial() {
        return giroComercial;
    }

    public void setGiroComercial(String giroComercial) {
        this.giroComercial = giroComercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFundador() {
        return fundador;
    }

    public void setFundador(String fundador) {
        this.fundador = fundador;
    }

    public String getTamanoEstablecimiento() {
        return tamanoEstablecimiento;
    }

    public void setTamanoEstablecimiento(String tamanoEstablecimiento) {
        this.tamanoEstablecimiento = tamanoEstablecimiento;
    }

    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(LocalTime horaApertura) {
        this.horaApertura = horaApertura;
    }

    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(LocalTime horaCierre) {
        this.horaCierre = horaCierre;
    }

    public Dias getDialaboral() {
        return dialaboral;
    }

    public void setDialaboral(Dias dialaboral) {
        this.dialaboral = dialaboral;
    }
}
