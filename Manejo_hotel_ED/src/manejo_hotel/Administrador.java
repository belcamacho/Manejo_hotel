/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo_hotel;

/**
 *
 * @author belca
 */
public class Administrador extends Persona {
    private boolean tipoAdministrador;
    private String funciones;
    private boolean estado;
    String contrasena;

    public Administrador(String cedula, String contrasena) {
                this.cedula = cedula;
        this.contrasena = contrasena;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isTipoAdministrador() {
        return tipoAdministrador;
    }

    public void setTipoAdministrador(boolean tipoAdministrador) {
        this.tipoAdministrador = tipoAdministrador;
    }

    public String getFunciones() {
        return funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
