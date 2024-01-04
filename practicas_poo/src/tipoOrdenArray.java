import java.util.Scanner;

public class tipoOrdenArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int tamArray = 5;
        int a[] = new int[tamArray];

        boolean creciente = false;
        boolean decreciente = false;


        System.out.println("Llenar el arreglo");
        for(int i = 0; i<tamArray; i++){
            System.out.println("Ingresa el valor " + (i+1));
            a[i] = s.nextInt();
        }

        for (int i = 0; i < tamArray-1; i++){
            if (a[i] < a[i+1]){
                creciente = true;
            }
            if(a[i] > a[i+1]){
                decreciente = true;
            }
        }
        if (creciente == true && decreciente == false){
            System.out.println("El arreglo esta en forma creciente");
        } else if (creciente == false && decreciente==true) {
            System.out.println("El arreglo esta en forma decreciente");
        } else if ( creciente == true && decreciente == true) {
            System.out.println("La serie esta desordenada");
        } else if( creciente == false && decreciente == false){
            System.out.println("Todos los numeros son iguales");

        }

    }
}
