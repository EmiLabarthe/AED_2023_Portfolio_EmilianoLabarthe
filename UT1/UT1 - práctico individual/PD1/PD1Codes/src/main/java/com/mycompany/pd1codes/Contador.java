/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.pd1codes;

/**
 *
 * @author Emiliano
 */
public class Contador {

    public final int MAX_CONT = 50;
    public int incremento = 1;
    public int contador = 1;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        Contador count = new Contador();
        count.displayCount();
        count.displayCountDoWhile();
        count.displayCountFor();
    }
    
    public void displayCount() {
        while(contador <= MAX_CONT) {
            System.out.println(contador);
            contador += incremento;
        }
    }
    
    public void displayCountDoWhile() {
        contador = 1;                                   // Reinicio el contador.
        do {
            
            System.out.println(contador);
            contador += incremento;
        } while(contador <= MAX_CONT);
    }
    
    public void displayCountFor() {
        for(contador = 1; contador <= MAX_CONT; contador += incremento) {   // Reinicio el contador.
            System.out.println(contador);
        }
    }
}
