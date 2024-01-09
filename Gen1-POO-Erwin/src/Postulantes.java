public class Postulantes {
    String nombre;
    Integer edad;
    String folio;
    String genero;


    void LlegarALugar(String nombre){
        System.out.println("Soy "+nombre+" LLegando a sitio para aplicar prueba ...");
    }
    void tocarPuerta(){
        System.out.println("Estoy tocando la puerta ");
    }

    void saludar(String nombre){
        System.out.println("Buen dia soy "+nombre);
    }
    void solicitarAcceso(String motivo, Integer edad, String folio){
        System.out.println("Soy un postulante y estoy solicitando acceso " + motivo+" tengo "+edad+" y mi numero de folio es: "+ folio);
    }

    void entrar(){
        System.out.println("Estoy caminando");
    }

    void subirEscaleras(){
        System.out.println("Estoy subiendo escaleras");
    }

    void sentar(){
        System.out.println("Estoy tomando asiento");
    }

    void tomarobjeto(Object objeto){
        System.out.println("Estoy tomando un "+ objeto);
    }
    void aplicarExamen(String nombre, Integer preguntas){
        System.out.println("Yo "+nombre+" Estoy aplicando el examen de "+preguntas+" preguntas");
    }
    void entregarDocumentacion(String text, String folio){
        System.out.println(text+" "+folio);
    }

Postulantes(){
        nombre = "";
        edad = 0;
        folio = "";
        genero = "";
}

}
