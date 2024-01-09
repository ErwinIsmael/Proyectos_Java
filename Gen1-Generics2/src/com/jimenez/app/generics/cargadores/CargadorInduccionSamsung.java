package com.jimenez.app.generics.cargadores;

import com.jimenez.app.generics.celulares.CelularSamsung;

public class CargadorInduccionSamsung implements ICargador<CelularSamsung>{

    @Override
    public void cargar(CelularSamsung celular) {
        System.out.println("Soy un cargador de Induccion Samsung y la capacidad del cargador es de 15 watts");
        System.out.println("Estoy cargando un celular Samsung");
        System.out.println("tiempo de carga: "+celular.getCapacidadBateria() * 2.15);
        System.out.println("************");
    }
}
