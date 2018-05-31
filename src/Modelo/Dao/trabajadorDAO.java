/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;
import static Controlador.Conector.getConnection;
import Modelo.trabajador;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author karen
 */
public class trabajadorDAO {

     //corregido   
    public String insertTrabajador(String cod_empleado,String ciempleado,String nombre,String apellido,String fecha,String hora){
        String respuestaRegistro=null;
        String insertar = "insert into empleado(ciempleado,nombre,apellido,hora,fecha,cod_empleado) "
                                    + " values('"+ciempleado+"','"+nombre+"','"+apellido+"','"+hora+"','"+fecha+"','"+cod_empleado+"')";
        System.out.println(insertar);
        try{
            Connection accesoBD = getConnection();
            PreparedStatement ps = accesoBD.prepareStatement(insertar/*"insert into empleado values('"+codigoTrab+"','"+ci+"','"+nombre+"','"+apellido+"','"+hora+"','"+fecha+"')"*/); 
            ps.executeUpdate();
            
        }
        catch (Exception e){
            //System.out.println("Dizados");
            e.printStackTrace();
        }
        return respuestaRegistro;
    }
    
    public ArrayList<trabajador>ListTrabajador(){
            ArrayList listaTrabajador = new ArrayList();
            trabajador trabajador;
            
            try{
            Connection accesoBD = getConnection();
            PreparedStatement ps = accesoBD.prepareStatement("SELECT cod_empleado,ciempleado,nombre,apellido,fecha,hora FROM empleado");
            ResultSet rs = ps.executeQuery();
             
            while(rs.next()){
                trabajador = new trabajador();
                trabajador.setCod_empleado(rs.getString(1));
                trabajador.setCiempleado(rs.getString(2));
                trabajador.setNombre(rs.getString(3));
                trabajador.setApellido(rs.getString(4));
                trabajador.setHora(rs.getString(6));
                trabajador.setFecha(rs.getString(5));
                listaTrabajador.add(trabajador);
            }
            
          }
        catch (Exception e){
            e.printStackTrace();
        }
        
        return listaTrabajador; 
    
    }
    
}
