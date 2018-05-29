/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Modelo.Dao.MaterialDao;
import Modelo.Material;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class TestMaterial {
    
    public TestMaterial() {
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
     @Test
     public void compraMaterialNuevo() {
        Material m= new Material();
        MaterialDao md=new MaterialDao();
        
    
     }
     @Test
     public void salidaMaterialInexistente() {
        Material m= new Material();
        MaterialDao md=new MaterialDao();
        Assert.assertFalse(md.salidaMaterial("7914042", "Detergente", 25));
     }
     @Test
     public void SalidaCantidadesNegativas() {
        Material m= new Material();
        MaterialDao md=new MaterialDao();
        Assert.assertFalse(md.salidaMaterial("7914042", "Detergente", -25));
     }
     public void IngresoCantidadesNegativas() {
        Material m= new Material();
        MaterialDao md=new MaterialDao();
        Assert.assertFalse(md.ingresarMaterial("casa ideas", "Detergente", -25));
     }
     
     
}
