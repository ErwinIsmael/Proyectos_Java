public class Portero {
    String nombre;
    String numeroTrabajador;
    Float sueldo;
    String genero;
    Boolean proteccion;
    Integer edad;

    void saludar(String texto){
        System.out.println(texto);
    }
    void abrirPuerta(String texto){
        System.out.println(texto+" Estoy abriendo la puerta");
    }

    void revisar(){
        System.out.println("Revisare que no tenga objetos que no se admitan");
    }
    void registrarAcceso(String text, Object obj){
        System.out.println(text+obj);
    }
    Portero(){
        nombre = "";
        numeroTrabajador = "";
        sueldo = 0F;
        genero = "";
        proteccion = false;
        edad = 0;
    }

}
