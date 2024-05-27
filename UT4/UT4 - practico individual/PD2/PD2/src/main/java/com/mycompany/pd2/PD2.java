/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pd2;

//import ManejadorArchivosGenerico.leerArchivo;

/**
 *
 * @author emili
 */
public class PD2 {

    public static void main(String[] args) {
        //ejercicio2();
        //ejercicio3();
    }
    
    public static void ejercicio2(){
        String[] clavesPrueba = ManejadorArchivosGenerico.leerArchivo("clavesPrueba.txt");
        TArbolBB arbol2 = new TArbolBB();
        for( int i = 0 ; i < clavesPrueba.length ; i++ ){
            TElementoAB nodoCreado = new TElementoAB(Integer.parseInt(clavesPrueba[i]));
            arbol2.insertar(nodoCreado);
        }
        
        String[] title = new String[1];
        title[0] = "PreOrden:";
        ManejadorArchivosGenerico.escribirArchivo("UT4_PD2_Ej2.txt" , title);
        String[] preOrden = arbol2.preOrden().split("\n");
        ManejadorArchivosGenerico.escribirArchivo("UT4_PD2_Ej2.txt", preOrden);
        
        title[0] = "InOrden:";
        ManejadorArchivosGenerico.escribirArchivo("UT4_PD2_Ej2.txt" , title);
        String[] inOrden = arbol2.inOrden().split("\n");
        ManejadorArchivosGenerico.escribirArchivo("UT4_PD2_Ej2.txt", inOrden);
        
        title[0] = "PostOrden:";
        ManejadorArchivosGenerico.escribirArchivo("UT4_PD2_Ej2.txt" , title);
        String[] postOrden = arbol2.postOrden().split("\n");
        ManejadorArchivosGenerico.escribirArchivo("UT4_PD2_Ej2.txt", postOrden);  
    }
    
    public static void ejercicio3(){
        String[] claves1 = ManejadorArchivosGenerico.leerArchivo("claves1.txt");
        TArbolBB arbol3 = new TArbolBB();
        for( int i = 0 ; i < claves1.length ; i++ ){
            TElementoAB nodoCreado = new TElementoAB(Integer.parseInt(claves1[i]));
            arbol3.insertar(nodoCreado);
        }
        
        System.out.println("10635: " + arbol3.buscar(10635));
        System.out.println("4567: " + arbol3.buscar(4567));
        System.out.println("12: " + arbol3.buscar(12));
        System.out.println("8978: " + arbol3.buscar(8978));
        
        System.out.println(arbol3.preOrden());
        System.out.println("La decima clave es 797");
    }
}
