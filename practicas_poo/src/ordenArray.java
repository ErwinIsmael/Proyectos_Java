import java.util.Scanner;

public class ordenArray {

    public static void main(String[] args) {
        int nelementos;

        Scanner s = new Scanner(System.in);

        System.out.print("Ingresa la cantidad de numeros a almacenar: ");
        nelementos = s.nextInt();

        float [] numeros = new float[nelementos];

        for (int i = 0; i<nelementos; i++){
            System.out.print("Ingresa el numero "+ (i+1)+": ");
            numeros[i] = s.nextFloat();
        }

        for (float num:numeros){
            System.out.println("Numero: "+num);
        }
    }
}
