package com.jimenez.app.generics.repartidores;

import com.jimenez.app.generics.establecimientos.LaCasaDeTono;
import com.jimenez.app.generics.establecimientos.Walmart;

public class RepartidorFastWalmart implements IUberEatsRepartidor<Walmart>{
    @Override
    public void repartir(Walmart repartidor) {
        System.out.println("----> Soy el repartidor de Walmart en este dia y llevo un pedido en menos de 30 minutos");
        System.out.println("Llevo los pedidos a domicilio");
    }
}
