import java.util.Scanner;

public class arrayEjercicio {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        float [] numeros = new float[5];
        float sumPositivos = 0;
        float sumNegativos = 0;
        int conteo_positivos = 0;
        int conteo_negativos = 0;
        int conteo_ceros = 0;
        float media_positivos, media_negativos;

        System.out.println("Guardar los numeros en el arreglo");

        for(int i = 0; i<5;i++){
            System.out.println("Ingresa el valor "+(i+1));
            numeros[i] = s.nextFloat(); 
            
            if(numeros[i] == 0){
                conteo_ceros++;
            } else if (numeros[i] > 0) {
                sumPositivos +=numeros[i];
                conteo_positivos++;
            } else {
                sumNegativos += numeros[i];
                conteo_negativos++;
            }

        }
        //media de numeros positivos

        if(conteo_positivos == 0){
            System.out.println("No se puede obtener este resultado de los numeros positivos");
        } else {
            media_positivos = sumPositivos / conteo_positivos;
            System.out.println("La media de los numeros positivos es: " + media_positivos);
        }
        //media de numeros negativos

        if (conteo_negativos == 0){
            System.out.println("No se puede obtener el resultado de la media de los numeros negativos");
        } else {
            media_negativos = sumNegativos / conteo_negativos;
            System.out.println("La media de los numeros negaticvos es :" + media_negativos);
        }
        System.out.println("La cantidad de ceros es: " + conteo_ceros);
    }
}
