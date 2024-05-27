/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ut7_pd8;

import java.util.LinkedList;

/**
 *
 * @author emili
 */
public class UT7_PD8 {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("pruebaArcosV.txt","pruebaArcosA.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        Double[][] mfloyd = gd.floyd();
        
        LinkedList<TArista> arcosArbol = new LinkedList<>();
        LinkedList<TArista> arcosRetroceso = new LinkedList<>();
        LinkedList<TArista> arcosAvance = new LinkedList<>();
        LinkedList<TArista> arcosCruzados = new LinkedList<>();
        
        
        
        // DIBUJO DEL GRAFO DE PRUEBA EN FOTO EN SRC/
        gd.desvisitar();
        gd.clasificarArcos("A", arcosArbol, arcosRetroceso, arcosAvance, arcosCruzados);
        
        System.out.println("Arcos Arbol: ");
        for(TArista a : arcosArbol){
            System.out.println(a.getEtiquetaOrigen() + " -> " + a.getEtiquetaDestino());
        }
        
        System.out.println("Arcos Retroceso: ");
        for(TArista a : arcosRetroceso){
            System.out.println(a.getEtiquetaOrigen() + " -> " + a.getEtiquetaDestino());
        }
        
        System.out.println("Arcos Avance: ");
        for(TArista a : arcosAvance){
            System.out.println(a.getEtiquetaOrigen() + " -> " + a.getEtiquetaDestino());
        }
        
        System.out.println("Arcos Cruzados: ");
        for(TArista a : arcosCruzados){
            System.out.println(a.getEtiquetaOrigen() + " -> " + a.getEtiquetaDestino());
        }
    }
}
