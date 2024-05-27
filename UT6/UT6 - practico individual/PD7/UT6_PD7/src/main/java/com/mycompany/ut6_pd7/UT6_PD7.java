/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ut6_pd7;

/**
 *
 * @author emili
 */
public class UT6_PD7 {

    public static void main(String[] args) {
        Alumno alumno1 = new Alumno(1,"juan","juan@juancho.com");
        Alumno alumno2 = new Alumno(2,"pepe","pepe@pepe.com");
        Alumno user2dePepe = new Alumno(2,"pepe","pepe@pepe.com");
        
        System.out.println(alumno2.equals(user2dePepe));
        System.out.println(alumno2.hashCode());
        System.out.println(alumno1.hashCode());
        
    }
}
