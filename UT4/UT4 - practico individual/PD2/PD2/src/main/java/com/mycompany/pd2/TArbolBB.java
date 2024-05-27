/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pd2;

/**
 *
 * @author emili
 */
public class TArbolBB implements IArbolBB{
    
    public TElementoAB Raiz;

    @Override
    public boolean insertar(TElementoAB unElemento) {
        if(esVacio()){
            Raiz = unElemento;
            return true;
        }
        else{
            return Raiz.insertar(unElemento);
        }
    }

    @Override
    public TElementoAB buscar(Comparable unaEtiqueta) {
        if(esVacio()){
            return null;
        }else{
            return Raiz.buscar(unaEtiqueta);
        }
    }
    
    public boolean esVacio(){
        return Raiz == null;
    }

    @Override
    public String preOrden() {
        if(Raiz == null){
            return "Arbol vacío";
        }else{
            return Raiz.preOrden();
        }
    }

    @Override
    public String inOrden() {
        if(Raiz==null){
            return "Arbol vacío";
        }else{
            return Raiz.inOrden();
        }
    }

    @Override
    public String postOrden() {
        if(Raiz==null){
            return "Arbol vacío";
        }else{
            return Raiz.postOrden();
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if(Raiz != null){
            Raiz = Raiz.eliminar(unaEtiqueta);
        }else{
            System.out.println("árbol vacío");
        }
    }
    
}
