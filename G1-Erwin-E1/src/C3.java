import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C3 {
    public static void main(String[] args) {

        //REALIZAR UN PROGRAMA EN JAVA QUE SOLICITE 10 CALIFICACIONES PARA N ALUMNOS,
        // OBTENGA EL PROMEDIO DE CADA UNO
        // OBTENGA EL PROMEDIO GRUPAL,
        // INDIQUE EL NUMERO DE ALUMNOS APROBADOS Y EL NUMERO DE ALUMNOS REPROBADOS
        // el programa debera permitir buscar un alumno por nombre y mostrar sus 10 calificaciones

        int numAlumnos = 0;
        String nombre;
        double prom = 0.0;
        int numMaterias = 10;
        int aprobado = 0;
        int reprobado = 0;

        Scanner s = new Scanner(System.in);

        System.out.println("Ingresa el numero de alumnos: ");
        numAlumnos = s.nextInt();

        String [] alumnos = new String[numAlumnos];
        int [][] calificacion = new int[numAlumnos][10];
        double [] promedio = new double[numAlumnos];


        for(int i = 0; i < numAlumnos; i++){
            System.out.print("Ingresa el nombre del "+ (i+1) +" alumno: ");
            alumnos[i] = s.next();
            //ciclo para guardar las calificacion y sumar todas las calificaciones de un alumno
            for(int j = 0; j < numMaterias; j++){
                System.out.println("Ingresa la calificacion "+ (j+1));
                calificacion[i][j] = s.nextInt();
                prom += calificacion[i][j];
            }
            //operacion para sacar promedio e imprimir el promedio de los dos alumnos
            //System.out.println("promedio = " + promedio / 10 );
            prom = prom / numMaterias;
            promedio[i] = prom;
            prom = 0;

            if(promedio[i] >= 6 && promedio[i] <= 10){
                aprobado++;

            }else if(promedio[i]<= 5.9){
                reprobado++;
            } else {
                System.out.println("Error");
            }

        }


        for(double sum:promedio){
            prom += sum;
        }
        System.out.println("Promedio general: "+(prom / numAlumnos));
        System.out.println("Numero de Aprobados: "+ aprobado);
        System.out.println("Numero de Reprobados: "+ reprobado);

        System.out.println("Coloca el nombre del alumno a buscar y ver sus calificaciones: ");
        nombre = s.next();
        for (int l = 0; l<alumnos.length; l++){
            if (nombre.equals(alumnos[l])){
                System.out.println("Las calificaciones de: "+nombre);
                for (int m = 0; m < calificacion.length; m++){
                System.out.println("calificacion materia "+(m+1)+" es: "+calificacion[l][m]);
                }
                System.out.println(alumnos[l]+" promedio final = " + promedio[l]);
            }
           // for(int k = 0; k < alumnos.length;k++){ System.out.println(alumnos[k]+" promedio final = " + promedio[k]); }
        }

    }
}
