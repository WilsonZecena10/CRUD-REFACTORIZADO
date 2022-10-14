
package entities;
import java.util.Scanner;

public class Alumno extends Persona {
    
    private int carnet;

    public Alumno(int carnet, int id, String nombre, String apellido, int edad) {
        super(id, nombre, apellido, edad);
        this.carnet = carnet;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }
    
    
    public void colectaDatos(int id){
     this.id = id;
     Scanner opcion = new Scanner (System.in);
     System.out.println("Nombre:");  
     this.nombre  = opcion.nextLine();
     System.out.println("Apellido:");
     this.apellido  = opcion.nextLine();
     System.out.println("Edad:");
     this.edad  =  Integer.parseInt(opcion.nextLine());
     System.out.println("No. carnet:");
     this.carnet = Integer.parseInt(opcion.nextLine());

  }   
    
    
       public String retornarDatos () {
        return " Perfil: Alumno  => "
                + " ID: "+ this.id
                + " Nombre: " + this.nombre 
                + "; Apellido: " + this.apellido 
                + "; Edad: " + this.edad +
                "; Carnet: "+ this.carnet;
            
    }
    
}
