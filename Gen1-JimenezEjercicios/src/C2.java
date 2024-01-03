import java.util.Scanner;

public class C2 {
    public static void main(String[] args) {

        //Compra de 5 articulos diferentes
        //, calcula el monto a pagar
        //tomando en cuenta que el IVA es del 16%
        //resultados a obtener son Subtotal, IVA y Total a pagar

        int numArticulo;
        double subtotal = 0.0;
        double precio = 0.0;
        double iva;
        double total;

        Scanner s = new Scanner(System.in);

        System.out.println("Ingresa el numero de articulos a comprar: ");
        numArticulo = s.nextInt();

        for(int i = 0; i < numArticulo; i++){
            System.out.println("Ingresa el costo del producto " + (i + 1) + ": ");
            precio = s.nextDouble();
            subtotal = subtotal + precio;

        }
        iva = (subtotal * 0.16);
        total = subtotal + iva;

        System.out.println("El subtotal de la compra es: " + subtotal);
        System.out.println("El total de IVA es: " + iva);
        System.out.println("El total a pagar es: " + total);
    }
}
