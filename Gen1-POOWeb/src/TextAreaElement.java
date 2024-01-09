public class TextAreaElement extends ElementoBase{

    //metodos
    private int filas;
    private int columnas;


    @Override
    public String pintar() {
      return "<textarea name = " + this.nombre + " cols= "
              + this.columnas + " rows= " + this.filas + ">"
              + this.valor + "</textarea>";
    }


    //constructores

    public TextAreaElement(String valor, String nombre, String id){
        super(valor, nombre, id);
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
}
