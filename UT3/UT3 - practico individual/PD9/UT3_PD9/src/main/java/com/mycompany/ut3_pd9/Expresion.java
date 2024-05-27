/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut3_pd9;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author emili
 */
public class Expresion {
    
    public static boolean verificador(char[] entrada){
        Stack<Character> pila = new Stack<>();
        for(char corchete : entrada){
            if(corchete == '{'){
                pila.push(corchete);
            }if(corchete == '}'){
                if(pila.empty()){
                    return false;
                }else{
                    pila.pop();
                }
            }
        }
        return pila.empty();
    }
}
