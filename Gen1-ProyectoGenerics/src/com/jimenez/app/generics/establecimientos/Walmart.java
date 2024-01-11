package com.jimenez.app.generics.establecimientos;

import java.util.List;
import java.util.Objects;

public class Walmart extends BaseEstablecimiento{
    //atributos
    private Integer cantidadEmpleados;
    private String formatoTienda;
    private Boolean devolucion;
    private List<String> inventario;

    //metodos
    @Override
    public List<String> realizarVenta(String pedido) {
        System.out.println("Se vende un producto de tipo y es destinada para la entrega al repartidor en la direccion: " + direccion + " para el dia "+ dialaboral);
        for (int i = 0; i < inventario.size(); i++) {
            if(Objects.equals(inventario.get(i).toUpperCase(), pedido.toUpperCase())){
                inventario.remove(i);
            }
        }
        System.out.println("Inventario actual tras la venta del producto: " + inventario);
        return inventario;
    }

    @Override
    public String abrir() {
        return "Walmart tiene apertura a las: " + horaApertura + " a.m. y horario de cierre a las " + horaCierre +" p.m.";
    }

    public void cargaInventario(String producto){
        System.out.println("Se carga a inventario: " + producto);
        inventario.add(producto.toUpperCase());
        System.out.println("Actualizacion de inventario actual" + inventario);

    }

    //setter and getter

    public Integer getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public void setCantidadEmpleados(Integer cantidadEmpleados) {
        this.cantidadEmpleados = cantidadEmpleados;
    }

    public String getFormatoTienda() {
        return formatoTienda;
    }

    public void setFormatoTienda(String formatoTienda) {
        this.formatoTienda = formatoTienda;
    }

    public Boolean getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(Boolean devolucion) {
        this.devolucion = devolucion;
    }

    public List<String> getInventario() {
        return inventario;
    }

    public void setInventario(List<String> inventario) {
        this.inventario = inventario;
    }
}
