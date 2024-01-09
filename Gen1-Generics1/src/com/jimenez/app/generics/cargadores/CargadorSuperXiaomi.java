package com.jimenez.app.generics.cargadores;

import com.jimenez.app.generics.celulares.CelularXiaomi;

public class CargadorSuperXiaomi implements IXiaomiCargador{
    @Override
    public void cargar(CelularXiaomi celular) {
        System.out.println("Soy un cargador Normal Xiaomi y la capacidad del cargador es de 66 watts");
        System.out.println("Estoy cargando un celular Xiaomi");
        System.out.println("tiempo de carga: "+celular.getCapacidadBateria() * .50);
        System.out.println("************");
    }
}
