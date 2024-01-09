package com.jimenez.app.generics.cargadores;

import com.jimenez.app.generics.celulares.CelularXiaomi;

public interface ICargador<T> {
    public void cargar(T dispositivo);
}

