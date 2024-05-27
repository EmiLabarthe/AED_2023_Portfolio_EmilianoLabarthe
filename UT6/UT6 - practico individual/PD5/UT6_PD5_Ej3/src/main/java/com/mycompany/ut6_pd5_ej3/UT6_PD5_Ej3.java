/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ut6_pd5_ej3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author emili
 */
public class UT6_PD5_Ej3 {

    public static void main(String[] args) {
        TTrieHashMap trieAbonados = new TTrieHashMap();

       // CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT
        
       String[] entrada = ManejadorArchivosGenerico.leerArchivo("abonados.txt");
       for( String s : entrada ){
           String[] datos = s.split(",");
           TAbonado abonado = new TAbonado(datos[1], datos[0]);
           trieAbonados.insertar(abonado);
       }
        
        String codigoPais = "598" ; // utilizar el indicado en el archivo "codigos.txt"
        String codigoArea = "93" ;// utilizar el indicado en el archivo "codigos.txt"
        LinkedList<TAbonado> ab = trieAbonados.buscarTelefonos(codigoPais, codigoArea);
        
        
        // crear el archivo "salida.txt", con los abonados (1 por linea)
        // correspondientes al pais y area 
        // imprimir Nombre y teléfono, 
        // ordenados alfabeticamente por nombre
        
        ArrayList<String> abonadosSalida = new ArrayList<>();
        for(TAbonado abonado : ab){
            abonadosSalida.add(abonado.getNombre() + ", " + abonado.getTelefono());
        }
        Collections.sort(abonadosSalida, (String a1, String a2) -> a1.compareTo(a2));
        String[] salida = new String[abonadosSalida.size()];
        ManejadorArchivosGenerico.escribirArchivo("salida.txt", abonadosSalida.toArray(salida));
    }
}
