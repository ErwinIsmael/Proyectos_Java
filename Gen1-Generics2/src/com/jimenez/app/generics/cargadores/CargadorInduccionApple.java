package com.jimenez.app.generics.cargadores;

import com.jimenez.app.generics.celulares.CelularApple;

public class CargadorInduccionApple implements ICargador<CelularApple>{

    @Override
    public void cargar(CelularApple celular) {
        System.out.println("Soy un cargador de Induccion de Apple y la capacidad del cargador es de 15watts");
        System.out.println("Estoy cargando un celular Apple");
        System.out.println("tiempo de carga: "+celular.getCapacidadBateria() * 4.6);
        System.out.println("------------");
    }
}
