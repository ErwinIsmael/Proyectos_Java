public class proyectoCalculadora {
    public static void main(String[] args) {

            Calculadora miCalculadora = new Calculadora(10, 2);
            //el 10 es el operador 1 y el 2 es el operador 2

        int suma = miCalculadora.sumar();
        int resta = miCalculadora.restar();

        System.out.println("La suma es: " + suma);
        System.out.println("La resta es: " + resta);
    }
}
