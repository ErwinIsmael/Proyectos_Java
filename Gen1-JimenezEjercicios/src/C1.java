import java.util.Scanner;

public class C1 {
    public static void main(String[] args) {

        int alumnos;
        int alumnas;
        double total;
        double porcentajeAlumnos;
        double porcentajeAlumnas;

        Scanner s = new Scanner(System.in);

        System.out.println("Ingresa el numero de alumnos que hay en tu clase: ");
        alumnos = s.nextInt();
        System.out.println("Ingresa el numero de alumnas que hay en tu clase: ");
        alumnas = s.nextInt();

        total = (alumnos) + (alumnas);
        porcentajeAlumnos = (alumnos / total) * 100;
        porcentajeAlumnas = (alumnas / total) * 100;

        System.out.println("El total de alumnos en el salon es: " + (int)total + " alumnos");
        System.out.println("El porcentaje de alumnos es: " + (int)porcentajeAlumnos + " % ");
        System.out.println("El porcentaje de alumnas es: " + (int)porcentajeAlumnas + " % ");
    }
}
