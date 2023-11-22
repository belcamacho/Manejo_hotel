/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo_hotel;

/**
 *
 * @author tomas
 */
public class Pilas {
    String vectorPila[];
    int cima; 
    
    public Pilas(int tama){
        vectorPila = new String [tama];
        cima = 0;
    }
    
    void push(int piso, String nombre) {
        if (piso >= 0 && piso < vectorPila.length) {
            vectorPila[cima] = nombre;
            cima = piso;
        } else {
            System.out.println("Piso no válido");
        }
    }
    

    
    public String pop(){
String eliminar = "";
if (cima == 0){
System.out.println("pila vacia");
}else{
eliminar = vectorPila[cima-1];
cima--;
}
return eliminar;
}
    
    public int tamano(){
return vectorPila.length;
}
    public boolean pilaVacia(){
if (cima == 0){
return true;
}else
{
return false;
}
}
   public boolean pilaLlena(int tamano){
if (cima == tamano ){
return true;
}else
{
return false;
}
}

public void Mostrarpila () {
      System.out.println(pop());
    while (!pilaVacia()){
        String temp = pop();
        System.out.println(temp);
    
        
    }
}

public String Mostrarfondo (){
    String temp = "";
    while (!pilaVacia()){
         temp = pop();
    }
    return temp;
    
   
        
    }
       
    
    
    public String buscar(String nombrePersona) {
    String resultado = "No se encuentra";

    for (int i = cima - 1; i >= 0; i--) {
        if (vectorPila[i] != null && vectorPila[i].equals(nombrePersona)) {
            resultado = Integer.toString(cima - i);
            break;
        }
    }
    
    return resultado;
}

    
    
    public void limpiarPila() {
    cima = 0;
}
}



            
        
    

