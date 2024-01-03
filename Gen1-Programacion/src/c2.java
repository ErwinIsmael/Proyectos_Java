import java.util.Scanner;

public class c2 {
    public static void main(String[] args) {
        //Crear un programa en Java que lea dos numeros enteros y la suma, la resta
        //la multiplicacion y la division de los numeros

        //declaracion de variables


        int n1;
        int n2;
        int suma;
        int resta;
        int multiplicacion;
        double division;

        //declaracion de la "variable" que me permite leer datos ingresados por teclado
        Scanner s = new Scanner(System.in);

        System.out.println("Ingresa el primer numero: ");
        n1 = s.nextInt();

        System.out.println("Ingresa el segundo numero: ");
        n2 = s.nextInt();

        suma =  n1 + n2;
        resta = n1 - n2;
        multiplicacion = n1 * n2;
        division = n1/(n2 * 1.0);

        System.out.println("La suma es: " + suma);
        System.out.println("La resta es: " + resta);
        System.out.println("La multiplicacion es: " + multiplicacion);
        System.out.println("La division es: " + division);

    }
}
