/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pd3codes;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author emili
 */
public class PD3codes {

    public static void main(String[] args) {
        ejercicio3();
    }
    
    public static void ejercicio1(Map map){
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            if(entry.getValue() == null){
                map.remove(entry.getKey());
            }
        }
    }
    
    public static Map<String, String> ejercicio2(Map<String, String> map){
        Map<String, String> invertedMap = new HashMap<>();
        
        for (Map.Entry<String, String> entry : map.entrySet()) {
            invertedMap.put(entry.getValue(), entry.getKey());
        }
        return invertedMap;
    }
    
    public static void ejercicio3(){
        LinkedList<String> words = new LinkedList<String>();
        Scanner scanner = new Scanner(System.in);
        String word = "";
        while(true){
            System.out.println("Ingrese una palabra: ");
            word = scanner.nextLine();
            if(word.equals("exit")){
                break;
            }
            words.add(word);
        }
        Collections.sort(words, new StringComparator());
        System.out.println(words);
    }
    
    private static class StringComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
    }
    
}
