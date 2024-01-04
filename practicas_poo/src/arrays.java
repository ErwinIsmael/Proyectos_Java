import java.util.Scanner;

public class arrays {


    static void leerArray(char[] num){

        /*
        numeros[0] = 7;
        numeros[1] = 10;
        numeros[2] = 11;
         */

        for(int i = 0; i<num.length; i++){
            System.out.println(num[i]);

        }

    }

    static void llenarArray(){
        int nElementos;

        Scanner s = new Scanner(System.in);
        System.out.println("Ingresa el numero de elementos que desees ingresar: ");
        nElementos = s.nextInt();

        char[] letras = new char[nElementos];

        for (int i = 0; i<nElementos; i++){
            System.out.println("Ingresa el caracter numero "+ (i + 1)+": ");
            letras[i] = s.next().charAt(0);
        }

        leerArray(letras);
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int bandera = 1;
        while (bandera == 1){
            System.out.println("Deseas continuar ingresa 1");
            System.out.println("Deseas finalizar ingresa 0");
            bandera = s.nextInt();

            llenarArray();
        }



    }
}
