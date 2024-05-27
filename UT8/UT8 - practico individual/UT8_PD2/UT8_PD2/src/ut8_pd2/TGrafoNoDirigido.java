package ut8_pd2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {

    public TAristas lasAristas;

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        this.lasAristas = new TAristas();
        this.lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        if(lasAristas == null){
            lasAristas = new TAristas();
        }
        boolean tempbool = false;
        lasAristas.add(arista);
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        lasAristas.add(arInv);
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }
    

    @Override
    public TGrafoNoDirigido Prim() {
        Collection<TVertice> Verts = this.getVertices().values();
        List<TVertice> V = new ArrayList<>(Verts);
        LinkedList<TArista> AAAM = new LinkedList<>();
        LinkedList<TVertice> U = new LinkedList<>();
        U.add(V.get(0));
        while(U.size() < V.size()){
            TArista menorArista = buscarMenorArista(U,V);
            AAAM.add(menorArista);
            U.add(buscarVertice(menorArista.getEtiquetaDestino()));
        }
        return new TGrafoNoDirigido(U, AAAM);
    }
    
    protected TArista buscarMenorArista(LinkedList<TVertice> U, List<TVertice> V){
        TArista minArista = null;
        double minCosto = Integer.MAX_VALUE;
        TAristas aristas = this.getLasAristas();
        for(TVertice u : U){
            for(TVertice v : V){
                if(!U.contains(v)){
                    TArista tempArista = aristas.buscar(u.getEtiqueta(), v.getEtiqueta());
                    if(tempArista != null){
                        if(tempArista.getCosto() < minCosto && tempArista.getCosto() > 0){
                            minArista = tempArista;
                            minCosto = tempArista.getCosto();
                        }
                    }
                }
                
            }
        }
        return minArista;
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        TGrafoNoDirigido T = vaciarAristas();
        lasAristas.ordenarPorCosto();
        
        for(TArista arista : lasAristas){
            TVertice origen= T.getVertices().get(arista.getEtiquetaOrigen());
            TVertice destino= T.getVertices().get(arista.getEtiquetaDestino());
            if(!T.existeItinerario(origen.getEtiqueta(), destino.getEtiqueta())){
                T.insertarArista(arista);
            }
        }
        return T;
    }
    
    private TGrafoNoDirigido vaciarAristas(){
        Collection<TVertice> vertices= new LinkedList<>();
        for(TVertice v : getVertices().values()){
            TVertice vert = new TVertice(v.getEtiqueta());
            vert.setDatos(v.getDatos());
            vertices.add(vert);
        }
        return new TGrafoNoDirigido(vertices, new TAristas());
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        this.desvisitarVertices();
        TVertice vertice = this.getVertices().get(etiquetaOrigen);
        Collection<TVertice> visitados = new LinkedList<>();
        if (vertice != null) {
            vertice.bea(visitados);
        }
        return visitados;

    }
 
    @Override
    public Collection<TVertice> bea() {
        this.desvisitarVertices();
        Collection<TVertice> visitados = new LinkedList<>();
        if(getVertices().isEmpty()){
            return visitados;
        }else{
            Collection<TVertice> verticesCollection = getVertices().values();
            ArrayList<TVertice> vertices = new ArrayList<>(verticesCollection);
            vertices.get(0).bea(visitados);
        }
        return visitados;   
    }
    

    @Override
    public boolean esConexo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LinkedList<TVertice> puntosArticulacion(Comparable etOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}