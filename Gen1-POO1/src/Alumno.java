import java.util.ArrayList;
import java.util.List;

public class Alumno {
    //atributos (variables) -> caracteristicas

    String nombre;
    String matricula;
    Integer edad;
    List<Integer> calificaciones;
    String generacion;


    //metodos (funciones) -> Acciones
    void tomarNota(String texto){
        System.out.println("Soy el alumno" + nombre + " y estoy tomando nota del texto" + texto);
    }

    void entregarTarea(){
        System.out.println("Estoy entregando una tarea");
    }

    void realizarPregunta(String pregunta){
        System.out.println("Mi pregunta es: " + pregunta);
    }

    String contestarPregunta(){
        return "Mi respuesta es....";
    }

    //constructor

    Alumno(){
        nombre = "";
        edad = 0;
        matricula = "";
        generacion = "";
        calificaciones = new ArrayList<>();
    }

}
