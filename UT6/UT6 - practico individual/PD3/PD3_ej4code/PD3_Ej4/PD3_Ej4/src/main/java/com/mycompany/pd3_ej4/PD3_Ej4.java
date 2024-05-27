/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pd3_ej4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Emiliano
 */
public class PD3_Ej4 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        //Guardo las entradas
        String archivox = args[0];
        int linesToPrint = Integer.parseInt(args[1]);
        
        
        //Calculo el total de lineas
        File archivo = new File(archivox);
        long tamanioArchivo = archivo.length();
        int lineaPromedio = 50; // Supongamos que una línea son 100 char, osea 100 bytes
        int totalLineas = (int) (tamanioArchivo / lineaPromedio);
        
        // Voy guardando las lineas en mi array del largo dado previamente
        int contador = 0;
        String[] lineas = new String[totalLineas];
        try (BufferedReader reader2 = new BufferedReader(new FileReader(archivox))) {
            String lineaActual = reader2.readLine();
            while(contador < totalLineas){
                lineas[contador] = lineaActual;
                contador ++;   
                lineaActual = reader2.readLine();
            }
        }
        
        // Imprimo aleatoriamente
        Random random = new Random();
        int counter = 0;
        while(counter < linesToPrint){
            int numeroAleatorio = random.nextInt(totalLineas);
            System.out.println(lineas[numeroAleatorio]);
            counter ++;
        }
    }
}
