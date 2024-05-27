/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ut7_pd3;


/**
 *
 * @author emili
 */
public class UT7_PD3 {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/aeropuertos.txt","./src/conexiones.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
        Double[][] mfloyd = gd.floyd();
        UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");
        for (int i = 0; i < etiquetasarray.length; i++) {
            System.out.println("excentricidad de " + etiquetasarray[i] + " : " + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
        }
        System.out.println();
        System.out.println("Centro del grafo: " + gd.centroDelGrafo());
    
        System.out.println("-----------------------------------");
        // Impresión DFS
        gd.desvisitar();
        gd.bpf();
        System.out.println("-----------------------------------");
        // DFS desde MVD
        gd.desvisitar();
        gd.bpfDesde("Montevideo");
        System.out.println("-----------------------------------");
        
        //Existe itinerario?
        gd.desvisitar();
        System.out.println(gd.existeItinerario("Montevideo", "Curitiba"));
        System.out.println(gd.existeItinerario("Porto_Alegre", "Santos"));
        System.out.println("-----------------------------------");
        
        // Itinerarios desde Montevideo a Rio de Janeiro
        gd.desvisitar();
        TCaminos caminos = gd.todosLosCaminos("Montevideo", "Rio_de_Janeiro");
        caminos.imprimirCaminosConsola();
    }
}
