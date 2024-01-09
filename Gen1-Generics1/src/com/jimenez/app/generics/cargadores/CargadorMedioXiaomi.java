package com.jimenez.app.generics.cargadores;

import com.jimenez.app.generics.celulares.CelularXiaomi;

public class CargadorMedioXiaomi implements IXiaomiCargador{
    @Override
    public void cargar(CelularXiaomi celular) {
        System.out.println("Soy un cargador Medio Xiaomi y la capacidad del cargador es de 40 watts");
        System.out.println("Estoy cargando un celular Xiaomi");
        System.out.println("tiempo de carga: "+celular.getCapacidadBateria() * 2.10);
        System.out.println("************");
    }
}
