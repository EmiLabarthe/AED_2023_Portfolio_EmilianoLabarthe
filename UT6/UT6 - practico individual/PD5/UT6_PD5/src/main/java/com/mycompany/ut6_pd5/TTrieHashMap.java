package com.mycompany.ut6_pd5;


import java.util.LinkedList;

public class TTrieHashMap {

    private TNodoTrieHashMap raiz;//////

    
    public void insertar(String s) {
        if (raiz == null) {
            raiz = new TNodoTrieHashMap();
        }
        raiz.insertar(s);
    }

    
    public int buscar(String s) {
        if (raiz == null) {
            return 0;
        }
        return raiz.buscar(s);
    }

    public boolean eliminar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        } else {
            System.out.print("vacío");
        }
    }

    
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> listaPrefijo = new LinkedList();
        if (prefijo != null) {
            if (raiz != null) {
                raiz.predecir(prefijo, listaPrefijo);
            }
            return listaPrefijo;
        } else {
            return null;
        }

    }
}
