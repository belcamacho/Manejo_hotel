/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package manejo_hotel;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author belca
 */
public class Manejo_hotel {
    Huesped huesped = new Huesped();
    private static ListasDobles reservaciones = new ListasDobles();
    public static ArrayList<Huesped> registrohuespedes = new ArrayList<Huesped>();
    public static ArrayList<Habitación> registrohabitaciones = new ArrayList<Habitación>();
    private static Empleado empleado = new Empleado("123456789", "ert289");
    private static Administrador administrador = new Administrador("987654321", "skf345");
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            try {
                System.out.println("Seleccione un rol:");
                System.out.println("1. Administrador");
                System.out.println("2. Empleado");
                System.out.println("3. Salir");
                System.out.print("Ingrese una opción: ");

                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        if (login(administrador.getCedula(), administrador.getContrasena())) {
                            administradorMenu();
                        } else {
                            System.out.println("Credenciales incorrectas.");
                        }
                        break;
                    case 2:
                        if (login(empleado.getCedula(), empleado.getContrasena())) {
                            empleadoMenu();
                        } else {
                            System.out.println("Credenciales incorrectas.");
                        }
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }

            } catch (Exception e) {
                System.out.println("Ingrese datos correctos.");
            }
        }
    }

public static boolean login(String cedula, String contrasena) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese su cédula: ");
    String inputCedula = scanner.nextLine().trim();
    System.out.print("Ingrese la contraseña: ");
    String inputContrasena = scanner.nextLine().trim();

    boolean cedulaCorrecta = inputCedula.equals(cedula);
    boolean contrasenaCorrecta = inputContrasena.equals(contrasena);

    return cedulaCorrecta && contrasenaCorrecta;
}
    public static void administradorMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menú Administrador:");
         boolean salir = false;
         while (!salir) {
             try{
            System.out.println("Seleccione una opción:");
            System.out.println("1. Control de Huésped");
            System.out.println("2. Control de Reservación");
            System.out.println("3. Control de habitaciones");
            System.out.println("4. Control de Ascensores");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");

            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    Huesped huesped = new Huesped();
                    huesped.menuhuesped(registrohuespedes);
                    break;
                case 2:
                    Reserva reserva = new Reserva();
                    reserva.menureserva();
                    break;
                case 3:
                    Habitación habitacion = new Habitación();
                    habitacion.menuHabitacion();
                    break;
                    
                case 4:
                    Ascensores ascensor = new Ascensores();
                    ascensor.Menu();
                    break;
                
                case 5:
                    salir = true;
                default:
            }

    
}catch(Exception e){
    System.out.println("Ingrese datos correctos");
}
             }
         }
             

    public static void empleadoMenu() {
        Scanner scanner = new Scanner(System.in);
        Reserva reserva = new Reserva();
        System.out.println("Menú Empleado:");
  
        boolean salir = false;
         while (!salir) {
             try{
            System.out.println("Seleccione una opción:");
            System.out.println("1. Control de Huésped");
            System.out.println("2. Control de Reservación");
            System.out.println("3. Facturación");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");

            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    Huesped huesped = new Huesped();
                    huesped.menuhuesped(registrohuespedes);
                case 2:
                    reserva.menureserva();
                    break;
                case 3:
                    Recibo recibo = new Recibo();
                    recibo.generarRecibo(reserva, registrohuespedes, reservaciones, registrohabitaciones);
                    
                case 4:
                    salir = true;
                default:
            }

    
}catch(Exception e){
    System.out.println("Ingrese datos correctos");
}
             }
         }
             }

                            
