    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo_hotel;


public class ListasDobles {
    nodoListaDoble primero;
nodoListaDoble ultimo;

public ListasDobles(){
primero = null;
ultimo = null;

}

    public void setPrimero(nodoListaDoble primero) {
        this.primero = primero;
    }

    public void setUltimo(nodoListaDoble ultimo, Reserva dato) {
        this.ultimo = ultimo;
    }

    public nodoListaDoble getPrimero() {
        return primero;
    }

    public nodoListaDoble getUltimo() {
        return ultimo;
    }
    
    public void ingresarp(Reserva dato){
        nodoListaDoble nodoNuevo = new nodoListaDoble();
        //nodoNuevo.dato = dato;
        nodoNuevo.setReserva(dato);

        if (getPrimero() == null){
            primero = nodoNuevo;
        //primero.siguiente = null;
            primero.setSiguiente(primero);
        //primero.anterior = null;
            primero.setAnterior(primero);
             ultimo = primero;
             }else{
            ultimo.siguiente = nodoNuevo;
            nodoNuevo.anterior = ultimo;
            nodoNuevo.siguiente = null;
            ultimo = nodoNuevo;
        }
    }
        

      public void ingresar(Reserva reserva, int prioridad) {
        nodoListaDoble nodoNuevo = new nodoListaDoble();
        nodoNuevo.setReserva(reserva);

        if (primero == null) {
            primero = nodoNuevo;
            nodoNuevo.setSiguiente(nodoNuevo);
            nodoNuevo.setAnterior(nodoNuevo);
            ultimo = nodoNuevo;
        } else {
            if (prioridad == 1) {
                nodoNuevo.setSiguiente(primero);
                primero.setAnterior(nodoNuevo);
                nodoNuevo.setAnterior(ultimo);
                ultimo.setSiguiente(nodoNuevo);
                primero = nodoNuevo;
            } else if (prioridad == 2) {
                nodoNuevo.setSiguiente(ultimo.siguiente);
                nodoNuevo.setAnterior(ultimo);
                ultimo.setSiguiente(nodoNuevo);
                nodoNuevo.siguiente.setAnterior(nodoNuevo);
                ultimo = nodoNuevo;
            } else {
                System.out.println("Prioridad inválida. La reserva será ingresada al final de la lista.");
                ultimo.setSiguiente(nodoNuevo);
                nodoNuevo.setAnterior(ultimo);
                nodoNuevo.setSiguiente(primero);
                primero.setAnterior(nodoNuevo);
                ultimo = nodoNuevo;
            }
        }
    }

    public void eliminar(Reserva dato){
        if (primero != null) {
            nodoListaDoble actual = primero;

            while (actual.getReserva() != dato && actual != ultimo) {
                actual = actual.getSiguiente();
            }

            if (actual.getReserva() == dato) {
                if (actual == primero) {
                    if (primero == ultimo) {
                        primero = null;
                        ultimo = null;
                    } else {
                        primero = primero.getSiguiente();
                        primero.setAnterior(ultimo);
                        ultimo.setSiguiente(primero);
                    }
                } else if (actual == ultimo) {
                    ultimo = ultimo.getAnterior();
                    ultimo.setSiguiente(primero);
                    primero.setAnterior(ultimo);
                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
            } else {
                System.out.println("Dato no encontrado en la lista.");
            }
        } else {
            System.out.println("La lista está vacía.");
        }
    }

public void buscarymodificar(String idReservaBuscada, Reserva nuevaReserva) {
    nodoListaDoble actual = primero;
    while (actual != null) {
        if (actual.getReserva().getIdReserva().equals(idReservaBuscada)) {
            actual.getReserva().setDescripcionReserva(nuevaReserva.getDescripcionReserva());
            actual.getReserva().setTipoReserva(nuevaReserva.getTipoReserva());
            actual.getReserva().setFechaInicio(nuevaReserva.getFechaInicio());
            actual.getReserva().setFechaFinal(nuevaReserva.getFechaFinal());
            actual.getReserva().setNumeroPersonas(nuevaReserva.getNumeroPersonas());

            return; 
        }
        actual = actual.getSiguiente();
    }
}
  
 

        public void imprimirLista(ListasDobles reservaciones) {
          nodoListaDoble actual = getPrimero();
        int contador = 1;
        while (actual != null) {
            Reserva reserva = actual.getReserva(); 
            System.out.println("Lista Reservaciones");
            System.out.println("Reserva " + contador + ":");
            System.out.println("ID: " + reserva.getIdReserva());
            System.out.println("Descripción: " + reserva.getDescripcionReserva());
            System.out.println("Tipo: " + reserva.getTipoReserva());
            System.out.println("Fecha Inicio: " + reserva.getFechaInicio());
            System.out.println("Fecha Final: " + reserva.getFechaFinal());
            System.out.println("Fecha Creación: " + reserva.getFechaCreacion());
            System.out.println("Número de Personas: " + reserva.getNumeroPersonas());
            System.out.println("Estado: " + (reserva.isEstado() ? "Activo" : "Inactivo"));
            System.out.println("----------------------------------");
            
            actual = actual.getSiguiente();
            contador++;
        }
    }

        public void imprimirInverso(ListasDobles lista) {
        nodoListaDoble actual = lista.getUltimo();
        nodoListaDoble anterior = null;
        while (actual != null) {
            System.out.print(actual.getReserva()+ "");
            anterior = actual;
            actual = actual.getAnterior();
        
}
        }
        public nodoListaDoble buscarReserva(String idReservaBuscada) {
    nodoListaDoble actual = primero;
    while (actual != null) {
        if (actual.getReserva().getIdReserva().equals(idReservaBuscada)) {
            return actual;
        }
        actual = actual.getSiguiente();
    }
    return null;
}
        public void insertarAlPrincipio(Reserva reserva) {
        nodoListaDoble nuevoNodo = new nodoListaDoble();
        nuevoNodo.setReserva(reserva);

        if (getPrimero() == null) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(primero);
            primero.setAnterior(nuevoNodo);
            primero = nuevoNodo;
        }
    }

    public void insertarAlFinal(Reserva reserva) {
        nodoListaDoble nuevoNodo = new nodoListaDoble();
        nuevoNodo.setReserva(reserva);

        if (getUltimo() == null) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            ultimo = nuevoNodo;
        }
    }
        public void agregarReserva(Reserva reserva) {
        nodoListaDoble nuevoNodo = new nodoListaDoble();
        if (primero == null) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            ultimo = nuevoNodo;
        }
    }

        }


