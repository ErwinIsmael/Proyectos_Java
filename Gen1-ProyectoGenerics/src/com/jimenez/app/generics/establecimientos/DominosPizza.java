package com.jimenez.app.generics.establecimientos;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class DominosPizza extends BaseEstablecimiento {
    //atributos
    private List<String> tipoPizzas;
    private String promociones;
    private Boolean areaJuegos;


    //metodos
    @Override
    public List<String> realizarVenta(String pedido) {
        System.out.println("Se vende una pizza y es destinada para la entrega al repartidor en la direccion" + direccion + " para el dia "+ dialaboral);
        for (int i = 0; i < tipoPizzas.size(); i++) {
            if(Objects.equals(tipoPizzas.get(i).toUpperCase(), pedido.toUpperCase())){
                tipoPizzas.remove(i);
            }
        }
        System.out.println("Pizzas existentes tras la venta: " + tipoPizzas);
        return tipoPizzas;
    }

    @Override
    public String abrir() {
        return "Dominos Pizza abre a las " + horaApertura + " a.m.";
    }

    //metodos
    public void prepararPizza(String pizza){
        System.out.println("Se prepara la pizza y esta se agrega en la lista de pedidos");
        tipoPizzas.add(pizza);
        System.out.println(tipoPizzas);
    }

    public List<String> getTipoPizzas() {
        return tipoPizzas;
    }

    public void setTipoPizzas(List<String> tipoPizzas) {
        this.tipoPizzas = tipoPizzas;
    }

    public String getPromociones() {
        return promociones;
    }

    public void setPromociones(String promociones) {
        this.promociones = promociones;
    }

    public Boolean getAreaJuegos() {
        return areaJuegos;
    }

    public void setAreaJuegos(Boolean areaJuegos) {
        this.areaJuegos = areaJuegos;
    }

}
