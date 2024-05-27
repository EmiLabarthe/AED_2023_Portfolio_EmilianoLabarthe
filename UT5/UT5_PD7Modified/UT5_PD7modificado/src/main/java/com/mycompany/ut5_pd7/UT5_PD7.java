package com.mycompany.ut5_pd7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class UT5_PD7 {

    /**
     * @param args
     */
    public static void main(String[] args){
        
        //EJERCICIO 1
        TArbolTrieTelefonos trieAbonados = new TArbolTrieTelefonos();
        
        // CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT
        String[] entrada = ManejadorArchivosGenerico.leerArchivo("abonados.txt");
        for( String s : entrada ){
            String[] datos = s.split(",");
            TAbonado abonado = new TAbonado(datos[1], datos[0], Integer.parseInt(datos[2]),Integer.parseInt(datos[3]), Integer.parseInt(datos[3]));
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
        ManejadorArchivosGenerico.escribirArchivo("salidaEj1.txt", abonadosSalida.toArray(salida));  
        
        
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        // EJERCICIO 2
        
        //Armo tries y listas por fecha o país. En este caso los 3 países cuyos prefijos
        //están en el archivo de lectura y fecha desde febrero.
        LinkedList<TAbonado> argentina = new LinkedList<>();
        TArbolTrieTelefonos ventasArgentina = trieAbonados.todasLasVentasPais("054", argentina);
        LinkedList<TAbonado> argentinaDesdeFebrero = trieAbonados.ventasDesdeFechaPais(2023, 2, 1, "054");
        
        LinkedList<TAbonado> uruguay = new LinkedList<>();
        TArbolTrieTelefonos ventasUruguay = trieAbonados.todasLasVentasPais("598", uruguay);
        LinkedList<TAbonado> uruguayDesdeFebrero = trieAbonados.ventasDesdeFechaPais(2023, 2, 1, "598");
        
        LinkedList<TAbonado> martinica = new LinkedList<>();
        TArbolTrieTelefonos ventasMartinica = trieAbonados.todasLasVentasPais("596", martinica);
        LinkedList<TAbonado> martinicaDesdeFebrero = trieAbonados.ventasDesdeFechaPais(2023, 2, 1, "596");
        
        
        //Armo salida con datos recopilados de ventas desde la fecha febrero
        String[] titulo = new String[1];
        titulo[0] = "Pais,Ventas desde Febrero,Porcentaje sobre las ventas totales";
        String[] salidaEj2 = new String[3];
        int i = 0;
        salidaEj2[i++] = "Argentina," + Integer.toString(argentinaDesdeFebrero.size()) + "," + (((float)argentinaDesdeFebrero.size() / ventasArgentina.getCantidadTelefonos()) * 100 + "%");
        salidaEj2[i++] = "Uruguay," + Integer.toString(uruguayDesdeFebrero.size()) + "," + (((float) uruguayDesdeFebrero.size() / ventasUruguay.getCantidadTelefonos()) * 100 + "%");
        salidaEj2[i++] = "Martinica," + Integer.toString(martinicaDesdeFebrero.size()) + "," + (((float) martinicaDesdeFebrero.size() / ventasMartinica.getCantidadTelefonos()) * 100 + "%");
        ManejadorArchivosGenerico.escribirArchivo("salidaEj2.csv", titulo);
        ManejadorArchivosGenerico.escribirArchivo("salidaEj2.csv", salidaEj2);
        
        
        // Salida total de ventas en cada país.
        String[] titulo2 = new String[1];
        titulo2[0] = "Pais,Ventas totales";
        String[] salidaEj2B = new String[3];
        i = 0;
        salidaEj2B[i++] = "Argentina," + trieAbonados.getMapTriesPaises().get("Argentina").getCantidadTelefonos();
        salidaEj2B[i++] = "Uruguay," + trieAbonados.getMapTriesPaises().get("Uruguay").getCantidadTelefonos();
        salidaEj2B[i++] = "Martinica," + trieAbonados.getMapTriesPaises().get("Martinica").getCantidadTelefonos();
        ManejadorArchivosGenerico.escribirArchivo("salidaEj2B.csv", titulo2);
        ManejadorArchivosGenerico.escribirArchivo("salidaEj2B.csv", salidaEj2B);
        
    }
    
}