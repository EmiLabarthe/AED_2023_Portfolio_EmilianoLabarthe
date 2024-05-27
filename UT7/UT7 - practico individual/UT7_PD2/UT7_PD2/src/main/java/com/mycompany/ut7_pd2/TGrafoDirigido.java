package com.mycompany.ut7_pd2;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, TVertice> vertices; // vertices del grafo.-

    public TGrafoDirigido(){
        this.vertices = new HashMap<>();
    }
    
    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     */
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override

    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    /**
     * @return the vertices
     */
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Comparable centroDelGrafo() {
        Collection<TVertice> verticesCollection = this.vertices.values();
        ArrayList<TVertice> vertices = new ArrayList<>();
        for (TVertice i : verticesCollection) {
            vertices.add(i);
        }
        Double[][] matriz = this.floyd();
        Double[] excentricidad = new Double[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            excentricidad[i] = Double.MIN_VALUE;
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > excentricidad[i] && matriz[i][j] != Double.MAX_VALUE) {
                    excentricidad[i] = matriz[i][j];
                }
            }
        }
        Double minExcentricidad = Double.MAX_VALUE;
        TVertice centro = null;
        for (int i = 0; i < excentricidad.length; i++) {
            if (excentricidad[i] < minExcentricidad && excentricidad[i] != 0) {
                minExcentricidad = excentricidad[i];
                centro = vertices.get(i);
            }
        }
        return (centro == null) ? null : centro.getEtiqueta();
    }

    @Override
    public Double[][] floyd() {
        Collection<TVertice> verticesCollection = this.vertices.values();
        ArrayList<TVertice> vertices = new ArrayList<>();
        for (TVertice i : verticesCollection) {
            vertices.add(i);
        }
        int n = getVertices().size();
        Double[][] A = new Double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = vertices.get(i).obtenerCostoAdyacencia(vertices.get(j));
            }
        }
        for (int i = 0; i < n; i++) {
            A[i][i] = (double) 0;
        }
        for (int k = 1; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (A[i][k] != Double.MAX_VALUE && i != k) {
                    for (int j = 0; j < n; j++) {
                        Double res = A[i][k] + A[k][j];
                        if (res < A[i][j]) {
                            A[i][j] = res;
                        }
                    }
                }
            }
        }
        return A;
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        Double[][] matriz = this.floyd();
        Double[] excentricidad = new Double[matriz.length];

        int indiceVertice = new LinkedList(vertices.keySet()).indexOf(etiquetaVertice);
        if (indiceVertice == -1) {
            return null;
        }
        for (int i = 0; i < excentricidad.length; i++) {
            excentricidad[i] = 0.0;

        }
        for (int i = 0; i < matriz[indiceVertice].length; i++) {
            if (matriz[i][indiceVertice] > excentricidad[indiceVertice]) {
                excentricidad[indiceVertice] = matriz[i][indiceVertice];
            }
        }

        if(excentricidad[indiceVertice] == Double.MAX_VALUE){
            return -1;
        }
        return excentricidad[indiceVertice];
    }

    @Override
    public boolean[][] warshall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarVertice(Comparable nombreVertice
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
