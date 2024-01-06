public class C1 {
    public static void main(String[] args) {
        System.out.println(suma(2,5));
        System.out.println(resta(5,10));
        System.out.println(multiplicacion(2,3));
        System.out.println(division(10,2));

    }

    //crear una funcnion que reciba como argumernto dos numeros enteros y regrese la suma de ellos
    static int suma(int a, int b){ return a + b; }
    //crear una funcion que recibe como argumento dos numeros enteros y regrese la resta de ellos
    static int resta(int a, int b){ return a - b; }
    //crear una funcion que recibe como argumento dos numeros enteros y regrese la multiplicacion de ellos
    static int multiplicacion (int a, int b){ return a * b;}
    //crear una funcion que recibe como argumento dos numeros enteros y regrese la division de ellos
    static double division (int a, int b) { return a / (b * 1.0);}


}
