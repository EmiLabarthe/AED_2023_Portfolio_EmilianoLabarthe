/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ut3_pd6netbeans;

/**
 *
 * @author emili
 */
public class UT3_PD6netBeans {

    public static void main(String[] args) {
        
        // 1
        ListaSucursales listaSuc1 = new ListaSucursales();
        String[] suc1 = ManejadorArchivosGenerico.leerArchivo("suc1.txt");
        for(String city : suc1){
            listaSuc1.insertar(city, city);
        }
        System.out.println(listaSuc1.imprimir());
        System.out.println("La cantidad de elementos es: " + listaSuc1.cantElementos());
        
        // 2
        listaSuc1.eliminar("Chicago");
        System.out.println(listaSuc1.imprimir());
        
        INodo hongkong = listaSuc1.buscar("Hong Kong");
        System.out.println("La siguiente sucursal a Hong Kong es: " + hongkong.getSiguiente().getEtiqueta());
        
        
        // 3
        String[] suc2 = ManejadorArchivosGenerico.leerArchivo("suc2.txt");
        ListaSucursales listaSuc2 = new ListaSucursales();
        for(String city : suc2){
            listaSuc2.insertar(city, city);
        }
        listaSuc2.eliminar("Shenzen");  
        listaSuc2.eliminar("Tokio");
        System.out.println(listaSuc2.imprimir());
        // Queda vacío y arroja error en tiempo de ejecución
        
        // 4
        String[] suc3 = ManejadorArchivosGenerico.leerArchivo("suc3.txt");
        ListaSucursales listaSuc3 = new ListaSucursales();
        for(String city : suc3){
            listaSuc3.insertar(city, city);
        }
        System.out.println(listaSuc3.imprimir(";_"));
        
    }
}
