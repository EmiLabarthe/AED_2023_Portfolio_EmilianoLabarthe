package ut8_pd2;


import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class TVertice<T> implements IVertice {

    private final Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;

    public Comparable getEtiqueta() {
        return etiqueta;
    }
    
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
   
    
    
    
    @Override
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
    
    public void bpfWithoutPrint(){
        this.setVisitado(true);
        for(TAdyacencia a : adyacentes){
            if(a.getDestino().getVisitado() == false){
                a.getDestino().bpfWithoutPrint();
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
    
    /*
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
    }*/

    @Override
    public void bpf(Collection<TVertice> visitados) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean conectadoCon(TVertice destino) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean tieneCiclo(LinkedList<Comparable> camino) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
