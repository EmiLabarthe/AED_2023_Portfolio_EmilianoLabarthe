public class Nodo implements INodo{

    public Object Dato;
    public Comparable Etiqueta;
    public INodo Siguiente;

    public Nodo(Comparable etiqueta, Object dato){
        this.Dato = dato;
        this.Etiqueta = etiqueta;
    }

    @Override
    public Object getDato() {
        return Dato;
    }

    @Override
    public INodo getSiguiente() {
        return this.Siguiente;
    }

    @Override
    public void setSiguiente(INodo nodo) {
        this.Siguiente = nodo;
    }

    @Override
    public void imprimir() {
        System.out.println(this.Dato);
    }

    @Override
    public void imprimirEtiqueta() {

    }

    @Override
    public Comparable getEtiqueta() {
        return this.Etiqueta;
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return 0;
    }
}
