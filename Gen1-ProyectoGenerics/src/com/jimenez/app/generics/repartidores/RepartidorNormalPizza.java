package com.jimenez.app.generics.repartidores;

import com.jimenez.app.generics.establecimientos.DominosPizza;

public class RepartidorNormalPizza implements IUberEatsRepartidor<DominosPizza> {


    @Override
    public void repartir(DominosPizza repartidor) {
        System.out.println("Soy el repartidor de Dominos Pizza en este dia y llevo un pedido al menos en 1 hora");
        System.out.println("Llevo los pedidos a domicilio");
    }
}
