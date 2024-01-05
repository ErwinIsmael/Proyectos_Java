import java.util.ArrayList;

import java.util.List;

public class C6 {
    public static void main(String[] args) {
        List<Integer> listaEnteros = new ArrayList<>();

        //agregamos 3 elementos a la lista
        listaEnteros.add(78);
        listaEnteros.add(45);
        listaEnteros.add(12);

        //mostramos los 3 elementos de la lista uno por uno

        System.out.println(listaEnteros.get(0));
        System.out.println(listaEnteros.get(1));
        System.out.println(listaEnteros.get(2));

        //eliminamos de la lista el numero 45, que se encuentra en la posicion 1
        listaEnteros.remove( 1);

        //despues de eliminar, las posiciones del arreglo se recorren
        System.out.println(listaEnteros.get(0));
        System.out.println(listaEnteros.get(1));

        //modificar una posicion de la lista
        listaEnteros.set(0,1);
        System.out.println(listaEnteros);

    }
}
