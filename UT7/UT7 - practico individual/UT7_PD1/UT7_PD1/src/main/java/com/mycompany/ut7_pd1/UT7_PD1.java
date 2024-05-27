/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ut7_pd1;

import java.util.Arrays;

/**
 *
 * @author emili
 */
public class UT7_PD1 {

    public static void main(String[] args) {
        
        // Dado un vector de predecesores, que P[i] = predecesor del nodo i:
        
        Node node0 = new Node(' '); //Nodo vacío para que el index del array sea el mismo 
                                         // que la resta de ASCII
        Node node1 = new Node('a');
        Node node2 = new Node('b');
        Node node3 = new Node('c');
        Node node4 = new Node('d');
        Node[] P = new Node[]{node0,node1,node2,node3,node4};
        printOrigin2Node.printPath(P, node4);
        
    }
}
