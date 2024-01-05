import java.util.Scanner;

public class C5 {
    public static void main(String[] args) {
        //Programa quye solicita 5 numeros enteros y muestre lka suma de los numeros
        //declaracion de variables
        int suma = 0;
        //declaracion de una variable de tipo arreglo de enteros
        int numeros[];

        //inicializacion de la variable de tipo arreglo de enteros
        numeros = new int[5];

        //variable especial
        Scanner s = new Scanner(System.in);

        for (int i = 0; i < numeros.length;i++){
            System.out.println("Ingresa el dato");
            numeros[i] = s.nextInt();
        }


        /*
        System.out.println("Ingresa el dato");
        numeros[1] = s.nextInt();

        System.out.println("Ingresa el dato");
        numeros[2] = s.nextInt();

        System.out.println("Ingresa el dato");
        numeros[3] = s.nextInt();

        System.out.println("Ingresa el dato");
        numeros[4] = s.nextInt();

         */

        /*
        suma = numeros[0] + numeros[1] + numeros[2] + numeros[3] + numeros[4];
        System.out.println(suma);

         */

        for(int i = 0; i < numeros.length; i++){
            suma += numeros[i];
            System.out.println("[ " + suma + " ]");
        }

        //ejemplo para leer una matriz
        /*
        int matriz [][]=new int [2][3];
        for(int a[]: matriz){
            for(int b: a){
                System.out.println(b);
            }

        }

         */

        suma = 0;
//suma con foreach, solo es implementado para el manejo de estructura de datos

        for(int j:numeros){
            //suma = suma+ i;
            suma +=j;
            System.out.println(" ("+ suma + ")");
        }

    }
}
