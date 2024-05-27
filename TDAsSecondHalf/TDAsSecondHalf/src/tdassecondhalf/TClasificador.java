package tdassecondhalf;


import java.util.Arrays;


public class TClasificador {

    public static final int METODO_CLASIFICACION_INSERCION = 1;
    public static final int METODO_CLASIFICACION_SHELL = 2;
    public static final int METODO_CLASIFICACION_BURBUJA = 3;
    public static final int METODO_HEAPSORT = 4;

    /**
     * Punto de entrada al clasificador
     *
     * @param metodoClasificacion
     * @param orden
     * @param tamanioVector
     * @return Un vector del tam. solicitado, ordenado por el algoritmo
     * solicitado
     */
    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
        switch (metodoClasificacion) {
            case METODO_CLASIFICACION_INSERCION:
                return ordenarPorInsercion(datosParaClasificar);
            case METODO_CLASIFICACION_SHELL:
                return ordenarPorShell(datosParaClasificar);
            case METODO_CLASIFICACION_BURBUJA:
                return ordenarPorBurbuja(datosParaClasificar);
            case METODO_HEAPSORT:
                return ordenarPorHeapSort(datosParaClasificar);
            default:
                System.err.println("Este codigo no deberia haberse ejecutado");
                break;
        }
        return datosParaClasificar;
    }

    private void intercambiar(int[] vector, int pos1, int pos2) {
        int temp = vector[pos2];
        vector[pos2] = vector[pos1];
        vector[pos1] = temp;
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    private int[] ordenarPorShell(int[] datosParaClasificar) {
        int j, inc;
        int[] incrementos = new int[]{3223, 358, 51, 10, 3, 1};
        if (datosParaClasificar != null) {

            for (int posIncrementoActual = 0; posIncrementoActual < incrementos.length; posIncrementoActual++) {
                inc = incrementos[posIncrementoActual];
                if (inc < (datosParaClasificar.length / 2)) {
                    for (int i = inc; i < datosParaClasificar.length; i++) {
                        j = i - inc;
                        while (j >= 0) {
                            if (datosParaClasificar[j] > datosParaClasificar[j + inc]) {
                                intercambiar(datosParaClasificar, j, j + inc);

                            }
                            j = j -inc;
                        }
                    }
                }
            }
        }
        return datosParaClasificar;
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    protected int[] ordenarPorInsercion(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            for (int i = 1; i < datosParaClasificar.length; i++) {
                int j = i - 1;
                while ((j >= 0) && (datosParaClasificar[j + 1] < datosParaClasificar[j])) {
                    intercambiar(datosParaClasificar, j, j + 1);
                    j--;
                }
            }
            return datosParaClasificar;
        }
        return null;
    }

    private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            int n = datosParaClasificar.length - 1;
            for (int i = 0; i <= n; i++) {
                for (int j = n; j >= (i + 1); j--) {
                    if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                        intercambiar(datosParaClasificar, j - 1, j);
                    }
                }
            }
        }
        return datosParaClasificar;
    }

    public static boolean estaOrdenado(int[] vectorOrdenado) {
        for (int i = 1; i < vectorOrdenado.length; i++) {
            if (vectorOrdenado[i - 1] > vectorOrdenado[i]) {
                return false;
            }
        }
        return true;
    }
    
    protected int[] ordenarPorHeapSort(int[] datosParaClasificar) {
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
            armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1);
        }
        for (int i = datosParaClasificar.length - 1; i > 0; i--) { // cambiamos de i>1 a i>0
            intercambiar(datosParaClasificar, 0, i);
            armaHeap(datosParaClasificar, 0, i - 1);
        }
        return datosParaClasificar;
    }

    private void armaHeap(int[] datosParaClasificar, int primero, int ultimo) {
        if (primero < ultimo) {
            int indiceActual = primero;
            while (indiceActual <= ultimo / 2) {
                if (ultimo == 2 * indiceActual) { // indiceActual tiene un hijo solo
                    if (datosParaClasificar[indiceActual] < datosParaClasificar[indiceActual * 2]) { // cambiamos de < a >
                        intercambiar(datosParaClasificar, indiceActual, 2 * indiceActual);
                        // indiceActual = 2;
                    } //else {
                    indiceActual = ultimo;
                    //}

                } else { // indiceActual tiene 2 hijos
                    int posicionIntercambio = 0;
                    if (datosParaClasificar[2 * indiceActual] < datosParaClasificar[2 * indiceActual + 1]) {
                        posicionIntercambio = 2 * indiceActual + 1;
                    } else {
                        posicionIntercambio = 2 * indiceActual;
                    }
                    if (datosParaClasificar[indiceActual] < datosParaClasificar[posicionIntercambio]) { // cambiamos de < a >
                        intercambiar(datosParaClasificar, indiceActual, posicionIntercambio);
                        indiceActual = posicionIntercambio;
                    } else {
                        indiceActual = ultimo;
                    }
                }
            }
        }
    }


    public static void main(String args[]) {
        TClasificador clasif = new TClasificador();
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
        int[] vector = {3, 6, 2, 7};
        int[] vectorAleatorio = gdg.generarDatosAleatorios();
        int[] vectorAscendente = gdg.generarDatosAscendentes();
        int[] vectorDescendente = gdg.generarDatosDescendentes();

        int[] resAleatorio = clasif.clasificar(vectorAleatorio,
                METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resAleatorio.length; i++) {
            System.out.print(resAleatorio[i] + " ");
        }
        System.out.println("");
        int[] resAscendente = clasif.clasificar(vectorAscendente,
                METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resAscendente.length; i++) {
            System.out.print(resAscendente[i] + " ");
        }
        System.out.println("");
        int[] resDescendente = clasif.clasificar(vectorDescendente,
                METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resDescendente.length; i++) {
            System.out.print(resDescendente[i] + " ");
        }
        System.out.println("");
        int[] resVector = clasif.clasificar(vector,
                METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resVector.length; i++) {
            System.out.print(resVector[i] + " ");
        }
        System.out.println(estaOrdenado(resVector));
        
        System.out.println("----------------------------------");
        int[] aleatorios = gdg.generarDatosAleatorios();
        aleatorios = clasif.clasificar(aleatorios, METODO_HEAPSORT);
        System.out.println(Arrays.toString(aleatorios));
        System.out.println(estaOrdenado(aleatorios));
        
    }
}
