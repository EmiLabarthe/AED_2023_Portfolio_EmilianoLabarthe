    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ut7_pd4project;

/**
 *
 * @author emili
 */
public class UT7_PD4project {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("aeropuertos_2.txt","conexiones_2.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        Double[][] mfloyd = gd.floyd();
        
        TCaminos caminos = gd.todosLosCaminos("Asuncion", "Montevideo");
        caminos.imprimirCaminosConsola();
    }
}
