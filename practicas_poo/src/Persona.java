public class Persona {
    String nombre;
    int edad;
    String dni;
    //metodos

    //metodo constructor
    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;

    }
    public Persona(String dni){
        this.dni = dni;
    }

    public void correr(){
        System.out.println("Soy "+nombre+" tengo "+edad+" años y estoy corriendo un maraton");
    }

    public void correr(int km){
        System.out.println("He corrido "+km+" km");
    }


    public void mostrarDatos(){
        System.out.println("El nombre es:" + nombre);
        System.out.println("La edad es: " + edad);

    }




}
