/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ut6_pd5;

/**
 *
 * @author emili
 */
public class UT6_PD5 {

    public static void main(String[] args) {
        TTrieHashMap trie = new TTrieHashMap();
        
        
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("palabras.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }
        
        System.out.println(trie.predecir("p"));
        
    }
}
