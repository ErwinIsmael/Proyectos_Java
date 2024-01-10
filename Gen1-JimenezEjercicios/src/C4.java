import java.util.Scanner;

public class C4 {



    static void solucionCorrecta(){
        double alturaPrisma;
        double diagonalMayor;
        double diagonalMenor;
        double areaRectangulo;
        double catetoRestante;
        double areaCaras;
        double areaTapa;
        double areaTapas;
        double areaTotal;

        Scanner s = new Scanner(System.in);

        System.out.println("Ingresa el valor de la altura: ");
        alturaPrisma = s.nextDouble();
        System.out.println("Ingresa la diagonal menor");
        diagonalMenor = s.nextDouble();
        System.out.println("Ingresa la diagonal mayor");
        diagonalMayor = s.nextDouble();

        catetoRestante = Math.sqrt ( ((diagonalMayor/2) * (diagonalMayor/2) ) + ((diagonalMenor / 2) * (diagonalMenor/2)));
        areaRectangulo = catetoRestante * alturaPrisma;
        areaCaras = areaRectangulo * 4;
        areaTapa = (diagonalMayor * diagonalMenor) / 2;
        areaTapas = areaTapa * 2;
        areaTotal = areaCaras + areaTapas;
        System.out.println("El resultado es: "+ areaTotal);

    }
    public static void main(String[] args) {

        //Obtener el area de cuerpo geometrico
        //obtener datos por usuario
            //altura
            //diagonal mayor
            //diagonal menor

        //formula para sacar area de prisma rectangular con base de rombo
            // area X altura = volumen
            // area = (D X d) / 2



        solucionCorrecta();
        /*
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

         */
    }
}
