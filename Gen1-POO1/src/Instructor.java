public class Instructor {
    //Tiene atributos (variables) -> caracteristicas
    String nombre;
    String numTrabajador;
    Float salario;
    Integer edad;
    String tecnologia;


    //metodos (funciones) -> Acciones

    void explicar (String tema){
        System.out.println("Soy un instructor y estoy explicando el tema de " + tema);
    }

    void asignarTrabajo(Alumno a){
        System.out.println("Asigne un trabajo al alumno " + a.nombre);
    }

    void calificar (Alumno a){
        System.out.println("Estoy calificando los trabajos del alumno " + a.nombre);
    }

    //constructor

    Instructor(){
        nombre = "";
        edad = 0;
        numTrabajador = "";
        salario = 0F;
        tecnologia = "";
    }
}
