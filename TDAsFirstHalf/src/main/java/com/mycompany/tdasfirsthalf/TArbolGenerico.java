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
public class TArbolGenerico<T> implements IArbolGenerico<T> {
    
    public INodoAG raiz;
    
    @Override
    public boolean insertar(Comparable etiquetaPadre, Comparable etiqueta) {
        if(raiz != null){
            return raiz.insertar(etiquetaPadre, etiqueta);
        }else{
            raiz = new TNodoAG(etiqueta);
            return true;
        }
    }

    @Override
    public String listarIndentado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void preorden() {
        if(raiz != null){
            raiz.preorden();
        }
    }

    @Override
    public void inOrden() {
        if(raiz != null){
            raiz.inOrden();
        }
    }

    @Override
    public void postOrden() {
        if(raiz != null){
            raiz.postOrden();
        }
    }

    @Override
    public void vaciar() {
        raiz = null;
    }
    
    @Override
    public boolean esVacio(){
        return raiz == null;
    }

    @Override
    public INodoAG padre(INodoAG nodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public INodoAG buscar(Comparable etiqueta) {
        if(raiz != null){
            return raiz.buscar(etiqueta);
        }else{
            return null;
        }
    }

    @Override
    public boolean eliminar(Comparable etiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
