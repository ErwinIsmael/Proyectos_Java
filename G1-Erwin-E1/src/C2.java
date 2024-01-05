import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C2 {

    public static void main(String[] args) {
        int numero;
        int numMayor = 0;
        int suma = 0;
        int numMenor = 0;


        Scanner s = new Scanner(System.in);


        List<Integer> numeros = new ArrayList<>();

        for(int i = 0; i<5;i++ ){
            System.out.println("Ingresa el numero "+ (i+1));
            numero = s.nextInt();
            numeros.add(numero);

            while(numeros.get(i) < 0){
                System.out.println("No se admiten numeros negativos, ingresa solo numeros positivos");
                numero = s.nextInt();
                numeros.add(numero);
                i++;
            }


            if(i==0){
                numMayor = numeros.get(i);
                numMenor = numeros.get(i);
            }
            if(numMayor > numeros.get(i)){
                numMenor = numeros.get(i);
            }else if (numMenor < numeros.get(i)) {
                numMayor = numeros.get(i);
            }
        }

        for(int num:numeros){
            suma += num;
        }
        System.out.println("La suma de los numeros es: -> " + suma);
        System.out.println("**-< " +numeros.size());
        System.out.println("El promedio de los numeros es: -> "+ (double)(suma / numeros.size()));
        System.out.println("El numero Mayor es: -> " + numMayor);
        System.out.println("El numero menor es: -> " + numMenor);


    }
}
