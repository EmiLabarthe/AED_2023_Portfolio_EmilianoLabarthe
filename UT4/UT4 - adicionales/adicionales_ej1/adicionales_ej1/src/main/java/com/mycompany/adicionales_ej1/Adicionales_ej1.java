/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.adicionales_ej1;

/**
 *
 * @author emili
 */
public class Adicionales_ej1 {

    public static void main(String[] args) {
        TElementoAB nodo5 = new TElementoAB(5, "Pepe", "E", "medicina");
        TElementoAB nodo2 = new TElementoAB(2, "Pepe", "B", "psicologia");
        TElementoAB nodo7 = new TElementoAB(7, "Pepe", "G", "medicina");
        TElementoAB nodo3 = new TElementoAB(3, "Pepe", "C", "derecho");
        TElementoAB nodo4 = new TElementoAB(4, "Pepe", "D", "medicina");
        TElementoAB nodo8 = new TElementoAB(8, "Pepe", "H", "alimentos");
        TElementoAB nodo1 = new TElementoAB(1, "Pepe", "A", "medicina");
        TElementoAB nodo6 = new TElementoAB(6, "Pepe", "F", "medicina");
        
        TArbolBB arbolCedula = new TArbolBB();
        arbolCedula.insertar(nodo5);
        arbolCedula.insertar(nodo2);
        arbolCedula.insertar(nodo7);
        arbolCedula.insertar(nodo3);
        arbolCedula.insertar(nodo4);
        arbolCedula.insertar(nodo8);
        arbolCedula.insertar(nodo1);
        arbolCedula.insertar(nodo6);
        
        TArbolBB arbolCarrera = arbolCedula.armarIndiceCarrera("medicina");
        System.out.println(arbolCarrera.inOrden());
        
    }
}
