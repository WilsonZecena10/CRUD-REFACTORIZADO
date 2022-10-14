
package entities;
import java.util.Scanner;

public class Admin extends Persona {
    
    private String depto;

    public Admin(String depto, int id, String nombre, String apellido, int edad) {
        super(id, nombre, apellido, edad);
        this.depto = depto;
    }   

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }
    

    public String getDepto() {
        return depto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    
    
    public void setDepto(String depto) {
        this.depto = depto;
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
        System.out.println("Depto admin:");
        this.depto  = opcion.nextLine();
        
        
    }
    
    public String retornarDatos () {
        return " Perfil: Administrativo  => "
                + " ID: "+ this.id
                + " Nombre: " + this.nombre 
                + "; Apellido: " + this.apellido 
                + "; Edad: " + this.edad +
                "; Depto: "+ this.depto;
                
    }
    
}
