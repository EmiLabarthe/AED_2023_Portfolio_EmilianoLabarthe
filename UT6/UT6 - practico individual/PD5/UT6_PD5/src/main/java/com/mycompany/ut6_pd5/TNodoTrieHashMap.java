package com.mycompany.ut6_pd5;



import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrieHashMap {

    private HashMap<String, TNodoTrieHashMap> hijos;
    private boolean esPalabra;
    
    public TNodoTrieHashMap(){
        hijos = new HashMap<>();
        esPalabra = false;
    }
    
    public HashMap<String, TNodoTrieHashMap> getHijos(){
        return this.hijos;
    }
    
    public int buscar(String s){
        s=s.toLowerCase();
        if(buscarNodoTrie(s) != null){
            return s.length();    
        }else{
            return 0;
        }
    }
    
    private TNodoTrieHashMap buscarNodoTrie(String s) {
        s=s.toLowerCase();
        TNodoTrieHashMap nodo = this;
        String key = s.substring(0, 1);
        if(s.length() == 1){
          if(nodo.getHijos().containsKey(key)){
              if(nodo.getHijos().get(key).esPalabra == true){
                  return nodo.getHijos().get(key);
              }else{
                  return null;
              }
          }
        }
        if(nodo.getHijos().containsKey(key)){
            return nodo.getHijos().get(key).buscarNodoTrie(s.substring(1));
        }else{
            return null;
        }
    }


    public void insertar(String s) {
        TNodoTrieHashMap nodo = this;
        String key;
        for (int c = 0; c < s.length(); c++) {
            if(c == s.length() - 1){
                key = s.substring(c);
            }else{
                key = s.substring(c,c+1);  
            }
            
            if (nodo.getHijos().containsKey(key) == false) {
                nodo.getHijos().put(key, new TNodoTrieHashMap());
            }
            nodo = nodo.getHijos().get(key);
        }
        nodo.esPalabra = true;
    }

    
   
    public void imprimir() {
        imprimir("", this);
    }
    
    
    private void imprimir(String s, TNodoTrieHashMap nodo){
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            for (HashMap.Entry<String, TNodoTrieHashMap> entry : nodo.getHijos().entrySet()) {
                imprimir(s + entry.getKey(), nodo.getHijos().get(entry.getKey()));
            }
        }
    }
    
   
    
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrieHashMap nodoInicio = buscarNodoPrefijo(prefijo);
        predecir(prefijo, nodoInicio, palabras);
    }
    
    private void predecir(String s, TNodoTrieHashMap nodo, LinkedList<String> palabras){
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(s);
            }
            for (HashMap.Entry<String, TNodoTrieHashMap> entry : nodo.getHijos().entrySet()) {
                predecir(s + entry.getKey(), entry.getValue(), palabras);
            }
        }
    }

    private TNodoTrieHashMap buscarNodoPrefijo(String s) {
        s=s.toLowerCase();
        TNodoTrieHashMap nodo = this;
        
        if(s.length() == 1){
          if(nodo.getHijos().containsKey(s)){
                  return nodo.getHijos().get(s);
          }
        }
        
        String str = s.substring(0, 1);
        if(nodo.getHijos().containsKey(str)){
            return nodo.getHijos().get(str).buscarNodoPrefijo(s.substring(1));
        }else{
            return null;
        }
    }

}
