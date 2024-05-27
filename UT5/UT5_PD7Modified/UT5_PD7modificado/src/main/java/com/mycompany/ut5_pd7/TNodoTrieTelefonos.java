/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut5_pd7;

import java.time.LocalDate;
import java.util.LinkedList;

/**
 *
 * @author Emiliano
 * @param <T>
 */
public class TNodoTrieTelefonos<T> implements INodoTrieTelefonos{

    private static final int ABECEDARIO_LENGTH = 10;
    private TNodoTrieTelefonos[] hijos;
    private boolean esPalabra;
    private TAbonado abonado;
    
    public TNodoTrieTelefonos(){
        hijos = new TNodoTrieTelefonos[ABECEDARIO_LENGTH];
        esPalabra = false;
        abonado = null;
    }
   
    public void setAbonado(TAbonado Abonado){
        this.abonado = Abonado;
    }
    
    public TAbonado getAbonado(){
        return this.abonado;
    }
    
    public TNodoTrieTelefonos[] getHijos(){
        return hijos;
    }
    
    public int buscar(String s){
        if(buscarNodoTrie(s) != null){
            return s.length();    
        }else{
            return 0;
        }
    }
    
    private TNodoTrieTelefonos buscarNodoTrie(String s) {
        TNodoTrieTelefonos nodo = this;
        int indice = s.charAt(0) - '0';
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
    public void insertar(TAbonado abonado) {
        TNodoTrieTelefonos nodo = this;
        for (int c = 0; c < abonado.getTelefono().length(); c++) {
            int indice = abonado.getTelefono().charAt(c) - '0';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrieTelefonos();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
        nodo.setAbonado(abonado);
    }

    
    public void imprimir() {
        imprimir("", this);
    }
    
    private void imprimir(String s, TNodoTrieTelefonos nodo){
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            for (int c = 0; c < ABECEDARIO_LENGTH; c++) {
                if (nodo.hijos[c] != null) {
                   imprimir(s+(char)(c + '0'), nodo.hijos[c]);
                }
            }
        }
    }
    
   
    @Override
    public void buscarTelefonos(String prefijo, LinkedList<TAbonado> abonados) {
        TNodoTrieTelefonos nodoInicio = buscarNodoPrefijo(prefijo);
        predecir(prefijo, nodoInicio, abonados);
    }
    
    private void predecir(String s, TNodoTrieTelefonos nodo, LinkedList<TAbonado> abonados){
        if (nodo != null) {
            if (nodo.esPalabra) {
                abonados.add(nodo.getAbonado());
            }
            for (int c = 0; c < ABECEDARIO_LENGTH; c++) {
                if (nodo.hijos[c] != null) {
                   predecir(s+(char)(c + '0'), nodo.hijos[c], abonados);
                }
            }
        }
    }

    private TNodoTrieTelefonos buscarNodoPrefijo(String s) {
        TNodoTrieTelefonos nodo = this;
        int indice = s.charAt(0) - '0';
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
    
    public void ventasDesdeFecha(LocalDate date, LinkedList<TAbonado> ventas){
        if(this.esPalabra){
            if(date.isBefore(getAbonado().getFechaIngreso())){
                ventas.add(getAbonado());
            }
        }
        for(TNodoTrieTelefonos hijo : getHijos()){
            if(hijo != null){
                hijo.ventasDesdeFecha(date, ventas);
            }
        }
    }
    
    public void ventasDesdeFechaPais(LocalDate date, LinkedList<TAbonado> ventasDesdeFechaPais, String prefijoPais){
        LinkedList<TAbonado> abonadosPais = new LinkedList<>();
        buscarTelefonos(prefijoPais, abonadosPais);
        for(TAbonado unAbonado : abonadosPais){
            if(unAbonado.getFechaIngreso().isAfter(date)){
                ventasDesdeFechaPais.add(unAbonado);
            }
        }
    }
    
    public void todasLasVentasPais(String prefijo, LinkedList<TAbonado> abonados, TArbolTrieTelefonos triePais) {
        TNodoTrieTelefonos nodoInicio = buscarNodoPrefijo(prefijo);
        armarLasVentasPais(prefijo, nodoInicio, abonados, triePais);
    }
    
    private void armarLasVentasPais(String s, TNodoTrieTelefonos nodo, LinkedList<TAbonado> abonados, TArbolTrieTelefonos triePais){
        if (nodo != null) {
            if (nodo.esPalabra) {
                abonados.add(nodo.getAbonado());
                triePais.insertar(nodo.getAbonado());
                
            }
            for (int c = 0; c < ABECEDARIO_LENGTH; c++) {
                if (nodo.hijos[c] != null) {
                   armarLasVentasPais(s+(char)(c + '0'), nodo.hijos[c], abonados, triePais);
                }
            }
        }
    }
    
    public int getCantidadTelefonos(int counter){
        if (esPalabra) {
            counter++;
        }
        for (int c = 0; c < ABECEDARIO_LENGTH; c++) {
            if (hijos[c] != null) {
               counter = hijos[c].getCantidadTelefonos(counter);
            }
        }
        return counter;
    }
    
}
