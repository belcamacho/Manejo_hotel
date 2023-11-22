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




public class Ascensores extends Huesped {
    private  Pilas ascensor1 = new Pilas(10);
    private  Pilas ascensor2 = new Pilas(10);
    private  Pilas ascensor3 = new Pilas(10);
    private  Pilas ascensor4 = new Pilas(10);
    private int numero;
    private int Ascensor;
    private String nombrePersona;
    Scanner scanner = new Scanner(System.in);

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public int getAscensor(int numero) {
        return Ascensor;
    }



    public void setAscensor(int Ascensor) {
        this.Ascensor = Ascensor;
    }
    
    
    
    public void Menu(){
      boolean salir = false;
         while (!salir) {
             try{
            System.out.println("Seleccione una opción:");
            System.out.println("1. Solicitar ascensor");
            System.out.println("2. Verificar si un ascensor está ocupado o libre");
            System.out.println("3. Contar ascensores libres y ocupados");
            System.out.println("4. Verificar la ubicación de una persona en un ascensor");
            System.out.println("5. Limpiar todos los ascensores");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    Mantenimiento();
                    System.out.print("Ingrese el nombre del huesped:");
                    String nombre = scanner.next();
                    System.out.print("Ingrese el piso al que desea ir:");
                    int piso = scanner.nextInt();
                    AsignarAscensor(nombre, piso, registrohuespedes);
                    break;
                case 2:
                    System.out.print("Ingrese el número de ascensor (1-4): ");
                    int numAscensor = scanner.nextInt();
                    ascensorOcupado (numAscensor);
                    
                
                 case 3:
                    contarAscensores();
                    break;
                case 4:
                    UbicacionPersona(nombrePersona);
                    break;

                case 5:
                    limpiarAscensores();
                    break;
                    
                case 6:
                    salir=true;
                    break;
        
    }
    
    
    }catch(Exception e){
                            System.out.println("Ingrese datos correctos");
    }
    
}
         }
    
    public void Mantenimiento(){
        System.out.println("¿Desea poner algún ascensor en mantenimiento? (Sí/No): ");
        String respuesta = scanner.next();

        if (respuesta.equalsIgnoreCase("Sí")) {
        String nombre="Mantenimiento";
        System.out.println("Elija el número del ascensor a poner en mantenimiento (1/2/3/4): ");
         int numAscensor = scanner.nextInt();
         switch (numAscensor) {
             case 1:
                ascensor1.push(1, nombre);
                break;
            case 2:
                 ascensor2.push(1, nombre);
                break;
            case 3:
                ascensor3.push(1, nombre);
                break;
            case 4:
                ascensor4.push(1, nombre);
            break;
            default:
                 System.out.println("Opción inválida");
            break;
    }
         }
        }
               
    public void AsignarAscensor(String nombre, int piso, ArrayList<Huesped> registrohuespedes){
          boolean nombreEncontrado = false;
    
    for (Huesped huesped : registrohuespedes) {
        if (huesped.getNombre().equalsIgnoreCase(nombre)) {
            nombreEncontrado = true;
            break;
        }
    }

    if (nombreEncontrado) {
             if (ascensor1.pilaVacia()){
            ascensor1.push(piso, nombre);
            System.out.println("El ascensor 1 ha sido asignado a " + nombre );
        } else if (ascensor2.pilaVacia()) {
            ascensor2.push(piso, nombre);
            System.out.println("El ascensor 2 ha sido asignado a " + nombre );
        } else if (ascensor3.pilaVacia()) {
            ascensor3.push(piso, nombre);
            System.out.println("El ascensor 3 ha sido asignado a " + nombre );
        } else if (ascensor4.pilaVacia()) {
            ascensor4.push(piso, nombre);
            System.out.println("El ascensor 4 ha sido asignado a " + nombre );
        } else {
            System.out.println("No se pudo asignar ningún ascensor en este momento");
        }
             
        }else{
             System.out.println("El nombre no se encuentra registrado como huésped");
         }
        
        }
        
        
    
            public void ascensorOcupado(int numAscensor) {
        if (numAscensor == 1){
            if (ascensor1.pilaVacia()){
                System.out.println("Este ascensor se encuentra libre.");}
                else{
                        System.out.println("Este ascensor se encuentra ocupado");
                        }    
        } else if (numAscensor == 2){
            if (ascensor2.pilaVacia()){
                System.out.println("Este ascensor se encuentra libre.");}
                else{
                        System.out.println("Este ascensor se encuentra ocupado.");
                        }   
     } else if (numAscensor == 3){
          if (ascensor3.pilaVacia()){
                System.out.println("Este ascensor se encuentra libre.");}
                else{
                        System.out.println("Este ascensor se encuentra ocupado.");
                        }  
     } else if (numAscensor == 4){
          if (ascensor4.pilaVacia()){
                System.out.println("Este ascensor se encuentra libre.");}
                else{
                        System.out.println("Este ascensor se encuentra ocupado.");
                        }  
     }else {
            System.out.println("Digite un número válido.");
     }
        }

      public void contarAscensores() {
            List<Integer> ascensoresLibres = new ArrayList<>();
            List<Integer> ascensoresOcupados = new ArrayList<>();

          if (ascensor1.pilaVacia()) {
             ascensoresLibres.add(1);
         }else {
                 ascensoresOcupados.add(1);
    }
         if (ascensor2.pilaVacia()) {
            ascensoresLibres.add(2);
       }    else {
                ascensoresOcupados.add(2);
    }
         if (ascensor3.pilaVacia()) {
            ascensoresLibres.add(3);
    }       else {
                ascensoresOcupados.add(3);
    }
         if (ascensor4.pilaVacia()) {
            ascensoresLibres.add(4);
    }        else {
                ascensoresOcupados.add(4);
    }
    
        System.out.println("Ascensores libres: " + ascensoresLibres);
        System.out.println("Ascensores ocupados: " + ascensoresOcupados);
}
         
      
       public void UbicacionPersona(String nombrePersona) {
           System.out.println("Ingrese el nombre a buscar en el ascensor: ");
           String nombre = scanner.next();
    String resultadoPila1 = ascensor1.buscar(nombre);
    String resultadoPila2 = ascensor2.buscar(nombre);
    String resultadoPila3 = ascensor3.buscar(nombre);
    String resultadoPila4 = ascensor4.buscar(nombre);

    if (!resultadoPila1.equals("No se encuentra")) {
        System.out.println("Encontrado en Ascensor 1, Piso: " + resultadoPila1);
    }

    if (!resultadoPila2.equals("No se encuentra")) {
        System.out.println("Encontrado en Ascensor 2, Piso: " + resultadoPila2);
    }

    if (!resultadoPila3.equals("No se encuentra")) {
        System.out.println("Encontrado en Ascensor 3, Piso: " + resultadoPila3);
    }

    if (!resultadoPila4.equals("No se encuentra")) {
        System.out.println("Encontrado en Ascensor 4, Piso: " + resultadoPila4);
    }
}
   

          
  
         public void limpiarAscensores() {
             ascensor1.limpiarPila();
             ascensor2.limpiarPila();
             ascensor3.limpiarPila();
             ascensor4.limpiarPila();
             System.out.println("Se han limpiado todos los ascensores.");
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
   


