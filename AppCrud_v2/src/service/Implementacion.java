package service;
import interfaces.*;
import data.*;
//import entities.*;

public class Implementacion implements interfaz {

    Data data;

    public Implementacion(Data data) {
        this.data = data;
    }

    
    
   
 public int generaId (){
     
    return data.generaId();

    
 }    
       
 public void  agregar(int opcionUser){

    data.agregar(opcionUser);

 }
 

 public int buscar(){
     return data.buscar();
 }
 
  
 public void actualizar(String id){
    data.actualizar(id);
 }
 

 public void borrar (String id){
    data.borrar(id);
 }
 

 public void imprimir (){
  data.imprimir();
     
 }
   

 public int maxIndice(){
   return data.maxIndice();
    
 }


  public boolean  analizaCadena (String str ) {
     return data.analizaCadena(str);
}

  
  
}