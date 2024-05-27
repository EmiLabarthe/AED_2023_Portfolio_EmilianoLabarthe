/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package tdassecondhalf;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emili
 */
public class TGrafoNoDirigidoTest {
    
    public TGrafoNoDirigidoTest() {
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
    public void testExisteCamino() {
        // creacion vertices
        Collection<TVertice> vertices = new LinkedList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        vertices.add(new TVertice("D"));

        // creacion aristas
        Collection<TArista> aristas = new LinkedList<>();
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("B", "C", 1));
        aristas.add(new TArista("B", "D", 1));

        // creacion grafo
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);

        // verificar conexiones:
        TVertice a = grafo.getVertices().get("A");
        TVertice b = grafo.getVertices().get("B");
        TVertice c = grafo.getVertices().get("C");
        TVertice d = grafo.getVertices().get("D");
        assertTrue(grafo.existeCamino(a.getEtiqueta(), b.getEtiqueta()));
        assertTrue(grafo.existeCamino(a.getEtiqueta(), c.getEtiqueta()));
        assertTrue(grafo.existeCamino(c.getEtiqueta(), a.getEtiqueta()));
        assertTrue(grafo.existeCamino(d.getEtiqueta(), b.getEtiqueta()));

        // inserto nuevo vertice y verifico conexiones:
        TVertice e = new TVertice("E");
        grafo.insertarVertice(e);
        assertFalse(grafo.existeCamino(b.getEtiqueta(), e.getEtiqueta()));
    }
    
    @Test
    public void testBea() {
        // creacion vertices
        Collection<TVertice> vertices = new LinkedList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        vertices.add(new TVertice("D"));
        vertices.add(new TVertice("E"));
        vertices.add(new TVertice("F"));
        vertices.add(new TVertice("G"));
        vertices.add(new TVertice("H"));

        // creacion aristas
        Collection<TArista> aristas = new LinkedList<>();
        aristas.add(new TArista("A", "B", 2));
        aristas.add(new TArista("B", "D", 2));
        aristas.add(new TArista("A", "C", 3));
        aristas.add(new TArista("C", "D", 1));
        aristas.add(new TArista("D", "E", 2));
        aristas.add(new TArista("D", "F", 4));
        aristas.add(new TArista("E", "G", 2));
        aristas.add(new TArista("E", "F", 1));
        aristas.add(new TArista("F", "G", 2));
        aristas.add(new TArista("G", "H", 4));
        aristas.add(new TArista("F", "H", 3));

        // creacion grafo
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);

        // verificar orden de visitas durante una bea:
        Collection<TVertice> bea = grafo.bea();

        assertEquals(grafo.getVertices().size(), bea.size());
        String ordenEsperado = "A-B-C-D-E-F-G-H";
        String ordenActual = "";
        for (TVertice v : bea) {
            ordenActual += v.getEtiqueta() + "-";
        }
        assertEquals(ordenEsperado, ordenActual.substring(0, ordenActual.length() - 1));
    }
    
    @Test
    public void tieneCiclo() {
        // creacion vertices
        Collection<TVertice> vertices = new LinkedList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));
        vertices.add(new TVertice("D"));

        // creacion aristas
        Collection<TArista> aristas = new LinkedList<>();
        aristas.add(new TArista("A", "B", 1));
        aristas.add(new TArista("A", "C", 1));
        aristas.add(new TArista("B", "D", 1));

        // creacion grafo aciclico
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);

        // Verificar si el grafo es aciclico
        grafo.tieneCiclos();
        assertFalse(grafo.tieneCiclos());

        // agrego un ciclo
        grafo.insertarArista(new TArista("B", "C", 1));

        // Verificar si el grafo es ciclico
        assertTrue(grafo.tieneCiclos());
    }

    /*
    @Test
    public void testInsertarArista() {
        System.out.println("insertarArista");
        TArista arista = null;
        TGrafoNoDirigido instance = null;
        boolean expResult = false;
        boolean result = instance.insertarArista(arista);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetLasAristas() {
        System.out.println("getLasAristas");
        TGrafoNoDirigido instance = null;
        TAristas expResult = null;
        TAristas result = instance.getLasAristas();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPrim() {
        System.out.println("Prim");
        TGrafoNoDirigido instance = null;
        TGrafoNoDirigido expResult = null;
        TGrafoNoDirigido result = instance.Prim();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testBuscarMenorArista() {
        System.out.println("buscarMenorArista");
        LinkedList<TVertice> U = null;
        List<TVertice> V = null;
        TGrafoNoDirigido instance = null;
        TArista expResult = null;
        TArista result = instance.buscarMenorArista(U, V);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testKruskal() {
        System.out.println("Kruskal");
        TGrafoNoDirigido instance = null;
        TGrafoNoDirigido expResult = null;
        TGrafoNoDirigido result = instance.Kruskal();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testBea_Comparable() {
        System.out.println("bea");
        Comparable etiquetaOrigen = null;
        TGrafoNoDirigido instance = null;
        Collection<TVertice> expResult = null;
        Collection<TVertice> result = instance.bea(etiquetaOrigen);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testBea_0args() {
        System.out.println("bea");
        TGrafoNoDirigido instance = null;
        Collection<TVertice> expResult = null;
        Collection<TVertice> result = instance.bea();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEsConexo() {
        System.out.println("esConexo");
        TGrafoNoDirigido instance = null;
        boolean expResult = false;
        boolean result = instance.esConexo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPuntosArticulacion() {
        System.out.println("puntosArticulacion");
        Comparable etOrigen = null;
        TGrafoNoDirigido instance = null;
        LinkedList<TVertice> expResult = null;
        LinkedList<TVertice> result = instance.puntosArticulacion(etOrigen);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    */
    
}
