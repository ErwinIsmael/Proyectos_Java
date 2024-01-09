public class Delfin extends BaseAnimals {

    //atributos / caracteristicas
    private Integer numeroAletas;
    private Integer velocidadDeNado;


    @Override
    public String comer() {
        return "Tras cazar el delfin disfruta de comer al masticar y deglutar, ya que su alimentacion es de tipo: " + this.Alimentacion;
    }

    @Override
    public String emitirSonido() {
        return "El delfin hace el siguiente sonido SONIDO 'Chasquido y silbido'";
    }

    @Override
    public String cazar() {

        return "El delfin se alimenta de otros animales del " +this.habitad+" por lo tanto caza al romper en trozos a sus presas lo puede hacer a una velocidad de nado de: "+this.velocidadDeNado;

    }

    @Override
    public String reproducir() {

        if (this.edad > 11){
            return "El delfin tiene mas de "+this.edad+" por lo tanto este se reproduce";
        } else {
            return "El delfin no alcanza su edad adulta";
        }
    }

    //metodos propios
    public String nadar(){

        return "El delfin nada por "+this.habitad+" a una velocidad de "+this.velocidadDeNado+" km";
    }

    //constructores


    public Delfin(String especie, Double tamano, Double peso, String habitad, String alimentacion, Integer edad) {
        super(especie, tamano, peso, habitad, alimentacion, edad);
    }


    //setter and getter

    public Integer getVelocidadDeNado() {
        return velocidadDeNado;
    }

    public void setVelocidadDeNado(Integer velocidadDeNado) {
        this.velocidadDeNado = velocidadDeNado;
    }

    public Integer getNumeroAletas() {
        return numeroAletas;
    }

    public void setNumeroAletas(Integer numeroAletas) {
        this.numeroAletas = numeroAletas;
    }
}
