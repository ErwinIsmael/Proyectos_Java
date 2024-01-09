package com.jimenez.app.generics.cargadores;

import com.jimenez.app.generics.celulares.CelularSamsung;

public class CargadorSuperSamsung implements ISamsungCargador {
    @Override
    public void cargar(CelularSamsung celular) {
        System.out.println("Soy un cargador Super Power Samsungy la capacidad del cargador es de 66watts");
        System.out.println("Estoy cargando un celular Samsung");
        System.out.println("tiempo de carga: "+celular.getCapacidadBateria() * .45);
        System.out.println("************");
    }
}
