/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ut3_pd9;


/**
 *
 * @author emili
 */
public class UT3_PD9 {

    public static void main(String[] args) {
        String corchetesCadena = "{}{{}}";
        char[] corchetesArray = corchetesCadena.toCharArray();
        String corchetesCadena2 = "{}}{{}}{";
        char[] corchetesArray2 = corchetesCadena2.toCharArray();
        String corchetesCadena3 = "{}}{{}}}";
        char[] corchetesArray3 = corchetesCadena3.toCharArray();
        
        System.out.println(Expresion.verificador(corchetesArray));
        System.out.println(Expresion.verificador(corchetesArray2));
        System.out.println(Expresion.verificador(corchetesArray3));
    }
}
