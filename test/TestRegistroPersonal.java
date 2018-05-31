/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controlador.Conector;
import Modelo.Empleado;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vista.ConsultaEmpleado;

/**
 *
 * @author user
 */
public class TestRegistroPersonal {
    
    public TestRegistroPersonal() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Conector c=new Conector();
    
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void unSoloRegistro() {
    }
    
    @Test
    public void reportePersonalActivo() {
    Empleado e=new Empleado();
    e.setCi("7914042");
    e.setNombre("eli");
    e.setApellido("cusi");
    ArrayList emp =new ArrayList <Empleado> ();
    emp.add(e);
    ConsultaEmpleado c=new ConsultaEmpleado();
    c.llenarJTable(emp);
    c.init();
    }
    
}
