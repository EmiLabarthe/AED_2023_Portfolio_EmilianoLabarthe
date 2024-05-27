/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tdasfirsthalf;

/**
 *
 * @author emili
 */
public class TListaOrdenada<T> implements ILista<T>{

    private INodo<T> Cabeza;

    public TListaOrdenada() {
        Cabeza = null;
    }

    @Override
    public void insertar(INodo<T> nodo) {
        if(this.Cabeza == null){
            this.Cabeza = nodo;
        }
        else{
            INodo nodoActual = Cabeza;
            while (nodoActual.getEtiqueta().compareTo(nodo.getEtiqueta()) > 0){
                nodoActual = nodoActual.getSiguiente();
            }
            nodo.setSiguiente(nodoActual.getSiguiente());
            nodoActual.setSiguiente(nodo);
        }
    }

    @Override
    public void insertar(T dato) {
        TNodo nodo = new TNodo(dato);
        this.insertar(nodo);
    }

    @Override
    public INodo<T> buscar(Comparable clave) {
        INodo nodoActual = Cabeza;
        while(nodoActual != null){
            if(nodoActual.getEtiqueta() == clave){
                return nodoActual;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        INodo nodoActual = Cabeza;
        if(nodoActual.getEtiqueta().equals(clave)){
            this.Cabeza = nodoActual.getSiguiente();
            return true;
        }
        while (nodoActual.getSiguiente() != null){
            if(nodoActual.getSiguiente().getEtiqueta().equals(clave)){
                nodoActual.setSiguiente(nodoActual.getSiguiente().getSiguiente());
                return true;
            }
            nodoActual.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        INodo nodoActual = this.Cabeza;
        StringBuilder toPrint = new StringBuilder();
        while(nodoActual.getSiguiente() != null){
            toPrint.append(nodoActual.getDato());
            toPrint.append("\n");
            nodoActual = nodoActual.getSiguiente();
        }
        return toPrint.toString();
    }

    @Override
    public String imprimir(String separador) {
        return null;
    }

    @Override
    public int cantElementos() {
        INodo nodoActual = this.Cabeza;
        int i = 0;
        while(nodoActual.getSiguiente() != null){
            i++;
            nodoActual = nodoActual.getSiguiente();
        }
        return i;
    }

    @Override
    public boolean esVacia() {
        return Cabeza == null;
    }

    public void clear(){
        this.Cabeza = null;
    }

    @Override
    public void setPrimero(INodo<T> unNodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
