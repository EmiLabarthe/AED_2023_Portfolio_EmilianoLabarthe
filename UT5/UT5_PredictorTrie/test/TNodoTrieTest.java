/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

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
public class TNodoTrieTest {

    public TArbolTrie arbolito = new TArbolTrie();

    public TNodoTrieTest() {

    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        this.arbolito.insertar("violinista");
        this.arbolito.insertar("violin");
        this.arbolito.insertar("manolo");
        this.arbolito.insertar("pitufo");

    }

    @Test
    public void testPredecirCorrecto() {
        String prefijo = "viol";
        LinkedList<String> palabras = new LinkedList();
        palabras.add("violin");
        palabras.add("violinista");
        assertEquals(palabras, this.arbolito.predecir(prefijo));
    }
    
    @Test
    public void testPredecirArbolVacio() {
        TArbolTrie arbol= new TArbolTrie();
        String prefijo = "viol";
        LinkedList<String> palabras = new LinkedList();
        assertEquals(palabras, arbol.predecir(prefijo));
    }
    
    @Test
    public void testPredecirPalabraInexistente() {
        String prefijo = "hola";
        LinkedList<String> palabras = new LinkedList();
        assertEquals(palabras, this.arbolito.predecir(prefijo));
    }
    
    @Test
    public void testPredecirPalabraNula() {
        String prefijo = null;
        LinkedList<String> palabras = new LinkedList();
        assertEquals(null, this.arbolito.predecir(prefijo));
    }
    

    
    
    

}
