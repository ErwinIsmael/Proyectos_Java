package com.jimenez.app.generics.establecimientos;

import java.util.List;
import java.util.Objects;

public class LaCasaDeTono extends BaseEstablecimiento {
    //atributos
    private List<String> platillos;
    private String valoracion;
    private Integer anoFundado;
    //metodos
    @Override
    public List<String> realizarVenta(String pedido) {
        System.out.println("Se vende un pedido y es destinada para la entrega al repartidor en la direccion "+ direccion + " para el dia "+ dialaboral);
        for (int i = 0; i < platillos.size(); i++) {
            if(Objects.equals(platillos.get(i), pedido)){
                platillos.remove(i);
            }

            System.out.println("Platillos aun en lista de espera a entregar tras la venta: " + platillos);
        }
        return platillos;

    }

    @Override
    public String abrir() {
        return "El establecimiento tiene apertura a las: " + horaApertura + " a.m. y horario de cierre a las " + horaCierre +" p.m.";
    }

    //metodos
    public void prepararPlatillo(String platillo){
        System.out.println("Se prepara el platillo y es agregado a la lista de espera para entregar");
        platillos.add(platillo);
        System.out.println("Lista actual de platillos a entregar: "+ platillos);
    }

    public void contratar(){
        System.out.println("Vacantes disponibles de areas de trabajo disponibles en area de cosina");
    }



    //setter and getter
    public List<String> getPlatillos() {
        return platillos;
    }

    public void setPlatillos(List<String> platillos) {
        this.platillos = platillos;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public Integer getAnoFundado() {
        return anoFundado;
    }

    public void setAnoFundado(Integer anoFundado) {
        this.anoFundado = anoFundado;
    }

}
