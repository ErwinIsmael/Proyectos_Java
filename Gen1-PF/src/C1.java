import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.*;

public class C1 {
    public static void main(String[] args) {

        //Definicion de una expresion Lambda de tipo: CONSUMER
        //EL CONSUMER NO REGRESA NINGUN VALOR DE RETORNO

        Consumer<String> consumidor = (cadena) -> {
            System.out.println(cadena.toUpperCase());
        };
        consumidor.accept("Javier");

        //ejemplo de uso de consumer

        List<String> listadoAlumnos = new ArrayList<>();
        listadoAlumnos.add("Erwin");
        listadoAlumnos.add("Lizbeth");
        listadoAlumnos.add("Ismael");
        listadoAlumnos.add("Francisco");
        listadoAlumnos.add("Nallely");

        listadoAlumnos.forEach(consumidor);

//uso de Predicate
        System.out.println(listadoAlumnos);
        Predicate<String> logicaBorrado = (nombreAlumnos) -> {
            char primeraLetra = nombreAlumnos.charAt(0);
            return (primeraLetra == 'N' || primeraLetra == 'n');
        };

        listadoAlumnos.removeIf(logicaBorrado);
        System.out.println(listadoAlumnos);




        //Definicion de una expresion Lambda de tipo: BICONSUMER
        //EL BICOMSUMER NO REGRESA NINGUN VALOR DE RETORNO

        BiConsumer<String, Integer> consumidor3 = (nombre, anio) -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Integer edad = Integer.parseInt(sdf.format(new Date())) - anio;
            System.out.println(nombre + " tiene " + edad + " años!");
        };

        consumidor3.accept("Javier", 1964);

        //Definicion de una expresion Lambda de tipo: Supplier
        //El Supplier es capaz de retornar un valor de retorno

        Supplier<String> crearSaludo = () -> {
            return "Hola Javier como estas, que tal tu dia";
        };
        //consumir el Supplier
        System.out.println(crearSaludo.get());

        //Definicion de expresion lambda de tipo: Function
        //Function es capaz de retornar un valor y aceptar parametros
        Function<String, Integer> cuentaCaracteres = (nombre) -> {
            return nombre.length();
        };
        System.out.println(cuentaCaracteres.apply("Hola"));

        //Definicion de una expresion lambda de tipo: BiFunction
        BiFunction<String, Integer, String> saludar3 = (nombre, anio) -> {
          SimpleDateFormat sfd = new SimpleDateFormat("yyyy");
          Integer edad = Integer.parseInt(sfd.format(new Date())) - anio;
          return  nombre + " tiene " + edad + " años ";
        };
        System.out.println(saludar3.apply("Javier Torres Timal", 1994));

        //Definicion de una expresion lambda de tipo: Predicate
        //Predicate recibe un argumento y retorna un boolean
        Predicate<Integer> prueba = (numero) -> {
          return  numero == 0;
        };

        System.out.println(prueba.test(2));




    }
}
