/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ut7_pd5;

/**
 *
 * @author emili
 */
public class UT7_PD5 {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("destinosPaseo.txt","paradasPaseo.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        Double[][] mfloyd = gd.floyd();
        
        
        // Funcionalidad de si tiene ciclos
        System.out.println(gd.tieneCiclos());
        
        // Clasificación topológica
        gd.desvisitar();
        gd.clasificacionTopologica();
        
        // esConexo?
        gd.desvisitar();
        System.out.println(gd.esConexo());
        
        // Lo forzamos a no ser conexo, por si el anterior fue "true"
        gd.desvisitar();
        gd.insertarVertice("Chuy");
        System.out.println(gd.esConexo());
        
        // Hallar todos los componentes fuertes y crear un grafo conexo en base a cada uno
        
    }
}
