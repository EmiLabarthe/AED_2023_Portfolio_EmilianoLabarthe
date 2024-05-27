/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ut6_pd4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author emili
 */
public class UT6_PD4 {

    public static void main(String[] args) {
        
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("libro.txt");
        
        
        // Justificación en README
        Map<String,Integer> frecuencias = new HashMap<>();
        
        for(String s : lineas){
            if(s.length() > 0){
                s = s.trim();
                String[] lineArray = s.split(" ");
                for(String str : lineArray){
                    if(frecuencias.containsKey(str)){
                        frecuencias.replace(str, frecuencias.get(str) + 1);
                    }else{
                        frecuencias.put(str, 1);
                    }
                }
            }
        }
        
        List<Map.Entry<String, Integer>> masFrecuentes = new ArrayList<>(frecuencias.entrySet());
        Collections.sort(masFrecuentes, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });
        
        int counter = 0;
        String[] salida = new String[10];
        
        while(counter < 10){
            salida[counter] = (masFrecuentes.get(counter).getKey() + "," + masFrecuentes.get(counter).getValue());
            counter++;
        }
        
        ManejadorArchivosGenerico.escribirArchivo("salida.csv", salida);
        // Mirar resultado en la carpeta madre, en un pdf basado en excel llamado "UT6_PD4_Salida.pdf"
        
    }
}
