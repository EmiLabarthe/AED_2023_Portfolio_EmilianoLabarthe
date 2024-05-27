package com.mycompany.tdasfirsthalf;

/**
 *
 * @author ernesto
 * @param <T>
 */
public class TNodo<T> implements INodo {
    
    private Comparable etiqueta;
    private T dato;
    private INodo<T> siguiente = null;

    public TNodo(T dato) {
        this.dato = dato;
    }

    @Override
    public T getDato() {
        return this.dato;
    }

    public void setDato(T dato) {
        this.dato = dato;

    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public void imprimir() {
        System.out.println(dato.toString());
    }

    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }
    
    /**
     *
     * @param unNodo
     * @return
     */

    public boolean equals(TNodo unNodo) {
        return this.dato.equals(unNodo.getDato());
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }

    @Override
    public INodo<T> getSiguiente() {
        return this.siguiente;
    }

    @Override
    public void setSiguiente(INodo nodo) {
        this.siguiente = nodo;
    }

}
