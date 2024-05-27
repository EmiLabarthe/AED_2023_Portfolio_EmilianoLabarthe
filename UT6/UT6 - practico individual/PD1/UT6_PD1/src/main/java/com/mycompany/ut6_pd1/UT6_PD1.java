/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ut6_pd1;

/**
 *
 * @author emili
 */
public class UT6_PD1 {
    
    private static final int REPETICIONES = 100;

    public static void main(String[] args){
        IArbolTrie trieMap = new TArbolTrieMap();
        IArbolTrie trieASCII = new TArbolTrieASCII();
        
        
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src/palabras1.txt");
        String[] palabrasBuscar = ManejadorArchivosGenerico.leerArchivo("src/palabrasBuscar.txt");
        
        for (String p : palabrasclave) {
                trieMap.insertar(p);
                trieASCII.insertar(p);
        }
        
        Medible[] medibles = new Medible[2];
        int i = 0;
        medibles[i++] = new MedicionBuscarTrie(trieMap);
        medibles[i++] = new MedicionBuscarTrie(trieASCII);
        Medicion mi;
        i = 0;
        Object[] params = {REPETICIONES, palabrasBuscar};
        String[] lineas = new String[3];
        lineas[i++] = "implementación,tiempo,memoria";
        for(Medible m : medibles){
            mi = m.medir(params);
            mi.print();
            lineas[i++] = mi.getTexto() + "," + mi.getTiempoEjecucion().toString() + "," + mi.getMemoria().toString();
        }
        ManejadorArchivosGenerico.escribirArchivo("./src/salida.csv", lineas);
        // Salida en formato Excel en /src
        
    }
}
