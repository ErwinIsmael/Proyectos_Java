package com.jimenez.app.generics.repartidores;

import com.jimenez.app.generics.establecimientos.Walmart;

public interface IUberEatsRepartidor<T> {

    //metodo
    public void repartir(T repartidor);

}
