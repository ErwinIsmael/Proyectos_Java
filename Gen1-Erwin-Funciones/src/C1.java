import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C1 {
    public static void main(String[] args) {
        //Declaracion de lista de numeros para inicializar y manipular la unica lista creada por la funcion aleatorio()
        List<Integer> numeros;
        numeros = aleatorios();
        String miCorreo = "";
        Scanner s = new Scanner(System.in);
        String [] text = {"Objetos","Mesa","Salon","Pizarra","Laptop","Computadora","Mouse","Libreta","Pantalla","Puerta"};

        //Impresion de funciones
        System.out.println("----- Lista de numeros creados aleatoriamente ---- ");
        System.out.println(numeros);
        System.out.println("----- Lista anterior separada por pares e impares ----");
        System.out.println(separacionLista(numeros));
        //Uso de funcion validarCorreo
        System.out.println("----- Validaremos tu correo electronico ------");
        System.out.print("Ingresa tu correo electronico: ");
        miCorreo = s.next();
        System.out.println("Correo valido: "+validarCorreo( miCorreo));
        //Uso de la funcion CrearTxt()
        crearTxt(text);
        System.out.println("El archivo txt esta creado satisfactoriamente");
    }
    //Funcion que permite crear numeros aleatorios con ayuda del objeto Random
    static List<Integer> aleatorios(){
        //Declaracion e inicializacion del objeto random y de la lista numeros
        List<Integer> numeros = new ArrayList<>();
        Random random = new Random();
        //ciclo que permite generar y almacenar los numeros aleatorios en la lista
        for (int i = 0; i < 10; i++){
            numeros.add(random.nextInt(101));
        }
        return numeros;
    }

    // Funcion que permite dividir los numeros pares e impares de una lista de numeros
    static List<List<Integer>> separacionLista(List<Integer> numeros){
        //Declaracion e inicializacion de listas
        List<Integer> par = new ArrayList<>();
        List<Integer> impar = new ArrayList<>();
        List<List<Integer>> number= new ArrayList<>();

        //Ciclo ForEach que permite recorrer una lista de numeros
        for(Integer num:numeros){
            //Validar los numeros que son pares e impares por medio de una condicion que divide los numeros y si se obtiene 0 es par
            //Se agrega los numeros a las listas pares e impares
            if (num%2 == 0){
                par.add(num);

            }else {
                impar.add(num);
            }
        }
        //Se agrega a la lista number de listas de numeros pares e impares
        number.add(par);
        number.add(impar);
        return number;
    }

    //Funcion que permite validar la escritura de un correo electronico
    static String validarCorreo(String email){
        //Declaracion de variables
        String validar = "";
        //Declaracion e inicializacion de variable con Formato para validar correo
        String formatoCorreo = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        //Uso de objeto Pattern y matcher para buscar y comparar el String con el formato de correo electronico
        Pattern busqueda = Pattern.compile(formatoCorreo);
        Matcher comparativa = busqueda.matcher(email);

        //Validar si el correo electronico esta bien escrito
        if(comparativa.find()){
            validar = "OK";
        }else {
            validar = "ERROR";
        }
        return validar;
    }

    //Funcion que permite crear archivo TXT
    static void crearTxt(String[] texto){
        String ruta = "cadenas.txt";

        try {
            //Declaramos las variables que permiten la ruta de almacenamiento
            // creacion del objeto FileWriter para manipular archivos (txt)
            File archivo = new File(ruta);
            FileWriter crear = new FileWriter(ruta);
            //Validar si el archivo txt esta existente con ayuda de objeto File
            if(!archivo.exists()){
                archivo.createNewFile();
            }
            for(String text: texto){
                //Crear un archivo txt con el objeto FileWriter
                crear.write(text + System.lineSeparator());
            }
            //Cerrar el archivo creado
            crear.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
