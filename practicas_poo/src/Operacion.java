import javax.swing.*;

public class Operacion {
    //Atributos

    //Metodos

    //Crear metodo para solicitrar al usuario que digite los 2 numeros


    public int sumar(int num1, int num2){
        int suma;
        suma = num1 +num2;
        return suma;
    }
    public int restar(int num1, int num2){
        int resta;
        resta = num1 - num2;
        return resta;
    }

    public int multiplicar(int num1, int num2){
        int multiplicacion;
        multiplicacion = num1 * num2;
        return multiplicacion;
    }

    public int dividir(int num1, int num2){

        int division;
        division = num1 / num2;
        return division;
    }

    public void mostrarResultados(int suma, int resta, int multiplicacion, int division){
        System.out.println("La suma es: "+ suma);
        System.out.println("La resta es: "+ resta);
        System.out.println("La multiplicacion es: "+ multiplicacion);
        System.out.println("La division es: "+ division);
    }


}
