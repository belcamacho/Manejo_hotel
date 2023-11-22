/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo_hotel;


public class nodoListaDoble {
    Reserva reserva;
nodoListaDoble siguiente;
nodoListaDoble anterior;
nodoListaDoble ultimo;
   public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public nodoListaDoble getSiguiente() {
        return siguiente;
    }

    public nodoListaDoble getAnterior() {
        return anterior;
    }


    public void setSiguiente(nodoListaDoble siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(nodoListaDoble anterior) {
        this.anterior = anterior;
    }

    public void setUltimo(nodoListaDoble ultimo) {
    this.ultimo = ultimo;
}
    
    
    
    

 
    






}

    

