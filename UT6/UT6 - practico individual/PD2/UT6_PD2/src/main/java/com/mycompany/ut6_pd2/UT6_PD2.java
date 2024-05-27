/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ut6_pd2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author emili
 */
public class UT6_PD2 {

    public static void main(String[] args) {
        
        String[] insertados = ManejadorArchivosGenerico.leerArchivo("src/claves_insertar.txt");
        String[] aBuscar = ManejadorArchivosGenerico.leerArchivo("src/claves_buscar.txt");
        
        LinkedList<Hash> hashes = new LinkedList<>();
        Hash hash70 = new Hash(286);
        Hash hash75 = new Hash(267);
        Hash hash80 = new Hash(250);
        Hash hash85 = new Hash(235);
        Hash hash90 = new Hash(222);
        Hash hash91 = new Hash(219);
        Hash hash92 = new Hash(217);
        Hash hash93 = new Hash(215);
        Hash hash94 = new Hash(212);
        Hash hash95 = new Hash(211);
        Hash hash96 = new Hash(208);
        Hash hash97 = new Hash(206);
        Hash hash98 = new Hash(204);
        Hash hash99 = new Hash(202);
        
        hashes.add(hash70);
        hashes.add(hash75);
        hashes.add(hash80);
        hashes.add(hash85);
        hashes.add(hash90);
        hashes.add(hash91);
        hashes.add(hash92);
        hashes.add(hash93);
        hashes.add(hash94);
        hashes.add(hash95);
        hashes.add(hash96);
        hashes.add(hash97);
        hashes.add(hash98);
        hashes.add(hash99);
        
        
        String[] salidaComparacionesInsertar = new String[15];
        String[] salidaComparacionesBuscarExitoso = new String[15];
        String[] salidaComparacionesBuscarFallido = new String[15];
        
        
        int r = 0;
        int sumaComparacionesInsertar = 0;
        LinkedList<Float> factoresCarga = new LinkedList<>();
        
        // Lleno las tablas con las cargas deseadas.
        for(Hash hashito : hashes){
            factoresCarga.add(((float) insertados.length / hashito.getSize()));
            for(String s : insertados){
                int comparations = hashito.insertar(Integer.parseInt(s));
                sumaComparacionesInsertar += comparations;
            }
            salidaComparacionesInsertar[r++] = Integer.toString((int) sumaComparacionesInsertar / insertados.length);
            sumaComparacionesInsertar = 0;
        }
        
        r = 0;
        int sumaComparacionesBuscarExitoso = 0;
        int sumaComparacionesBuscarFallido = 0;
        int comparadorBusqueda = 0;
        int busquedasExitosas = 0;
        int busquedasFallidas = 0;
        // Busco los elementos y sumo las comparaciones
        for(Hash hashito : hashes){
            System.out.println("Factor de carga: " + ((int) insertados.length / hashito.getSize()));
            for(String s : aBuscar){
                comparadorBusqueda = hashito.buscar(Integer.parseInt(s));
                if(comparadorBusqueda > 0){
                    sumaComparacionesBuscarExitoso += comparadorBusqueda;
                    busquedasExitosas ++;
                }if(comparadorBusqueda < 0){
                    comparadorBusqueda = -comparadorBusqueda;
                    sumaComparacionesBuscarFallido += comparadorBusqueda;
                    busquedasFallidas += 1;
                }    
            }
            salidaComparacionesBuscarExitoso[r] = Integer.toString((int) sumaComparacionesBuscarExitoso / busquedasExitosas);
            salidaComparacionesBuscarFallido[r] = Integer.toString((int) sumaComparacionesBuscarFallido / busquedasFallidas);
            busquedasFallidas = 0;
            busquedasExitosas = 0;
            sumaComparacionesBuscarFallido = 0;
            
            r ++;
        }
        
        String[] titulo = new String[1];
        titulo[0] = "Factor de carga,Promedio de comparaciones al insertar,Promedio de comparaciones al buscar exitoso,Promedio de comparaciones al buscar fallido";
        
        
        String[] salida = new String[14];
        int i = 0;
        while(i < 14){
            salida[i] = Float.toString(factoresCarga.get(i)) + "," + salidaComparacionesInsertar[i] + "," + salidaComparacionesBuscarExitoso[i] + "," + salidaComparacionesBuscarFallido[i];
            i++;
        }
        
        ManejadorArchivosGenerico.escribirArchivo("src/salida.csv", titulo);
        ManejadorArchivosGenerico.escribirArchivo("src/salida.csv", salida);
        // Salida excel en src/
    }
}

