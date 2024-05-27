/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tdasfirsthalf;

import java.util.LinkedList;

/**
 *
 * @author Emiliano
 * @param <T>
 */
public class TNodoTrie<T> implements INodoTrie{

    private static final int ABECEDARIO_LENGTH = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    
    public TNodoTrie(){
        hijos = new TNodoTrie[ABECEDARIO_LENGTH];
        esPalabra = false;
    }
   
    @Override
    public int buscar(String s){
        if(buscarNodoTrie(s) != null){
            return s.length();    
        }else{
            return 0;
        }
    }
    
    private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        int indice = s.charAt(0) - 'a';
        if(s.length() == 1){
          if(nodo.hijos[indice] != null){
              if(nodo.hijos[indice].esPalabra == true){
                  return nodo.hijos[indice];
              }else{
                  return null;
              }
          }
        }
        if(nodo.hijos[indice] != null){
            return nodo.hijos[indice].buscarNodoTrie(s.substring(1));
        }else{
            return null;
        }
    }


    @Override
    public void insertar(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }
    
    private void imprimir(String s, TNodoTrie nodo){
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            for (int c = 0; c < ABECEDARIO_LENGTH; c++) {
                if (nodo.hijos[c] != null) {
                   imprimir(s+(char)(c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }
    
   
    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie nodoInicio = buscarNodoPrefijo(prefijo);
        predecir(prefijo, nodoInicio, palabras);
    }
    
    private void predecir(String s, TNodoTrie nodo, LinkedList<String> palabras){
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(s);
            }
            for (int c = 0; c < ABECEDARIO_LENGTH; c++) {
                if (nodo.hijos[c] != null) {
                   predecir(s+(char)(c + 'a'), nodo.hijos[c], palabras);
                }
            }
        }
    }

    private TNodoTrie buscarNodoPrefijo(String s) {
        TNodoTrie nodo = this;
        int indice = s.charAt(0) - 'a';
        if(s.length() == 1){
          if(nodo.hijos[indice] != null){
              return nodo.hijos[indice];
          }
        }
        if(nodo.hijos[indice] != null){
            return nodo.hijos[indice].buscarNodoPrefijo(s.substring(1));
        }
        return null;
    }

}
