public class Leon extends BaseAnimals{

    private Integer numeroPatas;
    private Boolean melena;


    @Override
    public String comer() {
        return "Tras cazar el leon disfruta de comer al masticar y deglutar, ya que su alimentacion es de tipo: " + this.Alimentacion;
    }

    @Override
    public String emitirSonido() {
        return "El leon hace el siguiente sonido SONIDO 'Rugido'";
    }


    @Override
    public String cazar() {

            return "El leon  macho suele proteger a la manada y mayormente espera que la leona caze y el leon hembra suele cazar en grupos utilizando tecnicas de acecho y emboscada";

    }

    @Override
    public String reproducir() {

        if (this.edad > 4){
            return "El leon tiene mas de "+this.edad+" por lo tanto este se reproduce";
        } else {
            return "El leon no alcanza su edad adulta";
        }
    }

    //constructores


    public Leon() {
    }

    public Leon(String especie, Double tamano, Double peso, String habitad, String alimentacion, Integer edad) {
        super(especie, tamano, peso, habitad, alimentacion, edad);
    }

    //setter and getter
    public Integer getNumeroPatas() {
        return numeroPatas;
    }

    public void setNumeroPatas(Integer numeroPatas) {
        this.numeroPatas = numeroPatas;
    }

    public Boolean getMelena() {
        return melena;
    }

    public void setMelena(Boolean melena) {
        this.melena = melena;
    }

}
