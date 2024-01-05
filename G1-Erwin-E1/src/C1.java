import java.util.Scanner;

public class C1 {
    //realizar un programa en JAva que permite ingrsar 20
    // numeros enteros mediante un ciclo de repeticion (cualquier ciclo)
            // muestre el numero mayor,
            // el numero menor,
            // el promedio y
            // la suma de los nymeros//
    // el sistema NO DEBE PERMITIR EL INGRESO DE NUMEROS NEGATIVOS, SOLAMENTE NUMEROS MAYORES A 0
    // realizar el ejercicio utilizando ARREGLOS

    public static void main(String[] args) {

        int cantidad;
        int numMayor = 0;
        int suma = 0;
        int numMenor = 0;


        Scanner s = new Scanner(System.in);
        System.out.print("Ingresa la cantidad de numeros que deseas analizar: ");
        cantidad = s.nextInt();


        int numeros[] = new int[cantidad];

        for(int i = 0; i< numeros.length; i++){
            System.out.println("Ingresa el numero "+ (i+1));
            numeros[i] = s.nextInt();

            while(numeros[i] < 0){
                System.out.println("No se admiten numeros negativos, ingresa solo numeros positivos");
                numeros[i] = s.nextInt();
            }

            if(i==0){
                numMayor = numeros[i];
                numMenor = numeros[i];
            }
            if(numMayor > numeros[i]){
                numMenor = numeros[i];
            }else if (numMenor < numeros[i]) {
                numMayor = numeros[i];
            }
        }

        for(int num:numeros){
            suma += num;
        }
        System.out.println("La suma de los numeros es: -> " + suma);
        System.out.println("El promedio de los numeros es: -> "+ (double)(suma / cantidad));
        System.out.println("El numero Mayor es: -> " + numMayor);
        System.out.println("El numero menor es: -> " + numMenor);

    }
}
