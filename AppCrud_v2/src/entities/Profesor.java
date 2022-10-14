
package entities;
import java.util.Scanner;

public class Profesor extends Persona {
    
    private int colegiado;

    public Profesor(int colegiado, int id, String nombre, String apellido, int edad) {
        super(id, nombre, apellido, edad);
        this.colegiado = colegiado;
    }

    public int getColegiado() {
        return colegiado;
    }

    public void setColegiado(int colegiado) {
        this.colegiado = colegiado;
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
        System.out.println("No. colegiado:");
        this.colegiado = Integer.parseInt(opcion.nextLine());
        
     }   
    
     
        public String retornarDatos () {
        return " Perfil: Profesor  => "
               +  " ID: "+ this.id
                + " Nombre: " + this.nombre 
                + "; Apellido: " + this.apellido 
                + "; Edad: " + this.edad +
                "; Colegiado: "+ this.colegiado;
              
    }
}
