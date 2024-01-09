public class InputElement extends ElementoBase{

    //atributos / caracteristicas
    private String tipo;




    //metodos
    @Override
    public String pintar() {
        return "<input type =" + this.tipo
        + " name=" + nombre
        + " value=" + valor + ">";
    }

    //constructores
    public InputElement(String valor, String nombre, String id){
        super(valor,nombre,id);

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
