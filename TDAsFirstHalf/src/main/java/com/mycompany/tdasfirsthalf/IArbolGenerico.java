/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.tdasfirsthalf;

/**
 *
 * @author emili
 * @param <T>
 */
public interface IArbolGenerico<T> {
    
    public boolean insertar(Comparable etiquetaPadre, Comparable etiqueta);
    public String listarIndentado();
    public void preorden();
    public void inOrden();
    public void postOrden();
    public INodoAG buscar(Comparable etiqueta);
    public boolean eliminar(Comparable etiqueta);
    public void vaciar();
    public boolean esVacio();
    public INodoAG padre(INodoAG nodo);
    
    
}
