package com.jimenez.app.generics.repartidores;

import com.jimenez.app.generics.establecimientos.Walmart;

public class RepartidorNormalWalmart implements IUberEatsRepartidor<Walmart>{

    @Override
    public void repartir(Walmart repartidor) {
        System.out.println("Soy el repartidor de Walmart en este dia y llevo un pedido al menos en 1 hora");
        System.out.println("Llevo los pedidos a domicilio");
    }
}
