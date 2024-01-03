import java.util.Scanner;

public class C3 {
    public static void main(String[] args) {

        //solicitar el número de respuestas correctas, incorrectas y en blanco
        //muestre su puntaje final
            //Considerar  que que por cada r e s p u e s t a correcta tendrá 4 p u n t o s, respuestas incorrectas tendrá -1 y respuestas en blanco tendrá 0.

        int correctas;
        int incorrectas;
        int enBlanco;
        int puntaje;

        Scanner s = new Scanner(System.in);

        System.out.println("Sistema de Calificacion a postulantes");

        System.out.println("Ingresa el numero de respuestas correctas: ");
        correctas = s.nextInt();
        System.out.println("Ingresq el numero de respuestas incorrectas: ");
        incorrectas = s.nextInt();
        System.out.println("Ingresa el numero de respuestas en blanco: ");
        enBlanco = s.nextInt();


        correctas = (correctas * 4);
        incorrectas = (incorrectas * (-1));
        enBlanco = 0;

        puntaje = correctas + incorrectas + enBlanco;

        System.out.println("El puntaje final es: " + puntaje);

    }
}
