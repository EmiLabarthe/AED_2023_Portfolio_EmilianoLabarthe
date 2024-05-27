/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut7_pd1;

import java.util.LinkedList;

/**
 *
 * @author emili
 */
public class printOrigin2Node {
    
    public static void printPath(Node[] P, Node node){
        
        // Debido a que los nodos almacenan characters y no números,
        // realizamos la técnica de restar su ASCII con el ASCII de 'a'
        // y conseguir su índice
        
        LinkedList<Character> path = new LinkedList<>();
        path.addFirst(node.getValue());
        int indexToCheck = node.getValue() - 'a';
        while( indexToCheck != 1){ 
           path.addFirst(P[indexToCheck].getValue());
           indexToCheck = P[indexToCheck].getValue() - 'a';
        }
        path.addFirst(P[indexToCheck].getValue());
        System.out.println(path.toString());
    }
}
