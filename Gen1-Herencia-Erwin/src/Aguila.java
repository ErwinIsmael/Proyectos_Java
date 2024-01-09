public class Aguila extends BaseAnimals{

    private Integer numeroAlas;
    private String colorPlumas;
    private String colorPico;
    private Double alturaVuelo;
    @Override
    public String comer() {
        return "Tras cazar el Aguila disfruta de comer al capturar y deglutar, ya que su alimentacion es de tipo: " + this.Alimentacion;
    }

    @Override
    public String emitirSonido() {
        return "El Aguila hace el siguiente sonido SONIDO 'Chillido,Graznar'";
    }

    @Override
    public String cazar() {
        return "La forma de capturar a sus presas es por los cielos a una altura de "+this.alturaVuelo+"mts. despues captura con sus garras al animal";
    }

    @Override
    public String reproducir() {
        if (this.edad > 4){
            return "El Aguila tiene mas de "+this.edad+" y el color de sus alas son por lo tanto este se reproduce";
        } else {
            return "El Aguila no alcanza su edad adulta";
        }
    }


    //constructores


    public Aguila() {
    }


    public Aguila(String especie, Double tamano, Double peso, String habitad, String alimentacion, Integer edad, Double alturaVuelo) {
        super(especie, tamano, peso, habitad, alimentacion, edad);
        this.alturaVuelo = alturaVuelo;
    }

    //setter and getter
    public Integer getNumeroAlas() {
        return numeroAlas;
    }

    public void setNumeroAlas(Integer numeroAlas) {
        this.numeroAlas = numeroAlas;
    }

    public String getColorPlumas() {
        return colorPlumas;
    }

    public void setColorPlumas(String colorPlumas) {
        this.colorPlumas = colorPlumas;
    }

    public String getColorPico() {
        return colorPico;
    }

    public void setColorPico(String colorPico) {
        this.colorPico = colorPico;
    }

    public Double getAlturaVuelo() {
        return alturaVuelo;
    }

    public void setAlturaVuelo(Double alturaVuelo) {
        this.alturaVuelo = alturaVuelo;
    }
}
