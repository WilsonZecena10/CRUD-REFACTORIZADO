package appcrud;
import service.*;
import data.*;
import entities.*;
import java.util.Scanner;

class Main {
    
  public static void main(String[] args) {
   Menus menu = new Menus();
   Scanner op = new Scanner (System.in);  
   Data data = new Data(new Persona[100]);
   Implementacion miImpl = new Implementacion(data);


   
    String opcionUser;
   
      do{
            menu.menu();
            opcionUser = op.next();
            switch(opcionUser) {
                case "1":   
                    //agregar persona
                    menu.subMenu();
                    opcionUser = op.next();
                     boolean analiza= miImpl.analizaCadena(opcionUser);
                     System.out.println( );
                     if ( analiza==false ){
                        System.out.println("OPCION NO ES NUMERICO!!");
                     } else{
                             miImpl.agregar(Integer.parseInt(opcionUser)); 
                     }                                
                    break;
                case "2":
                    //buscar persona
                    //buscaPersona ();
                    int reg=miImpl.buscar();
                    break;
                case "3":
                    // actualizar persona
                    //buscaPersona ();
                    reg=miImpl.buscar();
                    if (reg>0){
                        System.out.println("Escriba el ID del registro a actualizar: ");
                        String id  = op.next();
                        miImpl.actualizar(id);
                    }
                    break;
                case "4":
                    //borrar persona
                    //buscaPersona ();
                    reg=miImpl.buscar();
                    if (reg>0){
                        System.out.println("Escriba el ID del registro a eliminar: ");
                        String id  = op.next();
                        miImpl.borrar(id);
                    }
                    break;
                case "5":
                    //imprimir arreglo persona
                    miImpl.imprimir();
                    break;
                case "6":
                    break;
                default:
                    System.out.println();
                    System.out.println();
                    System.out.println("OPCION NO VALIDA !");
                    break;
            }
      }while (  !"6".equals(opcionUser) );           
     }
}
