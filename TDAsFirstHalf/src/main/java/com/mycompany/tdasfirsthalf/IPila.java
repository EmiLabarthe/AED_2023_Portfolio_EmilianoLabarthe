/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.tdasfirsthalf;

/**
 *
 * @author emili
 */
public interface IPila {
    public INodo pop();
    public boolean push(INodo elemento);
    public INodo getCabeza();
    public void vaciar();
    public boolean esVacia();
}
