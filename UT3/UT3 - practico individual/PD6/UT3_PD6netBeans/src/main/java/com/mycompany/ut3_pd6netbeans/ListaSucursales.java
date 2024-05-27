
package com.mycompany.ut3_pd6netbeans;

public class ListaSucursales implements ILista {
    public INodo Cabeza;

    @Override
    public void insertar(INodo nodo) {
        if(this.Cabeza == null){
            this.Cabeza = nodo;
        }
        else{
            INodo nodoActual = Cabeza;
            while (nodoActual.getSiguiente() != null){
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nodo);
        }
    }

    @Override
    public void insertar(Comparable etiqueta, Object dato) {
        NodoSucursal nodo = new NodoSucursal(etiqueta, dato);
        this.insertar(nodo);
    }

    @Override
    public INodo buscar(Comparable clave) {
        INodo nodoActual = Cabeza;
        while(nodoActual != null){
            if(nodoActual.getEtiqueta().equals(clave)){
                return nodoActual;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        INodo nodoActual = Cabeza;
        if(nodoActual.getEtiqueta().equals(clave)){
            this.Cabeza = nodoActual.getSiguiente();
            return true;
        }
        while (nodoActual.getSiguiente() != null){
            if(nodoActual.getSiguiente().getEtiqueta().equals(clave)){
                nodoActual.setSiguiente(nodoActual.getSiguiente().getSiguiente());
                return true;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        INodo nodoActual = this.Cabeza;
        StringBuilder toPrint = new StringBuilder();
        while(nodoActual.getSiguiente() != null){
            toPrint.append(nodoActual.getDato());
            toPrint.append("\n");
            nodoActual = nodoActual.getSiguiente();
        }
        return toPrint.toString();
    }

    @Override
    public String imprimir(String separador) {
        INodo nodoActual = this.Cabeza;
        StringBuilder toPrint = new StringBuilder();
        while(nodoActual.getSiguiente() != null){
            toPrint.append(nodoActual.getDato());
            toPrint.append(separador);
            nodoActual = nodoActual.getSiguiente();
        }
        return toPrint.toString();
    }

    @Override
    public int cantElementos() {
        INodo nodoActual = this.Cabeza;
        int i = 1;
        while(nodoActual.getSiguiente() != null){
            i++;
            nodoActual = nodoActual.getSiguiente();
        }
        return i;
    }

    @Override
    public boolean esVacia() {
        if(this.Cabeza == null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void setPrimero(INodo unNodo) {

    }
}
