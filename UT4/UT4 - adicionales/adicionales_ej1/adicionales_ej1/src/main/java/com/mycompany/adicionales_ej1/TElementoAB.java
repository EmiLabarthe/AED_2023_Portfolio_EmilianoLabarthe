/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adicionales_ej1;

/**
 *
 * @author emili
 * @param <T>
 */
public class TElementoAB<T> implements IElementoAB{
    
    public Comparable Etiqueta;
    public Comparable Nombre;
    public Comparable Apellido;
    public Comparable Carrera;
    
    public TElementoAB hijoIzq;
    public TElementoAB hijoDer;
    
    public TElementoAB(Comparable etiqueta, Comparable nombre, Comparable apellido, Comparable carrera){
        this.Etiqueta = etiqueta;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Carrera = carrera;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.Etiqueta;
    }

    @Override
    public TElementoAB getHijoIzq() {
        return this.hijoIzq;
    }

    @Override
    public TElementoAB getHijoDer() {
        return this.hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(TElementoAB elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public TElementoAB buscar(Comparable unaEtiqueta) {
        if(unaEtiqueta.compareTo(this.getEtiqueta()) == 0){
            return this;
        }
        else{
            if(unaEtiqueta.compareTo(this.getEtiqueta()) < 0){
                if(hijoIzq != null){
                    return hijoIzq.buscar(unaEtiqueta);
                } else{
                    return null;
                }
            }
            else{
                if(hijoDer != null){
                    return hijoDer.buscar(unaEtiqueta);
                } else{
                    return null;
                }
            }
        }
    }
    
    public Comparable getCarrera(){
        return this.Carrera;
    }  
    
    public TElementoAB buscarCarrera(Comparable unaCarrera) {
        if(unaCarrera.compareTo(this.getCarrera()) == 0){
            return this;
        }
        else{
            if(unaCarrera.compareTo(this.getCarrera()) < 0){
                if(hijoIzq != null){
                    return hijoIzq.buscar(unaCarrera);
                } else{
                    return null;
                }
            }
            else{
                if(hijoDer != null){
                    return hijoDer.buscar(unaCarrera);
                } else{
                    return null;
                }
            }
        }
    }
        
    @Override
    public boolean insertar(TElementoAB elemento) {
        
        if(elemento.getEtiqueta().compareTo(this.getEtiqueta()) == 0){
            return false;
        }
        if(elemento.getEtiqueta().compareTo(this.getEtiqueta()) < 0){
            if(hijoIzq == null){
                hijoIzq = elemento;
                return true;
            }else{
                return hijoIzq.insertar(elemento);
            }
        }
        else{
            if(hijoDer == null){
                hijoDer = elemento;
                return true;
            } else{
                return hijoDer.insertar(elemento);
            }
        }
    }

    @Override
    public String preOrden() {
        StringBuilder str = new StringBuilder();
        str.append(imprimir());
        str.append("\n");
        if(hijoIzq != null){
            str.append(hijoIzq.preOrden());
        }
        if(hijoDer != null){
            str.append(hijoDer.preOrden());
        }
        return str.toString();
    }

    @Override
    public String inOrden() {
        StringBuilder str = new StringBuilder();
        if(hijoIzq != null){
            str.append(hijoIzq.inOrden());
        }
        str.append(imprimir());
        str.append("\n");
        if(hijoDer != null){
            str.append(hijoDer.inOrden());
        }
        return str.toString();
    }
    
    public String imprimir(){
        return this.Etiqueta.toString();
    }

    @Override
    public String postOrden() {
        StringBuilder str = new StringBuilder();
        if(hijoIzq != null){
            str.append(hijoIzq.postOrden());
        }
        if(hijoDer != null){
            str.append(hijoDer.postOrden());
        }
        str.append(imprimir());
        str.append("\n");
        return str.toString();
    }

    @Override
    public Object getDatos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        if(unaEtiqueta.compareTo(this.getEtiqueta()) < 0){
            if(hijoIzq != null){
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }
        if(unaEtiqueta.compareTo(this.getEtiqueta()) > 0){
            if(hijoDer != null){
                hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }
        return quitarNodo();
    }
    
    public TElementoAB quitarNodo(){
        if(hijoIzq == null){
            return hijoDer;
        }
        if(hijoDer == null){
            return hijoIzq;
        }
        TElementoAB hijo = hijoIzq;         // Va al subárbol izquierdo
        TElementoAB padre = this;
        while(hijo.getHijoDer() != null){
            padre = hijo;
            hijo = hijo.getHijoDer();
        }
        if(padre != this){
            padre.setHijoDer(hijo.getHijoIzq());
            hijo.setHijoIzq(hijoIzq);
        }
        hijo.setHijoDer(hijoDer);
        return hijo;
    }
    
    public boolean armarIndiceCarrera(Comparable carrera, TArbolBB arbolCarrera) {
        if(Carrera.equals(carrera)){
            arbolCarrera.nodoAlumno(this.Etiqueta, this.Nombre, this.Apellido, this.Carrera);
        }
        if(hijoIzq != null){
            hijoIzq.armarIndiceCarrera(carrera, arbolCarrera);
        }
        if(hijoDer != null){
            hijoDer.armarIndiceCarrera(carrera, arbolCarrera);
        }
        return false;
    }
}
