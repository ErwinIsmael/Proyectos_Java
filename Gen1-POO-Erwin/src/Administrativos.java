public class Administrativos {
    String nombre;
    String puesto;
    String numeroTrabajador;
    Integer edad;



    void saludar (String texto, String nombre, String puesto){
        System.out.println("Buen dia soy "+nombre+" del puesto: "+puesto+" "+ texto);
    }

    void aplicarExamen(Integer tiempo, String tipo){
        System.out.println("Tome asiento, tiene "+tiempo+" hora para realizar el examen y es "+tipo);
    }

    void permitirAcceso(String text){
        System.out.println("Puede pasar " + text);
    }

    void responder(String texto){
        System.out.println(texto);
    }
    void solicitarDocumentos(String text){
        System.out.println(text);
    }

    Administrativos(){
        nombre = "";
        puesto = "";
        numeroTrabajador = "";
        edad = 0;
    }

}
