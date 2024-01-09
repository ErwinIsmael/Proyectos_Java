public class Edificios {

    String ubicacion;
    Integer numeroPisos;
    String nombre;
    Double metros;
    Double altura;


    void encenderLuz(){
        System.out.println("Encender luces al detectar movimiento");
    }

    Edificios(){
        ubicacion = "";
        numeroPisos = 0;
        nombre = "";
        metros = 0D;
        altura = 0D;
    }
}
