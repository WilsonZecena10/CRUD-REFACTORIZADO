package data;
import entities.*;
import java.util.Scanner;


public class Data {
    
   private  Persona arrayPersonas[] = new Persona[100];
    
  
   
    public Data(Persona personas[]) {
        this.arrayPersonas =personas;
    }

    public Persona[] getArrayPersonas() {
        return arrayPersonas;
    }

    public void setArrayPersonas(Persona[] arrayPersonas) {
        this.arrayPersonas = arrayPersonas;
    }
    
    
   
 public int generaId (){
     int id=0;
     int flag=0;
     for (Persona persona  : arrayPersonas){
            if(persona != null){
                id= persona.getId();  //saco el el ID del ultimo registro y le incremento 10     
                id=id+10;    
                flag=1;
              }else{
               if (flag==0){ //si es el primer registro le asigno 100               
                id=100;         
            }               
        }            
     }      
    return id;     
 }    
       

 public void  agregar(int opcionUser){
      int id=  generaId()  ;
     switch(opcionUser) {
        case 1:  //agregar personal Administrativo      
           Admin admin = new Admin(" ",0," ", " ",0);
           admin.colectaDatos(id);    
           arrayPersonas[maxIndice()]=admin;
            break;    
        case 2:  //agregar profesores
           Profesor profe = new Profesor(0,0," ", " ",0);
           profe.colectaDatos(id);
           arrayPersonas[maxIndice()]=profe;
            break;    
        case 3: //agregar alumnos                           
           Alumno alumno = new Alumno(0,0," ", " ",0);
           alumno.colectaDatos(id);
           arrayPersonas[maxIndice()]=alumno;
            break;
        case 4:  
            break;
        default:
            System.out.println(" ");  
            System.out.println("OPCION INVALIDA!");
            System.out.println(" ");         
      }                               
 }

 public int buscar(){
        int cont=0;
        int reg=0;
        Scanner op = new Scanner (System.in);    
        System.out.println("Ingrese un nombre: ");
        String nombre  = op.next();
        System.out.println("Ingrese un apellido: ");
        String apellido  = op.next(); 
     
       System.out.println("============PERSONAS ENCONTRADAS POR COINCIDENCIA =========="); 
        System.out.println( " ");        
        for ( int i =0 ; i < arrayPersonas.length; i++){
            if(arrayPersonas[i] != null) {            
                String nombre_convert   = arrayPersonas[i].getNombre().toLowerCase() ;
                String apellido_convert = arrayPersonas[i].getApellido().toLowerCase(); 
                String name_convert     = nombre.toLowerCase();
                String lastName_convert = apellido.toLowerCase();
                if (nombre_convert.contains(name_convert)) {
                    if(apellido_convert.contains(lastName_convert)){
                        System.out.println( "Registros encontrados: " + arrayPersonas[i].getNombre() + " "+arrayPersonas[i].getApellido() +" Indice: "+ i);
                        cont=1;
                        reg=reg+1;
                    }else{
                        if (cont==0){    
                        System.out.println( "Registros encontrados: 0 ");
                        reg=0;
                        cont=1;
                    }
                    }
                }                  
            }else{
                    if (cont==0){    
                        System.out.println( "Registros encontrados: 0 ");
                        cont=1;
                        reg=0;
                    }
            }   
        }
        System.out.println( " ");      
        System.out.println("=========================================================");   
        return reg;
 }
 
 
 public void actualizar(String id){
      Scanner opcion = new Scanner (System.in);
      boolean analiza= analizaCadena(id);
        System.out.println( );
        if ( analiza==false ){
            System.out.println("OPCION NO ES NUMERICO !!!.");
        } else {         
                if(arrayPersonas[ Integer.parseInt(id) ] != null) {
                    Persona persona  = arrayPersonas[Integer.parseInt(id)];                           
                    System.out.println( persona.retornarDatos());
                    System.out.println("============================");
                    System.out.println("Seleccione el perfil:"); 
                    System.out.println("1) Admin 2)Catedratico 3) Alumno");  
                    String opcionUser = opcion.next();  
                    analiza= analizaCadena(opcionUser);
                    System.out.println( );
                    if ( analiza==false ){
                        System.out.println("OPCION NO ES NUMERICO !!!");
                    } else {
                                if(opcionUser.contentEquals("1")|| 
                                   opcionUser.contentEquals("2")||
                                   opcionUser.contentEquals("3") ){
                                        agregar(Integer.parseInt(opcionUser) ) ;
                                        borrar(id);
                                } else {
                                     System.out.println("OPCION NO VALIDA!!");
                                }               
                            }

                }else {
                    System.out.println("NO EXISTE REGISTRO PARA ESE INDICE");
                } 
          }

 }
 
  
 public void borrar (String id){
     Scanner opcion = new Scanner (System.in);
      boolean analiza= analizaCadena(id);
        System.out.println( );
        if ( analiza==false ){
            System.out.println("INDICE INGRESADO NO ES NUMERICO !!!");
        } else {
         int cont=0;
            Persona arrayPivot[] = new Persona[100]; 
            for ( int i =0 ; i < arrayPersonas.length; i++){
                if(arrayPersonas[i] != null) {  
                         if(i != Integer.parseInt(id)) {
                             for ( int m =0 ; m < arrayPivot.length; m++){
                                 if(arrayPivot[m] == null) {                                      
                                    arrayPivot[m]=arrayPersonas[i];
                                    m=arrayPivot.length+1;
                                  } 
                              }
                            }
                            cont=1;
                  } else {
                    if (cont==0){
                        System.out.println("ARREGLO SIN ELEMENTOS !!"); 
                        cont=1;
                    }
                }
             }
            for ( int p =0 ; p < arrayPivot.length; p++){
                arrayPersonas[p]=arrayPivot[p];                                        
            }
        }
 }
 
 
 public void imprimir (){
     int flag=0;
       System.out.println();
       System.out.println();
       System.out.println("================================================================================================================================"); 
      for (Persona persona  : arrayPersonas){
                if(persona != null){
                    System.out.println( persona.retornarDatos());
                    flag=1;
                }else {
                    if (flag==0){
                        System.out.println("NO HAY ELEMENTOS EN EL ARREGLO"); 
                        flag=1;
                    }
                }
            }
        System.out.println("================================================================================================================================"); 
 }
   
  
 public int maxIndice(){
    int indexFree=0;
    for ( int i =0 ; i < arrayPersonas.length; i++){
        if  (arrayPersonas[i] ==null){
            indexFree=i;      
            break;
        }     
     }  return indexFree;
    
 }

    
  public boolean  analizaCadena (String str ) {
        boolean isNumeric = true;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                isNumeric = false;
            }
        }
        return (isNumeric);
    }




}

    
    
    
