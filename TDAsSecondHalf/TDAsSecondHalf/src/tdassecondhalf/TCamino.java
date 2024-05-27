package tdassecondhalf;


import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author diego
 */
public class TCamino implements ICamino {

    private final TVertice origen;
    private Collection<Comparable> otrosVertices;
// es una lista de etiquetas de los vertices
// ATENCIÓN: PONER LA CLASE CONCRETA QUE									     	     
// SEA MÁS APROPIADA
    private Double costoTotal = 0.0d;

    public void imprimirEtiquetasConsola() {
        System.out.println(imprimirEtiquetas());
    }

    public TCamino(TVertice v) {
        this.origen = v;
        this.otrosVertices = new LinkedList();

    }

    @Override
    public boolean agregarAdyacencia(TAdyacencia adyacenciaActual) {
        if (adyacenciaActual.getDestino() != null) {
            costoTotal = costoTotal + adyacenciaActual.getCosto();
            return getOtrosVertices().add(adyacenciaActual.getDestino().getEtiqueta());
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(TAdyacencia adyacenciaActual) {
        if (getOtrosVertices().contains(adyacenciaActual.getDestino().getEtiqueta())) {
            costoTotal = costoTotal - adyacenciaActual.getCosto();
            return getOtrosVertices().remove(adyacenciaActual.getDestino().getEtiqueta());
        }
        return false;
    }

    public TVertice getOrigen() {
        return origen;
    }
    
    public Comparable getUltimo(){
        LinkedList<Comparable> verts = new LinkedList<>(otrosVertices);
        return verts.getLast();
    }

    public Collection<Comparable> getOtrosVertices() {
        return otrosVertices;
    }

    public void setOtrosVertices(Collection<Comparable> otrosVertices) {
        this.otrosVertices = otrosVertices;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public TCamino copiar() {
        TVertice origen = new TVertice(this.getOrigen().getEtiqueta());
        TCamino copia = new TCamino(origen);
        origen.getAdyacentes().addAll(this.getOrigen().getAdyacentes());
        copia.getOtrosVertices().addAll(this.getOtrosVertices());
        copia.setCostoTotal(this.costoTotal);
        return copia;
    }

    @Override
    public String imprimirEtiquetas() {
        StringBuilder str = new StringBuilder();
        str.append(origen.getEtiqueta());
        for(Comparable et : otrosVertices){
            str.append(" -> ");
            str.append(et);   
        }
        str.append("\nCosto: " + getCostoTotal());
        return str.toString();
    }

    public Comparable obtenerPadre(Comparable hijo) {
        if (otrosVertices.contains(hijo)) {
            Iterator<Comparable> iterator = otrosVertices.iterator();
            Comparable actual = origen.getEtiqueta();
            while (iterator.hasNext()) {
                Comparable siguiente = iterator.next();
                if (siguiente.equals(hijo)) {
                    return actual;
                }
                actual = siguiente;
            }
        }
        return null;
    }
    
    public boolean esPadre(Comparable hijo, Comparable padre) {
        Comparable padreActual = obtenerPadre(hijo);
        if(padreActual!=null){
            return padreActual.compareTo(padre) == 0;
        }
        return false;
    }
}
