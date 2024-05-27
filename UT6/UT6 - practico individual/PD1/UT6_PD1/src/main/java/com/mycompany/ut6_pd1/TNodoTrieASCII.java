package com.mycompany.ut6_pd1;



import java.io.Serializable;
import java.util.LinkedList;

public class TNodoTrieASCII implements INodoTrie, Serializable {

    private static final int ABECEDARIO_LENGTH = 26;
    private TNodoTrieASCII[] hijos;
    private boolean esPalabra;
    
    public TNodoTrieASCII(){
        hijos = new TNodoTrieASCII[ABECEDARIO_LENGTH];
        esPalabra = false;
    }
   
    @Override
    public int buscar(String s){
        s=s.toLowerCase();
        if(buscarNodoTrie(s) != null){
            return s.length();    
        }else{
            return 0;
        }
        
        
    }
    
    private TNodoTrieASCII buscarNodoTrie(String s) {
        s=s.toLowerCase();
        TNodoTrieASCII nodo = this;
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
        TNodoTrieASCII nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrieASCII();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }
    
    private void imprimir(String s, TNodoTrieASCII nodo){
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
        TNodoTrieASCII nodoInicio = buscarNodoPrefijo(prefijo);
        predecir(prefijo, nodoInicio, palabras);
    }
    
    private void predecir(String s, TNodoTrieASCII nodo, LinkedList<String> palabras){
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

    private TNodoTrieASCII buscarNodoPrefijo(String s) {
        s=s.toLowerCase();
        TNodoTrieASCII nodo = this;
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
