/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tdasfirsthalf;

/**
 *
 * @author emili
 */
public class TCola implements ICola {

    private INodo cabeza;
    
    @Override
    public void anular() {
        cabeza = null;
    }

    @Override
    public INodo getFrente() {
        return cabeza;
    }

    @Override
    public boolean poneEnCola(INodo unElemento) {
        if(cabeza == null){
            cabeza = unElemento;
            return true;
        }else{
            INodo nodo = cabeza;
            while(nodo != null){
                nodo = nodo.getSiguiente();
            }
            nodo = unElemento;
            return true;
        }
    }

    @Override
    public INodo quitaDeCola() {
        INodo quitado = cabeza;
        cabeza = cabeza.getSiguiente();
        return quitado;
    }

    @Override
    public boolean esVacia() {
        return cabeza == null;
    }
    
}
