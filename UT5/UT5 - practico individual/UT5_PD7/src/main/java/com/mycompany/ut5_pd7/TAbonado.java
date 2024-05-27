package com.mycompany.ut5_pd7;

import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 */
public class TAbonado implements Comparable {

    private String nombre;
    private String telefono;
    private LocalDate fechaIngreso;

    TAbonado(String unNombre, String unTelefono, int anio, int mes, int dia) {

        this.nombre = unNombre;
        this.telefono = unTelefono;
        this.fechaIngreso = LocalDate.of(anio,mes,dia);
    }

    public String getNombre() {
        return this.nombre;
    }
    
    public LocalDate getFechaIngreso(){
        return fechaIngreso;
    }

    public String getTelefono() {
        return this.telefono;
    }

    @Override
    public int compareTo(Object o) {
        return (this.nombre.compareTo(((TAbonado)o).getNombre()));
    }
}
