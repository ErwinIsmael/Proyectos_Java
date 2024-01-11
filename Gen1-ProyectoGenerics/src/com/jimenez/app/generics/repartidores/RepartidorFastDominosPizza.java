package com.jimenez.app.generics.repartidores;

import com.jimenez.app.generics.enums.Dias;
import com.jimenez.app.generics.establecimientos.DominosPizza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepartidorFastDominosPizza implements IUberEatsRepartidor<DominosPizza> {




    @Override
    public void repartir(DominosPizza repartidor) {
        System.out.println("---> Soy el repartidor  de Dominos Pizza y llevo un pedido en menos de 30 minutos");
        System.out.println("Llevo los pedidos a domicilio");
    }

}
