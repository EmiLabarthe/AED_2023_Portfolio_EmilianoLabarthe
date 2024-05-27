
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // cargar grafo con casas y distancias
        TGrafoRedElectrica laRed =  (TGrafoRedElectrica) UtilGrafos.cargarGrafo(
                "src/barrio.txt",
                "src/distancias.txt",
                false, TGrafoRedElectrica.class);
       
        int costoTotal = 0;
        ArrayList<String> lineas = new ArrayList<>();
        TAristas redOptima = laRed.mejorRedElectrica();
        for(TArista a : redOptima){
            lineas.add(a.getEtiquetaOrigen() + " -> " + a.getEtiquetaDestino());
            costoTotal += a.getCosto();
        }
        lineas.add("Costo total: " + costoTotal);
        
        ManejadorArchivosGenerico.escribirArchivo("redElectrica.txt", lineas.toArray(new String[lineas.size()]));
        
        /*
         
        calcular la mejor red electrica\
        listar en el archivo "redelectrica.txt" el costo total del cableado
        y las conexiones establecidas, una por linea (origen, destino, costo)
        
        */
    }
}
