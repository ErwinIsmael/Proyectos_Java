public abstract class ElementoBase {
    //atributos/caracteristicas (variables)
    protected String valor;
    protected String nombre;
    protected String id;

    //funciones/metodos/acciones
    public abstract String pintar();

    //constructures
    public ElementoBase(){

    }

    public ElementoBase(String valor, String nombre, String id){
        this.valor = valor;
        this.nombre = nombre;
        this.id = id;
    }


}
