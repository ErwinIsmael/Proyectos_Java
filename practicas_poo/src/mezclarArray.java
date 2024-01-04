import java.util.Scanner;

public class mezclarArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tam_array = 5;
        int a[],b[],c[];
        a = new int[tam_array];
        b = new int[tam_array];
        c = new int[tam_array * 2];

        System.out.println("Digite el primer array");
        for (int i = 0; i<tam_array;i++){
            System.out.print("Ingresa el valor ["+(i+1)+"]");
            a[i] = s.nextInt();
        }

        System.out.println("Digite el segundo array");
        for (int i = 0; i<tam_array;i++){
            System.out.print("Ingresa el valor ["+(i+1)+"]");
            b[i] = s.nextInt();
        }

        //mezclar los dos arreglos en el arreglo c
        int j = 0;
        for (int i = 0; i<a.length;i++){
            c[j] = a[i];
            j++;
            c[j] = b[i];
            j++;
        }

        for(int i:c){
            System.out.print("[ "+i +"] ");

        }

    }
}

