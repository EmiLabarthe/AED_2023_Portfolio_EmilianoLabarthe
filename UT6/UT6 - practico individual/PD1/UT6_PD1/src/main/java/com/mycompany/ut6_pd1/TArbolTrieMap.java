package com.mycompany.ut6_pd1;


import java.io.Serializable;
import java.util.LinkedList;

public class TArbolTrieMap implements IArbolTrie, Serializable {

    private TNodoTrieMap raiz;//////

    @Override
    public void insertar(String s) {
        if (raiz == null) {
            raiz = new TNodoTrieMap();
        }
        raiz.insertar(s);
    }

    @Override
    public int buscar(String s) {
        if (raiz == null) {
            return 0;
        }
        return raiz.buscar(s);
    }

    public boolean eliminar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        } else {
            System.out.print("vacío");
        }
    }

    @Override
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
