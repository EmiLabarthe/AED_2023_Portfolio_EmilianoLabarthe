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
public interface INodoAG<T> {
    
    public INodoAG getHijoIzq();
    public void setHijoIzq(INodoAG nodo);
    public INodoAG getHermanoDer();
    public void setHermanoDer(INodoAG nodo);
    public Comparable getEtiqueta();
    public boolean insertar(Comparable etiquetaPadre, Comparable etiqueta);
    public void preorden();
    public void inOrden();
    public void postOrden();
    public INodoAG buscar(Comparable etiqueta);
    public boolean eliminar(Comparable etiqueta);
    
}
