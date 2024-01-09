import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class C1 {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        List<String> palabras = Arrays.asList("Erwin", "Ismael", "Lopez", "Jimenez");
        Scanner s = new Scanner(System.in);
        int numero;
        int option = 0;

        while (option != 9) {

            if (!lista.isEmpty()) {
                System.out.println("Elementos de la lista");
                System.out.println(lista);
            } else {
                System.out.println("La lista no contiene elementos");
                System.out.println("\n");
            }

            System.out.println("Elementos de la lista String");
            System.out.println(palabras);
            System.out.println("\n");

            System.out.println("1) Agregar un numero a la lista");
            System.out.println("2) Eliminar un numero de la lista");
            System.out.println("3) Sumar todos los numeros de la lista existente");
            System.out.println("4) Obtener el promedio de los numeros de la lista existente");
            System.out.println("5) Obtener el numero mayor de la lista existente");
            System.out.println("6) Obtener el numero menor de la lista existente");
            System.out.println("7) Obtener la cantidad de veces que se repite X numero");
            System.out.println("8) Unir todas las palabras de la lista existente");
            System.out.println("9) Salir ");

            System.out.println("Ingresa la opcion que deseas realizar con el numero respectivo");
            option = s.nextInt();

            switch (option) {
                case 1:

                    System.out.print("Ingresa el numero que deseas agregar: ");
                    numero = s.nextInt();
                    agregar(lista, numero);
                    System.out.println("Desea continuar, ingreser 9 si desea salir");
                    System.out.println("\n");
                    break;

                case 2:
                    System.out.print("Ingresa el numero que deseas eliminar: ");
                    numero = s.nextInt();
                    eliminar(lista, numero);
                    System.out.println("\n");
                    break;

                case 3:
                    System.out.println("La suma es: " + sumaLista(lista));
                    System.out.println("\n");
                    break;

                case 4:
                    System.out.println("El promedio es: " + promedioLista(lista));
                    System.out.println("\n");
                    break;

                case 5:
                    System.out.println("El numero mayor de la lista es: " + numMayor(lista));
                    System.out.println("\n");
                    break;

                case 6:
                    System.out.println("El numero menor de la lista es: " + numMenor(lista));
                    System.out.println("\n");
                    break;

                case 7:
                    System.out.print("Ingresa el numero que deseas buscar las veces en que esta repetido: ");
                    numero = s.nextInt();
                    System.out.println("Veces repetido: " + repeticion(lista, numero));
                    System.out.println("\n");
                    break;

                case 8:
                    System.out.println("La lista concatenada es: "+ concatenar(palabras));
                    System.out.println("\n");
                    break;

                case 9:
                    option = 9;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        }

    }

    static List<Integer> agregar(List<Integer> lista, int numero) {
        lista.add(numero);
        return lista;
    }

    static List<Integer> eliminar(List<Integer> lista, int numero) {
        for (int i = 0; i<lista.size();i++){
            if(lista.get(i) == numero){
                lista.remove(i);
                return lista;
            }

        }

        return lista;
    }

    static int sumaLista(List<Integer> lista) {
        int suma = 0;
        for (Integer num : lista) {
            suma += num;
        }
        return suma;
    }

    static double promedioLista(List<Integer> lista) {
        double promedio = 0.0;
        promedio = sumaLista(lista) / (lista.size() * 1.0);
        return promedio;
    }

    static int numMayor(List<Integer> lista) {
        int nummayor = 0;

        for (int i = 0; i < lista.size(); i++) {
            if (i == 0) {
                nummayor = lista.get(i);
            } else if (lista.get(i) > nummayor) {
                nummayor = lista.get(i);
            }
        }
        return nummayor;
    }

    static int numMenor(List<Integer> lista){
        int numMenor = 0;

        for (int i = 0; i <lista.size(); i++){
            if (i == 0){
                numMenor = lista.get(i);
            } else if (lista.get(i) < numMenor) {
                numMenor = lista.get(i);
            }
        }
        return numMenor;
    }

    static int repeticion(List<Integer> lista, int numero){
        int cantidad = 0;

        for(Integer num: lista){
            if (num == numero){
                cantidad++;
            }
        }
        return cantidad;
    }

    static String concatenar (List<String> palabras){
        String frase = "";
        for (String p:palabras){
            frase += p+" ";
        }
        return frase;
    }

}
