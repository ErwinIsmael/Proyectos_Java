import com.jimenez.app.generics.enums.Dias;
import com.jimenez.app.generics.establecimientos.DominosPizza;
import com.jimenez.app.generics.establecimientos.LaCasaDeTono;
import com.jimenez.app.generics.establecimientos.Walmart;
import com.jimenez.app.generics.repartidores.*;

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
        List<String> inventarioPlatillos = new ArrayList<>();
                inventarioPlatillos.add("Pollo al Orange");
                inventarioPlatillos.add("Pozole");
                inventarioPlatillos.add("Arroz con mole");
        List<String> inventarioProductos = new ArrayList<>();

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
        walmartMexico.setDialaboral(Dias.VIERNES);
        walmartMexico.setDireccion("San Felipe, Puebla");

        IUberEatsRepartidor repartidorFastDominos = new RepartidorFastDominosPizza();
        IUberEatsRepartidor repartidorNormalDominos = new RepartidorNormalPizza();
        IUberEatsRepartidor repartidorFastCasaTono = new RepartidorFastCasaTono();
        IUberEatsRepartidor repartidorNormalCasaTono = new RepartidorNormalCasaTono();
        IUberEatsRepartidor repartidorFastWalmart = new RepartidorFastWalmart();
        IUberEatsRepartidor repartidorNormalWalmart = new RepartidorNormalWalmart();

        System.out.println(expressDominos.abrir());
        expressDominos.prepararPizza("3 quesos");
        expressDominos.realizarVenta("Peperoni");
        repartidorFastDominos.repartir(expressDominos);
        expressDominos.realizarVenta("Hawuaina");
        repartidorNormalDominos.repartir(expressDominos);

        System.out.println("*--------------------------------------------------------------------------*");

        System.out.println(grandeCasaTono.abrir());
        grandeCasaTono.prepararPlatillo("Enchiladas");
        grandeCasaTono.realizarVenta("Pozole");
        repartidorFastCasaTono.repartir(grandeCasaTono);
        grandeCasaTono.realizarVenta("Enchiladas");
        repartidorNormalCasaTono.repartir(grandeCasaTono);

        System.out.println("*--------------------------------------------------------------------------*");

        System.out.println(walmartMexico.abrir());
        walmartMexico.cargaInventario("Cereal");
        walmartMexico.cargaInventario("Arroz");
        walmartMexico.cargaInventario("Chocolate");
        walmartMexico.realizarVenta("Chocolate");
        repartidorFastWalmart.repartir(walmartMexico);
        walmartMexico.realizarVenta("Arroz");
        repartidorNormalWalmart.repartir(walmartMexico);

    }
}
