package com.jimenez.app.generics.repartidores;

import com.jimenez.app.generics.enums.Dias;
import com.jimenez.app.generics.establecimientos.DominosPizza;
import com.jimenez.app.generics.establecimientos.LaCasaDeTono;

public class RepartidorFastCasaTono implements IUberEatsRepartidor<LaCasaDeTono>{

    @Override
    public void repartir(LaCasaDeTono repartidor) {
        System.out.println("Soy el repartidor de La Casa de Toño en este dia y llevo un pedido en menos de 30 minutos");
        System.out.println("Llevo los pedidos a domicilio");
    }

    //getter and setter
}
