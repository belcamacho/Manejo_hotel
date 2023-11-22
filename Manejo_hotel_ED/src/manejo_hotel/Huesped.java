/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo_hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import static manejo_hotel.Manejo_hotel.registrohuespedes;

/**
 *
 * @author belca
 */
public class Huesped extends Persona {

    public Huesped(String cedula1, String nombre1, int edad1, String pais1, String nacionalidad1, int telefono1) {
    }
     Scanner scanner = new Scanner(System.in);
    private int edad;
    private String pais;
    private String nacionalidad;
    private int telefono;
    
    
    public Huesped() {
   
    }
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
    
    
public void menuhuesped(ArrayList<Huesped> registrohuespedes){
        Scanner scanner = new Scanner(System.in);
        
       

        boolean salir = false;
         while (!salir) {
             try{ 
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ingresar huesped");
            System.out.println("2. Modificar información de huésped");
            System.out.println("3. Eliminar huésped");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");

            int opcion = scanner.nextInt();
            
            
            switch (opcion) {
                case 1:
                    ingresarHuesped(registrohuespedes);
                    break;
                case 2:
                    modificarHuesped(registrohuespedes);
                    break;
                case 3:
                    eliminarHuesped(registrohuespedes);
                    break;
                case 4:
                    salir = true;
                default:
                    
                
                
            }
            }catch(Exception e){
    System.out.println("Ingrese datos correctos");
    
    
}
             }

}
      public  void ingresarHuesped(ArrayList<Huesped> registrohuespedes) {
        System.out.println("Ingresar datos del huésped:");
        System.out.print("Digiste su número de identificación: ");
        String cedula = scanner.nextLine();
        System.out.print("Digite su nombre:");
        String nombre = scanner.nextLine();
        System.out.print("Digite su edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite su País de residencia: ");
        String pais = scanner.nextLine();
        System.out.print("Digite su nacionalidad: ");
        String nacionalidad = scanner.nextLine();
        System.out.print("Digite su Teléfono: ");
        int telefono = scanner.nextInt();
        scanner.nextLine();
        
        Huesped huesped = new Huesped(cedula, nombre, edad, pais, nacionalidad, telefono);
        huesped.setCedula(cedula);
        huesped.setNombre(nombre);
        huesped.setEdad(edad);
        huesped.setNacionalidad(nacionalidad);
        huesped.setPais(pais);
        huesped.setTelefono(telefono);
        registrohuespedes.add(huesped);
        System.out.println("Huésped ingresado");
        huesped.mostrar_huespedes(registrohuespedes);

    }
      
      public void modificarHuesped(ArrayList<Huesped> registrohuespedes) {
    System.out.print("Ingrese la cédula del huésped que desea modificar: ");
    String cedulaBuscar = scanner.nextLine();

            for (Huesped huesped : registrohuespedes) {
                if (huesped.getCedula().equals(cedulaBuscar)) {
                    System.out.println("Ingrese los nuevos datos del huésped:");
                    System.out.print("Digite su nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Digite su nueva edad: ");
                    int nuevaEdad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite su nuevo País de residencia: ");
                    String nuevoPais = scanner.nextLine();
                    System.out.print("Digite su nueva nacionalidad: ");
                    String nuevaNacionalidad = scanner.nextLine();
                    System.out.print("Digite su nuevo Teléfono: ");
                    int nuevoTelefono = scanner.nextInt();
                    scanner.nextLine();

            huesped.setNombre(nuevoNombre);
            huesped.setEdad(nuevaEdad);
            huesped.setPais(nuevoPais);
            huesped.setNacionalidad(nuevaNacionalidad);
            huesped.setTelefono(nuevoTelefono);

            System.out.println("Huésped modificado");
            return;
            
        }
                huesped.mostrar_huespedes(registrohuespedes);
    }

    System.out.println("Huésped no encontrado");
}

      
      
      public void eliminarHuesped(ArrayList<Huesped> registrohuespedes){
             System.out.print("Ingrese la cédula del huésped que desea eliminar: ");
    String cedulaBuscar = scanner.nextLine();

    for (Huesped huesped : registrohuespedes) {
        if (huesped.getCedula().equals(cedulaBuscar)) {
            registrohuespedes.remove(huesped);
            System.out.println("Huésped eliminado");
            return;
        }else {
                    System.out.println("cliente no encontrado");
                    }
        huesped.mostrar_huespedes(registrohuespedes);
        }
    }


       public void mostrar_huespedes(ArrayList<Huesped> registrohuespedes){
    int cont = 0;
    for (Huesped huesped : registrohuespedes) {
        System.out.println("Huesped: " + cont +
                " Cédula: " + huesped.getCedula() +
                " Nombre: " + huesped.getNombre() +
                " Edad: " + huesped.getEdad() +
                " País: " + huesped.getPais() +
                " Nacionalidad: " + huesped.getNacionalidad() +
                " Telefono: " + huesped.getTelefono());

        cont++;
    }
}
       @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Huesped huesped = (Huesped) o;
    return Objects.equals(nombre, huesped.nombre);
}

@Override
public int hashCode() {
    return Objects.hash(nombre);
}

     
       }

