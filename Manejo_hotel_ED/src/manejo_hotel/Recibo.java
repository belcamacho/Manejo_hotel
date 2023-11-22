/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo_hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import static manejo_hotel.Manejo_hotel.registrohabitaciones;

/**
 *
 * @author belca
 */
public class Recibo extends Reserva {
    Huesped Huesped = new Huesped ();
    Habitación habitacion = new Habitación();
    

    public Recibo(String idReserva1, String cedula, LocalDate fecha1, double monto1, double impuesto1, double descuento1) {
    }
    public Recibo(){
        
    }
    private String idReserva;
    private String cedulaHuesped;
    private String observaciones;
    private Date fecha;
    private int monto;
    private int impuesto;
    private int descuento;


    public String getCedulaHuesped() {
        return cedulaHuesped;
    }

    public void setCedulaHuesped(String cedulaHuesped) {
        this.cedulaHuesped = cedulaHuesped;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
    public double calcularMontoTotal() {
        double total = monto + (monto * (impuesto / 100)) - descuento;
        return total;
    }

    // Método para validar los montos, impuestos y descuentos
    public boolean validarDatos() {
        if (monto < 0 || impuesto < 0 || descuento < 0) {
            return false;
        }
        return true;
    }
    

public void generarRecibo(Reserva reserva, ArrayList<Huesped> registrohuespedes, ListasDobles reservaciones, ArrayList<Habitación> registrohabitaciones) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese la cédula del huésped: ");
    String cedulaBuscar = scanner.nextLine().trim();
    for (Huesped huesped : registrohuespedes) {
        if (huesped.getCedula().equals(cedulaBuscar)) {
            System.out.print("Ingrese el ID de la reserva que desea facturar: ");
            String idReservaBuscada = scanner.nextLine().trim();
            nodoListaDoble actual = reservaciones.getPrimero();
            while (actual != null) {
                if (actual.getReserva().getIdReserva().equals(idReservaBuscada)) {
                    System.out.print("Ingrese el id de habitación: ");
                    int habitacionBuscada = scanner.nextInt();
                    scanner.nextLine(); 

                    for (Habitación habitacion : registrohabitaciones) {
                        if (habitacion.getIdHabitacion() == habitacionBuscada) {
                            LocalDate fecha = LocalDate.now();
                            double monto = calcularMonto(actual.getReserva(), registrohabitaciones);
                            double impuesto = calcularImpuesto(monto);
                            double descuento = calcularDescuento(actual.getReserva());
                            double montoTotal = calcularMontoTotal(monto, impuesto, descuento);

                            Recibo recibo = new Recibo(idReservaBuscada, cedulaBuscar, fecha, monto, impuesto, descuento);
                            System.out.println("Recibo generado:");
                            System.out.println("Fecha: " + fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            System.out.println("ID de Reserva: " + idReservaBuscada);
                            System.out.println("Cédula del huésped: " + cedulaBuscar);
                            System.out.println("Monto: " + monto);
                            System.out.println("Impuesto: " + impuesto);
                            System.out.println("Descuento: " + descuento);
                            System.out.println("Monto Total: " + montoTotal);
                        }
                    }
                }
                actual = actual.getSiguiente();
            }
        }
    }
}
        
        
   private double calcularMonto(Reserva reserva,  ArrayList<Habitación> registrohabitaciones) {
         int personas = reserva.getNumeroPersonas();

        int precioHabitacion = Integer.parseInt(habitacion.getPrecio()); // Precio por persona
        return (personas  * precioHabitacion);
    }

    private double calcularImpuesto(double monto) {
        double porcentajeImpuesto = 0.13; // 13% de impuesto
        return monto * porcentajeImpuesto;
    }

    private double calcularDescuento(Reserva reserva) {
        int personas = reserva.getNumeroPersonas();
        double montoTotal = calcularMonto(reserva, registrohabitaciones);

        if (personas >= 5) {
            double porcentajeDescuento = 0.1; // 10% de descuento
            return montoTotal * porcentajeDescuento;
        }
        return 0.0; // Sin descuento
    }

    private double calcularMontoTotal(double monto, double impuesto, double descuento) {
        return monto + (monto * (impuesto / 100)) - descuento;
    }
}
        
    

