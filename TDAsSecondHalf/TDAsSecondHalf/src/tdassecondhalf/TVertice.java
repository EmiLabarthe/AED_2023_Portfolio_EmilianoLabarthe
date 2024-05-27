package tdassecondhalf;


import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TVertice<T> implements IVertice {

    private final Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
    private int bacon = 0;

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    @Override
    public TVertice siguienteAdyacente(TVertice w) {
        TAdyacencia adyacente = buscarAdyacencia(w.getEtiqueta());
        int index = adyacentes.indexOf(adyacente);
        if (index + 1 < adyacentes.size()) {
            return adyacentes.get(index + 1).getDestino();
        }
        return null;
    }

    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }
    
    public void bpf(){
        this.setVisitado(true);
        System.out.println(this.etiqueta);
        for(TAdyacencia a : adyacentes){
            if(a.getDestino().getVisitado() == false){
                a.getDestino().bpf();
            }
        }
    }
    
    public void bpfWithoutPrint(){
        this.setVisitado(true);
        for(TAdyacencia a : adyacentes){
            if(a.getDestino().getVisitado() == false){
                a.getDestino().bpfWithoutPrint();
            }
        }
    }
    
    public void bea(Collection<TVertice> visitados) {
        TVertice vertice = this;
        Queue<TVertice> cola = new LinkedList<>();
        
        cola.add(vertice);
        visitados.add(vertice);
        vertice.setVisitado(true);
        System.out.println(this.getEtiqueta());
        
        while (!cola.isEmpty()) {            
            TVertice x = cola.remove();
            LinkedList<TAdyacencia> adyacentes = x.getAdyacentes();
            for (int i = 0; i < adyacentes.size(); i++) {
                TVertice v = adyacentes.get(i).getDestino();
                if (!v.getVisitado()) {
                    v.setVisitado(true);
                    cola.add(v);
                    visitados.add(v);
                    System.out.println(v.getEtiqueta());
                }
            }
        }    
    }

    /**
     *
     * @return
     */
    public T getDatos() {
        return datos;
    }
    
    public void setDatos(T dato){
        this.datos = dato;
    }
    
    public void dijkstra(Map<Comparable, TCamino> mapa) {
        visitado = true;
        for (Map.Entry<Comparable, TCamino> entry : mapa.entrySet()) {
            TAdyacencia ady = buscarAdyacencia(entry.getKey());
            if (ady != null) {
                double nuevoCosto = mapa.get(etiqueta).getCostoTotal() + ady.getCosto();
                if (nuevoCosto < mapa.get(entry.getKey()).getCostoTotal()) {
                    TCamino nuevoCamino = mapa.get(etiqueta).copiar();
                    nuevoCamino.agregarAdyacencia(ady);
                    nuevoCamino.setCostoTotal(nuevoCosto);
                    mapa.put(entry.getKey(), nuevoCamino);
                }
            }

        }
    }
    
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        this.setVisitado(true);
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    todosLosCaminos.getCaminos().add(copia);
                }else{
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    
                    destino.todosLosCaminos(etVertDest, copia, todosLosCaminos);
                    //COMPLETAR LLAMADA RECURSIVA
                }
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
    }
    
    public boolean tieneCiclos(TCamino caminoPrevio) {
        this.setVisitado(true);
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();
            if(destino.equals(caminoPrevio.getOrigen())){
                return true;
            }
            for(Comparable c : caminoPrevio.getOtrosVertices()){
                if(destino.getEtiqueta().equals(c)){
                    return true;
                }
            }
            if (!destino.getVisitado()) {
                TCamino copia = caminoPrevio.copiar();
                copia.agregarAdyacencia(adyacencia);
                return destino.tieneCiclos(copia);
            }
        }
        this.setVisitado(false);
        return false;
    }
    
    public boolean tieneCiclosNoDirigido(TCamino camino) {
        setVisitado(true);

        for (TAdyacencia adyacente : getAdyacentes()) {
            TVertice adyActual = adyacente.getDestino();
            if (!adyActual.getVisitado()) {
                TCamino aux = camino.copiar();
                aux.agregarAdyacencia(adyacente);
                if (adyActual.tieneCiclosNoDirigido(aux)) {
                    return true;
                }
                // longitud de camino >=3
            } else if (!camino.esPadre(etiqueta, adyActual.getEtiqueta())) {
                return true;
            }
        }

        return false;
    }
    
   
    public void clasificacionTopologica(){
        this.setVisitado(true);
        for(TAdyacencia a : adyacentes){
            if(!a.getDestino().getVisitado()){
                a.getDestino().clasificacionTopologica();
            }
        }
        System.out.println(this.getEtiqueta());
        
    }
    
    public void esConexo(){
        this.setVisitado(true);
        for(TAdyacencia a : adyacentes){
            if(a.getDestino().getVisitado() == false){
                a.getDestino().esConexo();
            }
        }
    }
    
    public void clasificarArcos(LinkedList<TArista> arcosArbol, LinkedList<TArista> arcosRetroceso, LinkedList<TArista> arcosAvance, LinkedList<TArista> arcosCruzados){
        this.setVisitado(true);
        LinkedList<TAdyacencia> adyacencias = new LinkedList<>();
        for(TAdyacencia a : adyacentes){
            try{
                arcosCruzados.add(new TArista(a.getEtiqueta(), adyacentes.get(adyacentes.indexOf(a) + 1).getEtiqueta(), 0));
            }catch(Exception e){
                
            }
            if(!a.getDestino().getVisitado()){
                arcosArbol.add(new TArista(this.getEtiqueta(), a.getEtiqueta(), 0));
                arcosAvance.add(new TArista(this.getEtiqueta(), a.getEtiqueta(), 0));
                a.getDestino().clasificarArcos(arcosArbol, arcosRetroceso, arcosAvance, arcosCruzados);
            }else{
                arcosArbol.add(new TArista(this.getEtiqueta(), a.getEtiqueta(), 0));
                arcosRetroceso.add(new TArista(this.getEtiqueta(), a.getEtiqueta(), 0));
            }
        }
    }
    
    public int bea_num;
    
    public int getNumBEA(){
        return bea_num;
    }
    
    public void setBEA(int num){
        this.bea_num = num;
    }
    
    public void obtenerVerticesANivel(LinkedList<TVertice> verts, int nivel) {
        this.visitado = true;
        this.bea_num = 0;
        LinkedList<TVertice> cola = new LinkedList<>();
        cola.addLast(this);
        while (!cola.isEmpty()) {
            TVertice x = cola.getLast();
            cola.removeLast();
            if (x.getNumBEA() == nivel) {
                verts.add(x);
                continue;
            }
            for (Object ad : x.getAdyacentes()) {
                TAdyacencia ady = (TAdyacencia) ad;
                TVertice y = ady.getDestino();
                if (!y.getVisitado()) {
                    y.setVisitado(true);
                    cola.addFirst(y);
                    y.setBEA(x.getNumBEA() + 1);
                }
            }
        }
    }

    public int obtenerNivelDeVertice(Comparable destino) {
        this.visitado = true;
        this.bea_num = 0;
        LinkedList<TVertice> cola = new LinkedList<>();
        cola.addLast(this);
        while (!cola.isEmpty()) {
            TVertice x = cola.getLast();
            cola.removeLast();
            if (x.getEtiqueta() == destino) {
                return x.bea_num;
            }
            for (Object ad : x.getAdyacentes()) {
                TAdyacencia ady = (TAdyacencia) ad;
                TVertice y = ady.getDestino();
                if (!y.getVisitado()) {
                    y.setVisitado(true);
                    cola.addFirst(y);
                    y.setBEA(x.getNumBEA() + 1);
                }
            }
        }
        return  -1;
    }
    
    public int numBacon(Comparable actor) {

        TVertice vertice = this;
        Queue<TVertice> cola = new LinkedList<>();

        cola.add(vertice);
        vertice.setBacon(0);
        vertice.setVisitado(true);
        while (!cola.isEmpty()) {
            vertice = cola.remove();
            if (vertice.getEtiqueta().equals(actor)) {
                return vertice.getBacon();
            }
            LinkedList<TAdyacencia> vertices = vertice.getAdyacentes();
            for (int i = 0; i < vertices.size(); i++) {
                TVertice y = vertices.get(i).getDestino();
                if (!y.getVisitado()) {
                    y.setVisitado(true);
                    cola.add(y);
                    int a = vertice.getBacon() + 1;
                    y.setBacon(a);
                }
            }
        }
        return -1;
    }
    
    public int getBacon() {
        return this.bacon;
    }

    public void setBacon(int newBacon) {
        this.bacon = newBacon;
    }
}
