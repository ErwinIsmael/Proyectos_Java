public abstract class BaseAnimals {
    //atributos / cacarteristicas
    protected String especie;
    protected Double tamano;
    protected Double peso;
    protected String habitad;
    protected String Alimentacion;
    protected Integer edad;


    //funciones / acciones

    public abstract String comer();
    public abstract String emitirSonido();
    public abstract String cazar();
    public abstract String reproducir();

    //constructores


    public BaseAnimals() {

    }

    public BaseAnimals(String especie, Double tamano, Double peso, String habitad, String alimentacion, Integer edad) {
        this.especie = especie;
        this.tamano = tamano;
        this.peso = peso;
        this.habitad = habitad;
        this.Alimentacion = alimentacion;
        this.edad = edad;
    }
}
