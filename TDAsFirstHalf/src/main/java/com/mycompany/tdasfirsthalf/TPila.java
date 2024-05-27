/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tdasfirsthalf;

/**
 *
 * @author emili
 */
public class TPila implements IPila{

    private INodo cabeza;
    
    @Override
    public INodo pop() {
        if(cabeza == null){
            return null;
        }else{
            INodo popeado = cabeza;
            cabeza = cabeza.getSiguiente();
            return popeado;
        }
    }

    @Override
    public boolean push(INodo elemento) {
        elemento.setSiguiente(cabeza);
        cabeza = elemento;
        return true;
    }

    @Override
    public INodo getCabeza() {
        return cabeza;
    }

    @Override
    public void vaciar() {
        cabeza = null;
    }

    @Override
    public boolean esVacia() {
        return cabeza == null;
    }
    
}
