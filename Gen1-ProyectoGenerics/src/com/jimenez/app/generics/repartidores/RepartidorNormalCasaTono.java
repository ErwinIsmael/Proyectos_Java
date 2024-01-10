package com.jimenez.app.generics.repartidores;

import com.jimenez.app.generics.establecimientos.LaCasaDeTono;

public class RepartidorNormalCasaTono implements IUberEatsRepartidor<LaCasaDeTono>{

    @Override
    public void repartir(LaCasaDeTono repartidor) {
        System.out.println("Soy el repartidor de La Casa de Toño en este dia y llevo un pedido por lo menos en 1 hora ");
        System.out.println("Llevo los pedidos a domicilio");
    }
}
