/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tdasfirsthalf;

/**
 *
 * @author emili
 */
public class TArbolBB implements IArbolBB{
    
    public TElementoAB raiz;

    @Override
    public boolean insertar(TElementoAB unElemento) {
        if(esVacio()){
            raiz = unElemento;
            return true;
        }
        else{
            return raiz.insertar(unElemento);
        }
    }

    @Override
    public TElementoAB buscar(Comparable unaEtiqueta) {
        if(esVacio()){
            return null;
        }else{
            return raiz.buscar(unaEtiqueta);
        }
    }
    
    public boolean esVacio(){
        return raiz == null;
    }

    @Override
    public String preOrden() {
        if(raiz == null){
            return "Arbol vacío";
        }else{
            return raiz.preOrden();
        }
    }

    @Override
    public String inOrden() {
        if(raiz==null){
            return "Arbol vacío";
        }else{
            return raiz.inOrden();
        }
    }

    @Override
    public String postOrden() {
        if(raiz==null){
            return "Arbol vacío";
        }else{
            return raiz.postOrden();
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if(raiz != null){
            raiz = raiz.eliminar(unaEtiqueta);
        }else{
            System.out.println("árbol vacío");
        }
    }
    
    public int getProfundidad(Comparable etiqueta){
        if (raiz != null){
            int proofCounter = 0;
            return raiz.getProfundidad(etiqueta, proofCounter);
        }else{
            return 0;
        }
    }
    
    public int getAltura(Comparable etiqueta){                  // Si le paso la raiz devuelve altura del arbol
        if (raiz != null){
            TElementoAB nodo = buscar(etiqueta);
            if(nodo.getHijoIzq() == null && nodo.getHijoDer() == null){
                return 0;
            }else{
                return nodo.getAltura(nodo);
            }
        }
        else{
            return 0;
        }
    }
    
    public int getCantidadHojas(){
        if(raiz != null){
            return raiz.getCantidadHojas();
        }else{
            return 0;
        }
    }
    
    public int getTamano(){
        if(raiz != null){
            int nodeCounter = 0;
            return raiz.getTamano(nodeCounter);
        }else{
            return 0;
        }
        
    }
}
