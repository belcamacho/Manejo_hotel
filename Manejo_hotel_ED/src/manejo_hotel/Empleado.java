/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo_hotel;

/**
 *
 * @author belca
 */
public class Empleado extends Persona{
    private boolean tipoEmpleado;
    private String observaciones;
    private String estado;
    private String contrasena;

    public Empleado(String cedula, String contrasena) {
        this.cedula = cedula;
        this.contrasena = contrasena;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
    

    public boolean isTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(boolean tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String isEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
            
    
}
