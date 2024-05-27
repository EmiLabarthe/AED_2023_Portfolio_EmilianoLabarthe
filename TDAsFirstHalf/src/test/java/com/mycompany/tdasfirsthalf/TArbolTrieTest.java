/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.tdasfirsthalf;

    import java.util.LinkedList;
    import org.junit.AfterClass;
    import org.junit.Before;
    import org.junit.BeforeClass;
    import org.junit.Test;
    import static org.junit.Assert.*;

/**
 *
 * @author emili
 */
public class TArbolTrieTest {
    
    public TArbolTrieTest() {
    }

    /**
     *
     * @throws Exception
     */
    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.Test
    public void testInsertar() {
        System.out.println("insertar");
        String s = "";
        TArbolTrie instance = new TArbolTrie();
        instance.insertar(s);
        //fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testBuscar() {
        System.out.println("buscar");
        String s = "";
        TArbolTrie instance = new TArbolTrie();
        int expResult = 0;
        int result = instance.buscar(s);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    /*
    @org.junit.Test
    public void testEliminar() {
        System.out.println("eliminar");
        String s = "";
        TArbolTrie instance = new TArbolTrie();
        boolean expResult = false;
        boolean result = instance.eliminar(s);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
*/

    @org.junit.Test
    public void testImprimir() {
        System.out.println("imprimir");
        TArbolTrie instance = new TArbolTrie();
        instance.imprimir();
        //fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testPredecir() {
        System.out.println("predecir");
        String prefijo = "";
        TArbolTrie instance = new TArbolTrie();
        LinkedList<String> expResult = null;
        LinkedList<String> result = instance.predecir(prefijo);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
}
