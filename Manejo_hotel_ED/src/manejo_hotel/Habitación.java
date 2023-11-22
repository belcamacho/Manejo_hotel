/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo_hotel;

import java.util.ArrayList;
import java.util.Scanner;
import static manejo_hotel.Manejo_hotel.registrohabitaciones;

/**
 *
 * @author belca
 */
public class Habitación {
    
    Scanner scanner = new Scanner(System.in);
    public Habitación(int idhabitacion1, String descripcion1, String estado1, String tipoHabitacion1, String caracteristicas1, String precio1){
        this.idHabitacion = idHabitacion;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipoHabitacion = tipoHabitacion;
        this.características = características;
        this.precio = precio;
}
    public Habitación (){
        
    }
    

    private int idHabitacion;
    private String descripcion;
    private  String estado;
    private String tipoHabitacion;
    private String características;
    private String precio;
    

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String isEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public String getCaracterísticas() {
        return características;
    }

    public void setCaracterísticas(String características) {
        this.características = características;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

 
    
    
     public void menuHabitacion(){
        Scanner scanner = new Scanner(System.in);

        boolean salir = false;
         while (!salir) {
             try{ 
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ingresar habitación");
            System.out.println("2. Modificar información de habitacion");
            System.out.println("3. Eliminar habitacion");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");

            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    ingresarHabitacion(registrohabitaciones);
                    break;
                case 2:
                    modificarHabitacion(registrohabitaciones);
                    break;
                case 3:
                    eliminarHabitacion(registrohabitaciones);
                    break;
                case 4:
                    salir = true;
                default:
                   
    
    
    
}
           } catch(Exception e){
               System.out.println("Ingrese datos correctos");
           }
             }

}
     

         public void ingresarHabitacion(ArrayList<Habitación> registrohabitaciones) {

        System.out.println("Ingresar datos de la habitación:");
        System.out.print("Digite id de habitación: ");
        int idHabitacion = scanner.nextInt();
        System.out.print("Digite descripción de la habitación: ");
        String descripcion = scanner.next();
        System.out.print("Digite estado de habitacion: ");
        String estado = scanner.next();
        System.out.print("Digite tipo de habitación: ");
        String tipoHabitacion = scanner.next();
        System.out.print("Digite características de habitacion: ");
        String características = scanner.next();
        System.out.println("Digite el precio de la habitación: ");
        String precio = scanner.next();
        Habitación habitacion = new Habitación(idHabitacion, descripcion, estado, tipoHabitacion, características, precio);

       
        habitacion.setIdHabitacion(idHabitacion);
        habitacion.setDescripcion(descripcion);
        habitacion.setEstado(estado);
        habitacion.setTipoHabitacion(tipoHabitacion);
        habitacion.setCaracterísticas(características);
        habitacion.setPrecio(precio);
        
        registrohabitaciones.add(habitacion);

        System.out.println("Habitación ingresada");
        habitacion.mostrar_habitacion(registrohabitaciones);
    }

    public void modificarHabitacion(ArrayList<Habitación> registrohabitaciones) {

        System.out.print("Ingrese el id de la habitación que desea modificar: ");
        int idBuscar = scanner.nextInt();

        for (Habitación habitacion : registrohabitaciones) {
            if (habitacion.getIdHabitacion() == idBuscar){
                System.out.println("Ingrese los nuevos datos de la habitación:");
                System.out.print("Digite nueva descripción: ");
                String nuevaDescripcion = scanner.next();
                System.out.print("Digite nuevo estado: ");
                String nuevoEstado = scanner.next();
                System.out.print("Digite nuevo tipo de habitación: ");
                String nuevoTipoHabitacion = scanner.next();
                System.out.print("Digite nuevas características: ");
                String nuevasCaracterísticas = scanner.next();
                System.out.println("Digite el nuevo precio: ");
                String precio = scanner.next();

                habitacion.setDescripcion(nuevaDescripcion);
                habitacion.setEstado(nuevoEstado);
                habitacion.setTipoHabitacion(nuevoTipoHabitacion);
                habitacion.setCaracterísticas(nuevasCaracterísticas);
                habitacion.setPrecio(precio);

                System.out.println("Habitación modificada");
                registrohabitaciones.add(habitacion);
                return;
            }
        }

        System.out.println("Habitación no encontrada");
    }

    public void eliminarHabitacion(ArrayList<Habitación> registrohabitaciones) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el id de la habitación que desea eliminar: ");
        String idBuscar = scanner.nextLine();

        Habitación habitacionAEliminar = null;

        for (Habitación habitacion : registrohabitaciones) {
              if (String.valueOf(habitacion.getIdHabitacion()).equals(idBuscar)) {
                habitacionAEliminar = habitacion;
                break;
            }
        }

        if (habitacionAEliminar != null) {
            registrohabitaciones.remove(habitacionAEliminar);
            System.out.println("Habitación eliminada");
        } else {
            System.out.println("Habitación no encontrada");
        }
    }
    
public String mostrar_habitacion(ArrayList<Habitación> registrohabitaciones) {
    int cont = 0;
    StringBuilder output = new StringBuilder(); 
    
    for (Habitación habitacion : registrohabitaciones) {
        output.append("Habitaciones: ").append(cont)
              .append(" Id habitación: ").append(habitacion.getIdHabitacion())
              .append(" Descripcion: ").append(habitacion.getDescripcion())
              .append(" Tipo habitación: ").append(habitacion.getTipoHabitacion())
              .append(" Caracteristicas: ").append(habitacion.getCaracterísticas())
              .append(" Precio: ").append(habitacion.getPrecio())
              .append("\n"); // Agregar un salto de línea al final de cada habitación
        cont++;
    }
    
    return output.toString(); // Devolver la cadena completa
}

          }
