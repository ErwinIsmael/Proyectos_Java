package com.jimenez.app.generics.cargadores;

import com.jimenez.app.generics.celulares.CelularApple;

public class CargadorNormalApple implements ICargador<CelularApple>{

    @Override
    public void cargar(CelularApple celular) {
        System.out.println("Soy un cargador normal de Apple y la capacidad del cargador es de 20watts");
        System.out.println("Estoy cargando un celular Apple");
        System.out.println("tiempo de carga: "+celular.getCapacidadBateria() * 3.6);
        System.out.println("------------");
    }

}
