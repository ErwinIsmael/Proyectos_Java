public class C1 {
    public static void main(String[] args) {
        //Creamos cuatro objetos de la clase alumno (4 Instancias)
        Alumno a1 = new Alumno();
        Alumno a2 = new Alumno();
        Alumno a3 = new Alumno();
        Alumno a4 = new Alumno();

        //Cambiamos las caracteristicas de cada alumno

        a1.nombre = "Lazaro";
        a1.matricula = "LZR123";
        a1.edad = 25;
        a1.generacion = "Generacion 7 - Java 2023";

        a2.nombre = "Lizeth";
        a2.matricula = "LIZ789";
        a2.edad = 25;
        a2.generacion = "Generacion 7 - Java 2023";

        a3.nombre = "Edgar";
        a3.matricula = "EDG676";
        a3.edad =  25;
        a3.generacion = "Generacion 7 - Java 2023";

        a4.nombre = "Miguel";
        a4.matricula = "MIG932";
        a4.edad = 25;
        a4.matricula = "Generacion 7 - Java 2023";

        //Creamos un objeto de la clase instructor (1 instancia)
        Instructor i1 = new Instructor();

        //cambiamos las caracteristicas del instructor

        i1.nombre = "Javier Torres Timal";
        i1.salario = 123F;
        i1.numTrabajador = "JTF8945";
        i1.edad = 25;
        i1.tecnologia = "Java";

        //Representamos el escenario de la vida real
        i1.explicar("Programacion Orientada a Objetos");
        a3.realizarPregunta("¿Que es la herencia en la POO?");
        i1.explicar("Herencia");

        a3.tomarNota("La herencia es ...");
        a4.tomarNota("La herencia es ...");
        a1.realizarPregunta("¿Que es una clase abstracta?");
        i1.explicar("una clase abs es ...");
        a1.tomarNota("asbsbbds");

        i1.asignarTrabajo(a1);
        i1.asignarTrabajo(a2);
        //i1.asignarTrabajo(a3);
        i1.asignarTrabajo(a4);

        a1.entregarTarea();
        //a2.entregarTarea();
        //a3.entregarTarea();
        a4.entregarTarea();

        i1.calificar(a1);
        i1.calificar(a2);
        i1.calificar(a3);
        i1.calificar(a4);

    }
}
