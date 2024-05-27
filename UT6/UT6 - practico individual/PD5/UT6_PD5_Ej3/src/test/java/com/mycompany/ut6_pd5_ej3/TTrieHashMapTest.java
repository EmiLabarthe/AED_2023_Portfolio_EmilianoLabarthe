/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.ut6_pd5_ej3;

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
public class TTrieHashMapTest {
    
    public TTrieHashMapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testBuscarTelefonos() {
        System.out.println("buscarTelefonos");
        TAbonado abonado1 = new TAbonado("Augusto","59897910287");
        TAbonado abonado2 = new TAbonado("Edmundo","59897910288");
        TAbonado abonado3 = new TAbonado("Pepe","79997910289");
        String pais = "598";
        String area = "97";
        TTrieHashMap instance = new TTrieHashMap();
        instance.insertar(abonado1);
        instance.insertar(abonado2);
        instance.insertar(abonado3);
        int expSize = 2;
        LinkedList<TAbonado> result = instance.buscarTelefonos(pais, area);
        assertEquals(expSize, result.size());
    }

    @Test
    public void testInsertar() {
        System.out.println("insertar");
        TAbonado unAbonado = new TAbonado("Augusto","59897910287");
        TTrieHashMap instance = new TTrieHashMap();
        instance.insertar(unAbonado);
        LinkedList<TAbonado> abonado = instance.buscarTelefonos("598", "97");
        assertEquals(abonado.get(0), unAbonado);
    }
    
}
