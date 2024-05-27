/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tdasfirsthalf;

import java.util.LinkedList;

/**
 *
 * @author emili
 */
public class TDAsFirstHalf {

    public static void main(String[] args) {
        
        /*
        //Trie
        TArbolTrie arbolito = new TArbolTrie();
        arbolito.insertar("manuel");
        arbolito.insertar("manolo");
        arbolito.insertar("pitufo");
        LinkedList<String> list = arbolito.predecir("man");
        System.out.println(list);
        */
        
        /*
        //Arbol Generico
        IArbolGenerico arbolazo = new TArbolGenerico();
        arbolazo.insertar("C","C");
        arbolazo.insertar("C","numeros");
        arbolazo.insertar("numeros","1");
        arbolazo.insertar("numeros","2");
        arbolazo.insertar("C","letras");
        arbolazo.insertar("letras","H");
        arbolazo.insertar("letras","D");
        */
        
        //Arbol binario
        
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
        
       // System.out.println(arbolCedula.getCantidadHojas());
        
        TArbolBB arbol2 = new TArbolBB();
        arbol2.insertar(nodo5);
        arbol2.insertar(nodo2);
        arbol2.insertar(nodo7);
        
        System.out.println(arbol2.getCantidadHojas());
    }
}
