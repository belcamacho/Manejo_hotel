/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo_hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import static manejo_hotel.Manejo_hotel.registrohuespedes;

/**
 *
 * @author belca
 */
public class Reserva {
    nodoArbolBinario nodo = new nodoArbolBinario();
    arbolBinario arbolCancelaciones = new arbolBinario();
    nodoListaDoble NodoListaDoble = new nodoListaDoble();
    ListasDobles reservaciones = new ListasDobles();
    Scanner scanner = new Scanner(System.in);
     SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
     

    public Reserva(String idReserva1, String descripcionReserva1, String tipoReserva1, Date fechaInicio1, Date fechaFinal1, Date fechaCreacion1, int numeroPersonas1, boolean estado1) {
    }
    private  ListasDobles listaCancelaciones = new ListasDobles();
    private String idReserva;
    private String descripcionReserva;
    private String tipoReserva;
    private Date fechaInicio;
    private Date fechaFinal;
    private Date fechaCreacion;
    private int numeroPersonas;
    private boolean estado;
    
    public Reserva(){
        
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public String getDescripcionReserva() {
        return descripcionReserva;
    }

    public void setDescripcionReserva(String descripcionReserva) {
        this.descripcionReserva = descripcionReserva;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(String tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
     

    
    
    
    public void menureserva(){
        Scanner scanner = new Scanner(System.in);

        boolean salir = false;
         while (!salir) {
             try{ 
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ingresar reserva");
            System.out.println("2. Modificar reserva");
            System.out.println("3. Anular reserva");
            System.out.println("4. Ver cancelaciones");
            System.out.println("5. Habilitar una cancelación");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");

            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    ingresarReserva(reservaciones, registrohuespedes);
                    break;
                case 2:
                    ModificarReserva(reservaciones);
                    break;
                case 3:
                    CancelarReserva(arbolCancelaciones, reservaciones);
                    break;
                case 4:
                    mostrarArbolCancelaciones(nodo);
                    break;
                    
                    
                    

                case 6:
                    salir = true;
                default:
                    
                
                
            }
    
    
    
}catch(Exception e){
    System.out.println("Ingrese datos correctos");
        }

}
         
         }
    
    public void ingresarReserva(ListasDobles reservaciones, ArrayList<Huesped> registrohuespedes){
        System.out.print("Ingrese el nombre del huesped:");
        String nombre = scanner.next(); 
        boolean nombreEncontrado = false;
    
    for (Huesped huesped : registrohuespedes) {
        if (huesped.getNombre().equalsIgnoreCase(nombre)) {
            nombreEncontrado = true;
            break;
        }
    }

    if (nombreEncontrado) {
        while (true) {
            System.out.println("1. Ingresar reserva con prioridad 1");
            System.out.println("2. Ingresar reserva con prioridad 2");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            if (opcion == 4) {
                break;
            }
            System.out.print("Ingrese el ID de la reserva: ");
            String idReserva = scanner.nextLine();
            System.out.print("Ingrese la descripción de la reserva: ");
            String descripcionReserva = scanner.nextLine();
            System.out.print("Ingrese el tipo de reserva: ");
            String tipoReserva = scanner.nextLine();
            System.out.print("Ingrese la fecha de inicio (dd/MM/yyyy): ");
            String fechaInicioStr = scanner.nextLine();

            Date fechaInicio = null;
            try {
                fechaInicio = dateFormat.parse(fechaInicioStr);
            } catch (ParseException e) {
                System.out.println("Error en la fecha de inicio.");
            }

            System.out.print("Ingrese la fecha final (dd/MM/yyyy): ");
            String fechaFinalStr = scanner.nextLine();
            Date fechaFinal = null;
            try {
                fechaFinal = dateFormat.parse(fechaFinalStr);
            } catch (ParseException e) {
                System.out.println("Error en la fecha final.");
            }

            System.out.print("Ingrese la fecha de creación (dd/MM/yyyy): ");
            String fechaCreacionStr = scanner.nextLine();
            Date fechaCreacion = null;
            try {
                fechaCreacion = dateFormat.parse(fechaCreacionStr);
            } catch (ParseException e) {
                System.out.println("Error en la fecha de creación.");
            }

            System.out.print("Ingrese el número de personas: ");
            int numeroPersonas = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Ingrese el estado (true o false): ");
            boolean estado = scanner.nextBoolean();
            scanner.nextLine(); 

            Reserva nuevaReserva = new Reserva(idReserva, descripcionReserva, tipoReserva, fechaInicio, fechaFinal, fechaCreacion, numeroPersonas, estado);
            nuevaReserva.setIdReserva(idReserva);
            nuevaReserva.setDescripcionReserva(descripcionReserva);
            nuevaReserva.setTipoReserva(tipoReserva);
            nuevaReserva.setFechaInicio(fechaInicio);
            nuevaReserva.setFechaFinal(fechaFinal);
            nuevaReserva.setFechaCreacion(fechaCreacion);
            nuevaReserva.setNumeroPersonas(numeroPersonas);
            nuevaReserva.setEstado(estado);
            if (opcion == 1) {
                reservaciones.insertarAlPrincipio(nuevaReserva);
            } else if (opcion == 2) {
                reservaciones.insertarAlFinal(nuevaReserva);
        }
 
        }
               reservaciones.imprimirLista(reservaciones);
        }
    }
   
    public void ModificarReserva(ListasDobles reservaciones) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID de la reserva que desea modificar: ");
        String idReservaBuscada = scanner.nextLine();
        
          nodoListaDoble actual = reservaciones.getPrimero();
          boolean encontrada = false; 
          while (actual != null) {
              if (actual.getReserva().getIdReserva().equals(idReservaBuscada)) {
                  encontrada = true;
                System.out.println("Reserva encontrada. Ingrese los nuevos datos:");

                System.out.print("Ingrese la nueva descripción de la reserva: ");
                String nuevaDescripcion = scanner.nextLine();
                System.out.print("Ingrese el nuevo tipo de reserva: ");
                String nuevoTipo = scanner.nextLine();

   
                System.out.print("Ingrese la nueva fecha de inicio (dd/MM/yyyy): ");
                String nuevaFechaInicioStr = scanner.nextLine();
                Date nuevaFechaInicio = null;
                try {
                nuevaFechaInicio = dateFormat.parse(nuevaFechaInicioStr);
                 } catch (ParseException e) {
                System.out.println("Error en la nueva fecha de inicio.");
                }

                System.out.print("Ingrese la nueva fecha final (dd/MM/yyyy): ");
                String nuevaFechaFinalStr = scanner.nextLine();
                Date nuevaFechaFinal = null;
                try {
                    nuevaFechaFinal = dateFormat.parse(nuevaFechaFinalStr);
                 } catch (ParseException e) {
                 System.out.println("Error en la nueva fecha final.");
                    }

                 System.out.print("Ingrese el nuevo número de personas: ");
                 int nuevoNumeroPersonas = scanner.nextInt();
                 scanner.nextLine(); 

                    Reserva Reservamodificada = new Reserva();
                    Reservamodificada.setIdReserva(idReserva);
                     Reservamodificada.setDescripcionReserva(nuevaDescripcion);
                     Reservamodificada.setTipoReserva(nuevoTipo);
                     Reservamodificada.setFechaInicio(nuevaFechaInicio);
                     Reservamodificada.setFechaFinal(nuevaFechaFinal);
                     Reservamodificada.setFechaCreacion(fechaCreacion);
                     Reservamodificada.setNumeroPersonas(nuevoNumeroPersonas);
                     Reservamodificada.setEstado(estado);
                      actual.setReserva(Reservamodificada);

                     System.out.println("Reserva modificada exitosamente.");
            break; 
        }
        actual = actual.getSiguiente();
    }

    if (!encontrada) {
        System.out.println("Reserva no encontrada.");
    }

    reservaciones.imprimirLista(reservaciones);
}
public void CancelarReserva(arbolBinario arbolCancelaciones, ListasDobles reservaciones) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese el ID de la reserva que desea modificar: ");
    String idReservaBuscada = scanner.nextLine();
    
    nodoListaDoble actual = reservaciones.getPrimero();
    nodoListaDoble anterior = null;
    boolean encontrada = false;
    
    while (actual != null) {
        if (actual.getReserva().getIdReserva().equals(idReservaBuscada)) {
            encontrada = true;
            System.out.println("Reserva encontrada");
            System.out.println("¿Está seguro(a) que desea cancelar esta reserva?(Sí/No)");
            String cancelarReserva = scanner.next();
            boolean cancelada = cancelarReserva.equalsIgnoreCase("Sí");
            actual.getReserva().setEstado(cancelada);

            if (cancelada) {
                arbolCancelaciones.insertarCancelacion(actual.getReserva());
            }

            if (anterior == null) {
                reservaciones.setPrimero(actual.getSiguiente());
            } else {
                anterior.setSiguiente(actual.getSiguiente());
            }

            break;
        }
        anterior = actual;
        actual = actual.getSiguiente();
    }
    
    if (!encontrada) {
        System.out.println("Reserva no encontrada.");
    }
    mostrarArbolCancelaciones(arbolCancelaciones.raiz);
     reservaciones.imprimirLista(reservaciones);
}
public void mostrarArbolCancelaciones(nodoArbolBinario nodo) {
    if (nodo != null) {
        mostrarArbolCancelaciones(nodo.izq); // Recorrer el subárbol izquierdo
        
        Reserva reserva = nodo.reserva;
        System.out.println("");
        System.out.println("Lista de Cancelaciones:");
        System.out.println("ID de Reserva: " + reserva.getIdReserva());
        System.out.println("Descripción de Reserva: " + reserva.getDescripcionReserva());
        System.out.println("Tipo de Reserva: " + reserva.getTipoReserva());
        System.out.println("Fecha de Inicio: " + reserva.getFechaInicio());
        System.out.println("Fecha Final: " + reserva.getFechaFinal());
        System.out.println("Fecha de Creación: " + reserva.getFechaCreacion());
        System.out.println("Número de Personas: " + reserva.getNumeroPersonas());
        
        System.out.println("------------------------------------------");
        mostrarArbolCancelaciones(nodo.der); 
       
     }}

public void habilitarCancelacion() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese el ID de la reserva que desea habilitar la cancelación: ");
    String idReservaBuscada = scanner.nextLine();

    nodoArbolBinario nodoCancelacion = arbolCancelaciones.buscar(idReservaBuscada);
    
    if (nodoCancelacion != null) {
        if (nodoCancelacion.reserva.isEstado()) {
            System.out.println("La reserva ya está habilitada.");
        } else {
            nodoCancelacion.reserva.setEstado(true);
            reservaciones.insertarAlFinal(nodoCancelacion.reserva);

            System.out.println("Cancelación habilitada y reserva restaurada exitosamente.");
        }
    } else {
        System.out.println("Reserva no encontrada en las cancelaciones.");
    }

    reservaciones.imprimirLista(reservaciones);
}
}


    





    
          
    








    
    

    

  
    
    







