/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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
public class ControlVacacionTest {
    
    
    @BeforeClass
    public static void setUpClass() {
    }

    
    /**
     * Test of getDias method, of class ControlVacacion.
     */
    @Test
    public void testGetDias() {
        System.out.println("getDias");
        int diff = 0;
        int expResult = 0;
        
        int result = ControlVacacion.getDias(diff);
        assertEquals(0, result);
        
        diff = 3;
        result = ControlVacacion.getDias(diff);
        assertEquals(45, result);
        
        diff = 5;
        result = ControlVacacion.getDias(diff);
        assertEquals(75, result);

        diff = 8;
        result = ControlVacacion.getDias(diff); 
        assertEquals(135, result);

        diff = 12;
        result = ControlVacacion.getDias(diff);
        assertEquals(235, result);

        diff = 10;
        result = ControlVacacion.getDias(diff);
        assertEquals(175, result);

    }

    /**
     * Test of getDiferencia method, of class ControlVacacion.
     */
    @Test
    public void testGetDiferencia() {
        System.out.println("getDiferencia");
        Date actual = null;
        Date contratacion = null;
        int expResult = 0;
        int result = 0;
        
        actual=new Date("2018/05/29");
        contratacion=new Date("2018/03/29");
        expResult = 0;
        result = ControlVacacion.getDiferencia(actual, contratacion);
        assertEquals(expResult, result);
        
        actual=new Date("2018/05/29");
        contratacion=new Date("2017/05/29");
        expResult = 1;
        result = ControlVacacion.getDiferencia(actual, contratacion);
        assertEquals(expResult, result);
      
         actual=new Date("2018/05/29");
        contratacion=new Date("2017/05/28");
        expResult = 1;
        result = ControlVacacion.getDiferencia(actual, contratacion);
        assertEquals(expResult, result);
      
        actual=new Date("2018/05/29");
        contratacion=new Date("2017/05/30");
        expResult = 0;
        result = ControlVacacion.getDiferencia(actual, contratacion);
        assertEquals(expResult, result);
    }
    
}
