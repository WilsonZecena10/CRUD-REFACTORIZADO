package interfaces;
//import entities.*;

public interface interfaz {
   
  
    void agregar(int opcionUser);
    int buscar();
    void actualizar(String id);
    boolean  analizaCadena(String str);
    void borrar(String id);
    void imprimir();
    int generaId();
    int maxIndice();
}
