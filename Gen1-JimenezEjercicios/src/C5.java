import java.util.Scanner;

public class C5 {
    public static void main(String[] args) {

        //leer 25 números
        //Calcular el promedio
        //Obtener numero Mayor
        //Obtener numero menor

        int totalNum;
        int numero;
        double promedioNumeros = 0;
        int numeroMayor = 0;
        int numeroMenor = 0;

        Scanner s = new Scanner(System.in);
        System.out.println("Ingresa la cantidad de numeros que deseas ingresar");
        totalNum = s.nextInt();


        for( int i = 0; i <= totalNum; i++){

            System.out.println("Ingresa el numero " + i);
            numero = s.nextInt();
            promedioNumeros = promedioNumeros + numero;


            if(i == 0){
                numeroMenor = numero;
                numeroMayor = numero;

            }else if (numero > numeroMayor){
                numeroMayor = numero;
                System.out.println("MAYOR = " + numeroMayor);

            }else if(numero < numeroMenor){
                numeroMenor = numero;
                System.out.println("MENOR = " + numeroMenor);
            }


        }

        promedioNumeros = promedioNumeros / totalNum;
        System.out.println("La suma total de todos los numeros es = " + promedioNumeros);
        System.out.println("El numero mayor de los "+ totalNum +" es: " + numeroMayor );
        System.out.println("El numero menor de los "+ totalNum +" es: " + numeroMenor );

    }
}
