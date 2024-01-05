import java.util.Scanner;

public class prueba_array {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numAlum, i;
        double suma = 0, media, promedioIndividual;

        //Lectura del número de alumnos. Debe ser un valor positivo
        do {
            System.out.print("Número de alumnos de la clase: ");
            numAlum = sc.nextInt();
        } while (numAlum <= 0);

        //se crea un array llamado notas de numAlumn elementos de tipo double
        double[] calificacion = new double[4];

        // Entrada de datos. Se lee la nota de cada alummo y se guarda
        // en cada elemento del array
        for (i = 0; i < calificacion.length; i++) {
            System.out.print("Alumno " + (i + 1) + " Nota final: ");
            calificacion[i] = sc.nextDouble();
        }

        //calificacion individual
        for(i = 0; i < 4;i++){
            suma += calificacion[i];
        }
        // Sumar todas las notas
        for (i = 0; i < calificacion.length; i++) {
            suma += calificacion[i];
        }

        // Calcular la media
        media = suma / calificacion.length;

        // Mostrar la media
        System.out.printf("Nota media del curso: %.2f %n", media);

        // Mostrar los valores superiores a la media
        System.out.println("Listado de notas superiores a la media: ");
        for (i = 0; i < calificacion.length; i++) {
            if (calificacion[i] > media) {
                System.out.println("Alumno numero " + (i + 1)+ " Nota final: " + calificacion[i]);
            }
        }
    }

}
