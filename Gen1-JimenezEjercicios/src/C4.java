import java.util.Scanner;

public class C4 {
    public static void main(String[] args) {

        //Obtener el area de cuerpo geometrico
        //obtener datos por usuario
            //altura
            //diagonal mayor
            //diagonal menor

        //formula para sacar area de prisma rectangular con base de rombo
            // area X altura = volumen
            // area = (D X d) / 2

        double altura;
        double dMayor;
        double dMenor;
        double area;
        double volumen;

        Scanner s = new Scanner(System.in);

        System.out.println("Ingresa el valor de la altura del cuerpo geometrico: ");
        altura = s.nextDouble();
        System.out.println("Ingresa el valor de la diagonal mayor del cuerpo geometrico: ");
        dMayor = s.nextDouble();
        System.out.println("Ingresa el valor de la diagonal menor del cuerpo geometrico");
        dMenor = s.nextDouble();

        area = (dMayor * dMenor) / 2;
        volumen = area * altura;

        System.out.println("El area del cuerpo geometrico es: " + volumen);
    }
}
