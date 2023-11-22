/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo_hotel;

import java.util.Scanner;



public class arbolBinario {
    nodoArbolBinario nodo= new nodoArbolBinario();
    nodoArbolBinario raiz;
    int cant;
    int altura;

public arbolBinario(){
    raiz=null;
}

public boolean esVacio(){
    return (raiz == null);
}
public void insertarCancelacion(Reserva reserva) {
    if (!existe(reserva.getIdReserva())) {
        nodoArbolBinario nuevo = new nodoArbolBinario();
        nuevo.reserva = reserva;
        nuevo.izq = null;
        nuevo.der = null;
        if (raiz == null)
            raiz = nuevo;
        else {
            nodoArbolBinario anterior = null, reco;
            reco = raiz;
            while (reco != null) {
                anterior = reco;
                if (reserva.getIdReserva().compareTo(reco.reserva.getIdReserva()) < 0)
                    reco = reco.izq;
                else
                    reco = reco.der;
            }
            if (reserva.getIdReserva().compareTo(anterior.reserva.getIdReserva()) < 0)
                anterior.izq = nuevo;
            else
                anterior.der = nuevo;
        }
    }
}


public boolean existe(String idReserva) {
    nodoArbolBinario reco = raiz;

    while (reco != null) {
        if (idReserva.equals(reco.reserva.getIdReserva())) {
            return true;
        } else if (idReserva.compareTo(reco.reserva.getIdReserva()) > 0) {
            reco = reco.der;
        } else {
            reco = reco.izq;
        }
    }

    return false;
}
public void mostrarArbolCancelaciones(nodoArbolBinario nodo) {
    if (nodo != null) {
        mostrarArbolCancelaciones(nodo.izq); // Recorrer el subárbol izquierdo
        
        Reserva reserva = nodo.reserva;
        
        System.out.println("ID de Reserva: " + reserva.getIdReserva());
        System.out.println("Descripción de Reserva: " + reserva.getDescripcionReserva());
        System.out.println("Tipo de Reserva: " + reserva.getTipoReserva());
        System.out.println("Fecha de Inicio: " + reserva.getFechaInicio());
        System.out.println("Fecha Final: " + reserva.getFechaFinal());
        System.out.println("Fecha de Creación: " + reserva.getFechaCreacion());
        System.out.println("Número de Personas: " + reserva.getNumeroPersonas());
        System.out.println("Estado: " + (reserva.isEstado() ? "Activo" : "Inactivo"));
        
        System.out.println("------------------------------------------");
        mostrarArbolCancelaciones(nodo.der); 
    }
}
public nodoArbolBinario buscar(String idReserva) {
    return buscarRecursivo(raiz, idReserva);
}

private nodoArbolBinario buscarRecursivo(nodoArbolBinario nodo, String idReserva) {
    if (nodo == null || nodo.reserva.getIdReserva().equals(idReserva)) {
        return nodo;
    }

    if (idReserva.compareTo(nodo.reserva.getIdReserva()) < 0) {
        return buscarRecursivo(nodo.izq, idReserva);
    } else {
        return buscarRecursivo(nodo.der, idReserva);
    }
}
}







    

