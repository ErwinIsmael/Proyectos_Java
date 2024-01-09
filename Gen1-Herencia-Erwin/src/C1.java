public class C1 {

    public static void main(String[] args) {
        Delfin d1 = new Delfin("mamifero", 1.9, 110.0, "Oceano", "Carnivoro", 12);
        d1.setVelocidadDeNado(8);
        Delfin d2 = new Delfin("mamifero", 2.0,115.2,"Ocenao", "Carnivoro",4 );
        d2.setVelocidadDeNado(4);

        System.out.println(d1.comer());
        System.out.println(d1.emitirSonido());
        System.out.println(d1.nadar());

        Leon l1 = new Leon("mamifero",2.6, 80.54,"Sabana", "Carnivoro", 8);
        Leon l2 = new Leon("Mamifero",2.3, 90.12,"Sabana","Carnivoro",2);

        System.out.println(l1.cazar());
        System.out.println(l1.comer());
        System.out.println(l2.reproducir());

        Aguila a1 = new Aguila("Oviparo", 0.80,3.2,"Montañas","Carnivora", 2, 6553.5);

        System.out.println(a1.cazar());
        System.out.println(a1.comer());
        System.out.println(a1.reproducir());
    }
}

