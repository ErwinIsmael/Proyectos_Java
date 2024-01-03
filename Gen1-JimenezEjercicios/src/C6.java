import java.util.Scanner;

public class C6 {
    public static void main(String[] args) {
        //solicitrar 3 voltajes
        //Si el promedio de los voltajes es menor a 115, muestra: “VOLTAJE VÁLIDO”,
        //si es mayor a 115 y menor a 220 muestre “ALTO VOLTAJE” y
        // si es mayor a 220 visualice “PELIGRO”.

        int v1;
        int v2;
        int v3;
        double promedio;

        Scanner s = new Scanner(System.in);

        System.out.println("Ingresa el primer voltaje");
        v1 = s.nextInt();
        System.out.println("Ingresa el segundo voltaje");
        v2 = s.nextInt();
        System.out.println("Ingresa el Tercer voltaje");
        v3 = s.nextInt();

        promedio = (v1+v2+v3) / 3.0;


        if(promedio < 115){
            System.out.println("VOLTAJE VALIDO");
        }else if (promedio > 155 && promedio < 220){
            System.out.println("ALTO VOLTAJE");
        } else if (promedio > 220) {
            System.out.println("PELIGRO");
        }


    }
}
