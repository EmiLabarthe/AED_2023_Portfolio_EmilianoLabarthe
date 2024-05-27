package com.mycompany.ut6_pd1;



import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrieMap implements INodoTrie, Serializable {

    private HashMap<String, TNodoTrieMap> hijos;
    private boolean esPalabra;
    
    public TNodoTrieMap(){
        hijos = new HashMap<>();
        esPalabra = false;
    }
    
    public HashMap<String, TNodoTrieMap> getHijos(){
        return this.hijos;
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
    
    private TNodoTrieMap buscarNodoTrie(String s) {
        s=s.toLowerCase();
        TNodoTrieMap nodo = this;
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


    @Override
    public void insertar(String s) {
        TNodoTrieMap nodo = this;
        String key;
        for (int c = 0; c < s.length(); c++) {
            if(c == s.length() - 1){
                key = s.substring(c);
            }else{
                key = s.substring(c,c+1);  
            }
            
            if (nodo.getHijos().containsKey(key) == false) {
                nodo.getHijos().put(key, new TNodoTrieMap());
            }
            nodo = nodo.getHijos().get(key);
        }
        nodo.esPalabra = true;
    }

    
    @Override
    public void imprimir() {
        imprimir("", this);
    }
    
    
    private void imprimir(String s, TNodoTrieMap nodo){
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            for (HashMap.Entry<String, TNodoTrieMap> entry : nodo.getHijos().entrySet()) {
                imprimir(s + entry.getKey(), nodo.getHijos().get(entry.getKey()));
            }
        }
    }
    
   
    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrieMap nodoInicio = buscarNodoPrefijo(prefijo);
        predecir(prefijo, nodoInicio, palabras);
    }
    
    private void predecir(String s, TNodoTrieMap nodo, LinkedList<String> palabras){
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(s);
            }
            for (HashMap.Entry<String, TNodoTrieMap> entry : nodo.getHijos().entrySet()) {
                predecir(s + entry.getKey(), nodo.getHijos().get(entry.getKey()), palabras);
            }
        }
    }

    private TNodoTrieMap buscarNodoPrefijo(String s) {
        s=s.toLowerCase();
        TNodoTrieMap nodo = this;
        
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
