public class Calculadora {

    private int operador1;
    private int operador2;

    //constructores

    public Calculadora(){

    }

    public Calculadora(int operador1, int operador2){
        this.operador1 = operador1;
        this.operador2 = operador2;

    }

    //metodos

    public int sumar(){ return this.operador1 + this.operador2;}

    public int restar(){ return this.operador1 - this.operador2;}

    public int multiplicar(){ return this.operador1 * this.operador2;}

    public double dividir(){ return (double)this.operador1 / (double)this.operador2;}

    public int getOperador1(){
        return operador1;
    }

    public void setOperador1(int operador1) {
        this.operador1 = operador1;
    }

    public int getOperador2() {
        return operador2;
    }

    public void setOperador2(int operador2) {
        this.operador2 = operador2;
    }
}
