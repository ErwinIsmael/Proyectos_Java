import com.jimenez.app.generics.enums.Dias;
import com.jimenez.app.generics.establecimientos.DominosPizza;
import com.jimenez.app.generics.establecimientos.LaCasaDeTono;
import com.jimenez.app.generics.establecimientos.Walmart;
import com.jimenez.app.generics.repartidores.IUberEatsRepartidor;
import com.jimenez.app.generics.repartidores.RepartidorFastDominosPizza;
import com.jimenez.app.generics.repartidores.RepartidorNormalPizza;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C1 {
    public static void main(String[] args) {
        List<String> inventarioPizza = new ArrayList<>();
                inventarioPizza.add("Hawuaina");
                inventarioPizza.add("Peperoni");
                inventarioPizza.add("Chorizo");
        List<String> inventarioPlatillos = Arrays.asList("Pollo al Orange","Pozole","Arroz con mole","Costilla","Ensalada","Res");
        List<String> inventarioProductos = Arrays.asList("Cereal","Leche","Latas de atun","Arroz","Frijol","Aceite");

        DominosPizza expressDominos = new DominosPizza();
        expressDominos.setTipoPizzas(inventarioPizza);
        expressDominos.setPromociones("Envio gratis");
        expressDominos.setHoraApertura(LocalTime.of(9, 0, 0));
        expressDominos.setDialaboral(Dias.LUNES);
        expressDominos.setDireccion("Calle Reynosa, Azcapotzalco, Ciudad de Mexico");

        LaCasaDeTono grandeCasaTono = new LaCasaDeTono();
        grandeCasaTono.setPlatillos(inventarioPlatillos);
        grandeCasaTono.setValoracion("5 estrellas");
        grandeCasaTono.setHoraApertura(LocalTime.of(8,0,0));
        grandeCasaTono.setHoraCierre(LocalTime.of(22, 30, 0));
        grandeCasaTono.setDialaboral(Dias.MIERCOLES);
        grandeCasaTono.setDireccion("San Bartolo, Naucalpan, Estado de Mexico");

        Walmart walmartMexico = new Walmart();
        walmartMexico.setInventario(inventarioProductos);
        walmartMexico.setFormatoTienda("Completa");
        walmartMexico.setDevolucion(true);
        walmartMexico.setHoraApertura(LocalTime.of(8, 0, 0));
        walmartMexico.setHoraCierre(LocalTime.of(10, 30,0));

        IUberEatsRepartidor repartidorFastDominos = new RepartidorFastDominosPizza();
        IUberEatsRepartidor repartidorNormalDominos = new RepartidorNormalPizza();


        System.out.println(expressDominos.abrir());
        expressDominos.prepararPizza("3 quesos");
        expressDominos.realizarVenta("Peperoni");
        repartidorFastDominos.repartir(expressDominos);





    }
}
