/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ut7_pd2;

/**
 *
 * @author emili
 */
public class UT7_PD2 {

    public static void main(String[] args) {
        TGrafoDirigido grafo = new TGrafoDirigido();
        
        grafo.insertarVertice("Artigas");
        grafo.insertarVertice("Canelones");
        grafo.insertarVertice("Colonia");
        grafo.insertarVertice("Durazno");
        grafo.insertarVertice("Florida");
        grafo.insertarVertice("Montevideo");
        grafo.insertarVertice("PuntaDelEste");
        grafo.insertarVertice("Rocha");
        
        TArista arista = new TArista("Artigas", "Rocha", 400);
        grafo.insertarArista(arista);
        TArista arista2 = new TArista("Canelones", "Artigas", 500);
        grafo.insertarArista(arista2);
        TArista arista3 = new TArista("Canelones", "Colonia", 200);
        grafo.insertarArista(arista3);
        TArista arista4 = new TArista("Canelones", "Durazno", 170);
        grafo.insertarArista(arista4);
        TArista arista5 = new TArista("Canelones", "PuntaDelEste", 90);
        grafo.insertarArista(arista5);
        TArista arista6 = new TArista("Colonia", "Montevideo", 180);
        grafo.insertarArista(arista6);
        TArista arista7 = new TArista("Florida", "Durazno", 60);
        grafo.insertarArista(arista7);
        TArista arista8 = new TArista("Montevideo", "Artigas", 700);
        grafo.insertarArista(arista8);
        TArista arista9 = new TArista("Montevideo", "Canelones", 30);
        grafo.insertarArista(arista9);
        TArista arista10 = new TArista("Montevideo", "PuntaDelEste", 130);
        grafo.insertarArista(arista10);
        TArista arista11 = new TArista("PuntaDelEste", "Rocha", 90);
        grafo.insertarArista(arista11);
        TArista arista12= new TArista("Rocha", "Montevideo", 270);
        grafo.insertarArista(arista12);
        TArista arista13 = new TArista("Florida", "Durazno", 30);
        grafo.insertarArista(arista13);
        
        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(grafo.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, grafo.getVertices(), "Original");
        
        //Ejercicio 2
        Double[][] afterFloyd = grafo.floyd();
        UtilGrafos.imprimirMatrizMejorado(afterFloyd, grafo.getVertices(), "Floyd");
        
        //Ejercicio 3
        System.out.println(grafo.obtenerExcentricidad("Montevideo"));
        System.out.println(grafo.centroDelGrafo());
        
    }
}
