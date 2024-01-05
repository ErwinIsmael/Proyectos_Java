
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class C2_Lista {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<List<Double>>  calificaciones = new ArrayList<>();

        //Double[] numero = new Double[10];
        List<Double> numero = new ArrayList<>();
        double suma = 0.0;

        for (int j = 0; j<3; j++){
            for (int i = 0; i<10 ; i++){
                numero.add(s.nextDouble());
            }
            calificaciones.add(numero);
        }
        for (int j = 0; j<3;j++){
            for (int i = 0; i< 10;i++){
                System.out.print(calificaciones.get(j).get(i)+", ");
            }
            System.out.println("\n");
        }

        for (int i = 0; i<3; i++){
            for (int j = 0; j < 10; j++) {

                suma += calificaciones.get(i).get(j);

            }
            System.out.println("Suma: "+suma);
        }


    }
}