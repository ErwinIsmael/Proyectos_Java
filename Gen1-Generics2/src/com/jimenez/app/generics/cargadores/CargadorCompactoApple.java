package com.jimenez.app.generics.cargadores;

import com.jimenez.app.generics.celulares.CelularApple;

public class CargadorCompactoApple implements ICargador<CelularApple>{

    @Override
    public void cargar(CelularApple celular) {
        System.out.println("Soy un cargador compacto de Apple y la capacidad del cargador es de 35watts");
        System.out.println("Estoy cargando un celular Apple");
        System.out.println("tiempo de carga: "+celular.getCapacidadBateria() * 2.7);
        System.out.println("------------");
    }
}
