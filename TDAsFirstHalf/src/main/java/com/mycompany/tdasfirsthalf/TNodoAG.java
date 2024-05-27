/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tdasfirsthalf;

/**
 *
 * @author emili
 * @param <T>
 */
public class TNodoAG<T> implements INodoAG<T>{

    private final Comparable etiqueta;
    private INodoAG hijoIzq;
    private INodoAG hermanoDer;
    
    public TNodoAG(Comparable etiqueta){
        this.etiqueta = etiqueta;
    }
    
    @Override
    public INodoAG getHijoIzq() {
        return hijoIzq;
    }
    
    @Override
    public void setHijoIzq(INodoAG nodo){
        hijoIzq = nodo;
    }

    @Override
    public INodoAG getHermanoDer() {
        return hermanoDer;
    }
    
    @Override
    public void setHermanoDer(INodoAG nodo){
        hermanoDer = nodo;
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public boolean insertar(Comparable etiquetaPadre, Comparable etiqueta) {
        INodoAG padre = buscar(etiquetaPadre);
        if(padre.getHijoIzq() == null){
            padre.setHijoIzq(new TNodoAG(etiqueta));
            return true;
        }else{
            INodoAG hijo = padre.getHijoIzq();
            while(hijo.getHermanoDer() != null){
                hijo = hijo.getHermanoDer();
            }
            hijo.setHermanoDer(new TNodoAG(etiqueta));
            return true;
        }
    }

    @Override
    public void preorden() {
        System.out.println(getEtiqueta());
        INodoAG hijo = this.hijoIzq;
        while(hijo != null){
            hijo.preorden();
            hijo = hijo.getHermanoDer();
        }
    }

    @Override
    public void inOrden() {
        INodoAG hijo = this.getHijoIzq();
        while(hijo != null){
            hijo.inOrden();
            System.out.println(getEtiqueta());
            hijo = hijo.getHermanoDer();
        }
    }

    @Override
    public void postOrden() {
        INodoAG hijo = this.getHijoIzq();
        while(hijo != null){
            hijo.postOrden();
            hijo = hijo.getHermanoDer();
        }
        System.out.println(getEtiqueta());
    }

    @Override
    public INodoAG buscar(Comparable etiqueta) {
        INodoAG buscado = null;
        if(this.getEtiqueta().compareTo(etiqueta) == 0){
            return this;
        }
        if (this.getEtiqueta().compareTo(etiqueta) != 0){
            if(getHijoIzq() != null){
                buscado = hijoIzq.buscar(etiqueta);
            }if(getHermanoDer() != null){
                buscado = hermanoDer.buscar(etiqueta);
           }
        }
        return buscado;
    }
    @Override
    public boolean eliminar(Comparable etiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
