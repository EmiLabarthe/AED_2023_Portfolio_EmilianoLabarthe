/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ut8_pd2;

/**
 *
 * @author emili
 */
public class UT8_PD2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TGrafoNoDirigido gnd = UtilGrafos.cargarGrafo("verticesBEA.txt", "aristasBEA.txt", false, TGrafoNoDirigido.class);
        
        TGrafoNoDirigido gndAfterPrim = gnd.Prim();
        for(TArista a : gndAfterPrim.getLasAristas()){
           System.out.println(a.getEtiquetaOrigen() + "->" + a.getEtiquetaDestino()); 
        }
        
        System.out.println("-------------------------------------------");
        
        TGrafoNoDirigido gndAfterKruskal = gnd.Kruskal();
        for(TArista a : gndAfterKruskal.getLasAristas()){
           System.out.println(a.getEtiquetaOrigen() + "->" + a.getEtiquetaDestino()); 
        }
        
    }
    
}
