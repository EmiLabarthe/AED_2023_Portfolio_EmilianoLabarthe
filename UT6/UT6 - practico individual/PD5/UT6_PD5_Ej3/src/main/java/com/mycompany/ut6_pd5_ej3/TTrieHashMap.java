package com.mycompany.ut6_pd5_ej3;


import java.util.LinkedList;

public class TTrieHashMap {

    private TNodoTrieHashMap raiz;//////

    
    public void insertar(TAbonado unAbonado) {
        if (raiz == null) {
            raiz = new TNodoTrieHashMap();
        }
        raiz.insertar(unAbonado);
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

    
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        LinkedList<TAbonado> listaPrefijo = new LinkedList<>();
        String prefijo = pais.concat(area);
        if (prefijo != null) {
            if (raiz != null) {
                raiz.buscarTelefonos(prefijo, listaPrefijo);
            }
            return listaPrefijo;
        } else {
            return null;
        }

    }
}
