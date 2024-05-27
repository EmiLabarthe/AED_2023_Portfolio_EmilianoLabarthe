package com.mycompany.ut5_pd7;

import java.time.LocalDate;
import java.util.LinkedList;


public class TArbolTrieTelefonos implements IArbolTrieTelefonos {

    private TNodoTrieTelefonos raiz;

    @Override
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        if(raiz != null){
            LinkedList<TAbonado> busquedaAbonados = new LinkedList<>();
            raiz.buscarTelefonos(pais.concat(area), busquedaAbonados);
            return busquedaAbonados;
        }
        return null;
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        if(raiz == null){
            raiz = new TNodoTrieTelefonos();
        }
        raiz.insertar(unAbonado);
    }
    
    public LinkedList<TAbonado> ventasDesdeFecha(int anio, int mes, int dia){
        LocalDate date = LocalDate.of(anio,mes,dia);
        LinkedList<TAbonado> ventas = new LinkedList<>();
        if(raiz != null){
            raiz.ventasDesdeFecha(date, ventas);
        }
        return ventas;
    }

    public LinkedList<TAbonado> ventasDesdeFechaPais(int anio, int mes, int dia, String prefijoPais){
        LocalDate date = LocalDate.of(anio,mes,dia);
        LinkedList<TAbonado> ventas = new LinkedList<>();
        if(raiz != null){
            raiz.ventasDesdeFechaPais(date, ventas, prefijoPais);
        }
        return ventas;
    }
    
    public TArbolTrieTelefonos todasLasVentasPais(String prefijo, LinkedList<TAbonado> ventas){
        TArbolTrieTelefonos triePais = new TArbolTrieTelefonos();
        if(raiz != null){
            raiz.todasLasVentasPais(prefijo, ventas, triePais);
        }
        return triePais;
    }
 
    public int getCantidadTelefonos(){
        int counter = 0;
        if(raiz != null){
            counter = raiz.getCantidadTelefonos(counter);
        }
        return counter;
    }
    
}
