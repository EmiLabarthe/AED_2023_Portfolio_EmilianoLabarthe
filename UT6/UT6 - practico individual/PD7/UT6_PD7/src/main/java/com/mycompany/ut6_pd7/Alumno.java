/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut6_pd7;

import java.util.Objects;

/**
 *
 * @author emili
 */
public class Alumno extends Object{
    
    private int ID;
    private String fullName;
    private String email;
    
    public Alumno(int unID, String Name, String mail){
        ID = unID;
        fullName = Name;
        email = mail;
    }
    
    @Override
    public int hashCode(){
        // Las ID son unicas para cada estudiante. Supongamos
        // que el colegio tiene 500 alumnos y las colisiones se solucionan
        // con encadenamiento simple
        return ID % 200;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        return Objects.equals(this.ID, other.ID);
    }
}
