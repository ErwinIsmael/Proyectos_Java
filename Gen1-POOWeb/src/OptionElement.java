public class OptionElement {
    //atributos / caracteristicas

    private String valor;
    private String display;


    public OptionElement(String valor, String display){
        this.valor = valor;
        this.display = display;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
