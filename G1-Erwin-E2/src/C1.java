import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class C1 {
    public static void main(String[] args) {
        int option = 0;

        Scanner s = new Scanner(System.in);

        List<List<String>> categorias = new ArrayList<>();
        List<String> nomCategoria = new ArrayList<>();
        List<List<List<String>>> productos = new ArrayList<>();
        List<List<String>> almacen = new ArrayList<>();
        List<String> nomproducto = new ArrayList<>();
        //List<String> temp = new ArrayList<>();
       // vinos.add("Vinos");
       nomCategoria.add("vinos");
        categorias.add(nomCategoria);
        nomproducto.add("Tequila");
        nomproducto.add("Vino Blanco");
        almacen.add(nomproducto);
        productos.add(almacen);




        while( option != 5){
            System.out.println("***** Menu  *********");
            System.out.println("1) Mostrar Categorias");
            System.out.println("2) Mostrar productos por categorias");
            System.out.println("3) Agregar categoria");
            System.out.println("4) Agregar producto a una categoria");
            System.out.println("5) Salir");
            option = s.nextInt();

            switch (option){
                case 1:
                    for (int i = 0; i<categorias.size();i++){
                        for (int j=0;j<nomCategoria.size();j++){
                            System.out.println("Categoria: "+ categorias.get(i).get(j)+" \n");
                        }

                    }

                    break;
                case 2:
                    System.out.println("Ingresa el numero de la categroia a visualizar");
                    for (int i = 0; i<categorias.size();i++){
                        System.out.println((i+1)+" ->  "+ categorias.get(i)+" \n");
                    }
                    int catNum = s.nextInt();
                    catNum = catNum-1;
                    if (nomproducto.isEmpty()){

                        System.out.println("No cuentas con nada registrado");
                        }else{
                        System.out.println("vacios: ->"+almacen.get(0).isEmpty());
                        System.out.println("Categoria: "+ categorias.get(catNum) + " \n Productos:" );

                        for (int j = 0; j < nomproducto.size(); j++) {
                            System.out.print(productos.get(catNum).get(0).get(j) + ", ");
                        }
                        System.out.println("\n");
                    }


                    break;
                case 3:
                    System.out.println("Ingresa el nombre de la categroia nueva");
                    String cadena = "";
                    cadena = s.nextLine();
                    cadena = s.nextLine();
                    List <String> temp = new ArrayList<>();
                    temp.add(cadena);
                    categorias.add(temp);

                    break;
                case 4:
                    System.out.println("A que categoria quieres agregar un producto (ingresa el numero): ");
                    for (int i = 0; i<categorias.size();i++){
                        System.out.println((i+1)+" ->  "+ categorias.get(i)+" \n");
                    }
                     catNum = s.nextInt();
                    catNum = catNum-1;

                    //Agregar productos a la categroia
                        //System.out.println("Categoria: "+ categorias.get(catNum) + "Productos:" );
                   temp = new ArrayList<>();
                            System.out.println("Agrega el producto: ");
                            cadena = s.nextLine();
                            cadena = s.nextLine();
                            temp.add(cadena);
                            //System.out.print(productos.get(i).get(j) + ", ");

                        almacen.add(temp);
                        System.out.println("\n");

                    break;
                default:
                    System.out.println("Hola");

            }


        }
    }
}