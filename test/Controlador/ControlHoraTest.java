/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lurianne
 */
public class ControlHoraTest {
    
    public ControlHoraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Conector c=new Conector();
    }
    
    /**
     * Test of saleAntes method, of class ControlHora.
     */
    @Test
    public void testSaleAntes() {
        System.out.println("saleAntes");
        Calendar cal = Calendar.getInstance();  
        cal.setTime(new Date());  
        cal.set(Calendar.HOUR_OF_DAY, 18);  
        cal.set(Calendar.MINUTE, 59);  
        cal.set(Calendar.SECOND, 59);
        Date horaActual = cal.getTime();
        boolean expResult = true;
        boolean result = ControlHora.saleAntes(horaActual);
        assertEquals(expResult, result);
        
        cal.set(Calendar.HOUR_OF_DAY, 19);  
        cal.set(Calendar.MINUTE, 01);  
        cal.set(Calendar.SECOND, 00);
        horaActual = cal.getTime();
        expResult = false;
        result = ControlHora.saleAntes(horaActual);
        assertEquals(expResult, result);
    }

    /**
     * Test of entraDespues method, of class ControlHora.
     */
    /*@Test
    public void testEntraDespues() {
        System.out.println("entraDespues");
        Date horaActual = null;
        boolean expResult = false;
        boolean result = ControlHora.entraDespues(horaActual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    /**
     * Test of getDia method, of class ControlHora.
     */
    /*@Test
    public void testGetDia() {
        System.out.println("getDia");
        String expResult = "";
        String result = ControlHora.getDia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
