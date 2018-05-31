/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Modelo.Instancia;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gio
 */
public class InstanciaIT {
    
    public InstanciaIT() {
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
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setN method, of class Instancia.
     */
    @Test
    public void testSetN() {
        System.out.println("setN");
        int n = 1;
        Instancia instance = new Instancia();
        instance.setN(n);
        // TODO review the generated test code and remove the default call to fail.
         if(instance.getN()!=n)
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigoSis method, of class Instancia.
     */
    @Test
    public void testSetCodigoSis() {
        System.out.println("setCodigoSis");
        int codigoSis = 200000146;
        Instancia instance = new Instancia();
        instance.setCodigoSis(codigoSis);
        // TODO review the generated test code and remove the default call to fail.
        if(instance.getCodigoSis()!=codigoSis)
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMateria method, of class Instancia.
     */
    @Test
    public void testSetMateria() {
        System.out.println("setMateria");
        String materia = "calculo";
        Instancia instance = new Instancia();
        instance.setMateria(materia);
        // TODO review the generated test code and remove the default call to fail.
        if(!instance.getMateria().equals(materia))
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNota method, of class Instancia.
     */
    @Test
    public void testSetNota() {
        System.out.println("setNota");
        int nota = 27;
        Instancia instance = new Instancia();
        instance.setNota(nota);
        // TODO review the generated test code and remove the default call to fail.
        if(instance.getNota()!=nota)
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHabilitado method, of class Instancia.
     */
    @Test
    public void testSetHabilitado() {
        System.out.println("setHabilitado");
        String habilitado = "habilitado";
        Instancia instance = new Instancia();
        instance.setHabilitado(habilitado);
        // TODO review the generated test code and remove the default call to fail.
        if(!instance.getHabilitado().equals(habilitado))
        fail("The test case is a prototype.");
    }

    /**
     * Test of getN method, of class Instancia.
     */
    @Test
    public void testGetN() {
        System.out.println("getN");
        Instancia instance = new Instancia();
        int expResult = 1;
        int result = instance.getN();        
        if(expResult==result)
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCodigoSis method, of class Instancia.
     */
    @Test
    public void testGetCodigoSis() {
        System.out.println("getCodigoSis");
        Instancia instance = new Instancia();
        int expResult = 200000146;
        int result = instance.getCodigoSis();        
        if(expResult==result)
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMateria method, of class Instancia.
     */
    @Test
    public void testGetMateria() {
        System.out.println("getMateria");
        Instancia instance = new Instancia();
        String expResult = "calculo";
        String result = instance.getMateria();       
         if(expResult.equals(result))
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNota method, of class Instancia.
     */
    @Test
    public void testGetNota() {
        System.out.println("getNota");
        Instancia instance = new Instancia();
        int expResult = 27;
        int result = instance.getNota();        
        // TODO review the generated test code and remove the default call to fail.
         if(expResult==result)
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHabilitado method, of class Instancia.
     */
    @Test
    public void testGetHabilitado() {
        System.out.println("getHabilitado");
        Instancia instance = new Instancia();
        String expResult = "habilitado";
        String result = instance.getHabilitado();       
        if(expResult.equals(result))
        fail("The test case is a prototype.");
    }
    
}
