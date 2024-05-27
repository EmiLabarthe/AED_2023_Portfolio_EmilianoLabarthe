/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tdasfirsthalf;

import java.util.LinkedList;

/**
 *
 * @author emili
 */
public class TArbolTrie implements IArbolTrie{

    private TNodoTrie raiz = null;//////
    
    @Override
    public void insertar(String s) {
        if(raiz == null){
            raiz = new TNodoTrie();
        }
        raiz.insertar(s);
    }

    @Override
    public int buscar(String s) {
        if(raiz == null){
            return 0;
        }else{
            return raiz.buscar(s);
        }
    }

    public boolean eliminar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void imprimir() {
        if(raiz != null){
            raiz.imprimir();
        }else{
            System.out.print("vacío");
        }
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> listaPrefijo = new LinkedList();
        if(raiz != null){
            raiz.predecir(prefijo, listaPrefijo);
        }
        return listaPrefijo;
    }

}
