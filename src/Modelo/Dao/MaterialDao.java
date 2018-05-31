/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

/**
 *
 * @author user
 */

import static Controlador.Conector.getConnection;
import Modelo.Material;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MaterialDao {
public ArrayList<String> getListaMateriales()
    {
        Connection conn=getConnection();
        String query="select nombre from material";
        System.out.println(query);
        Material c=null;
        ArrayList materiales =new ArrayList<String>();
        try {
            Statement stat = conn.createStatement();
            ResultSet rs =((java.sql.Statement) stat).executeQuery(query);
            while(rs.next()){
                c=new Material();
                c.setNombre(rs.getString("nombre"));
                materiales.add(c.getNombre());
            }            
        }catch (SQLException e) {
             System.out.println(e.getMessage());
        }   
        return materiales;
    }
public boolean salidaMaterial(int ciEmp, String mat, int cantidad){
        boolean bandera=false;
        Connection conn=getConnection();
        
        try {
            Statement stat = conn.createStatement();
            ResultSet rs =((java.sql.Statement) stat).executeQuery("select salida "
                    + "("+ciEmp+",'"+mat+"',"+cantidad+" )");
            if(rs.next()){
                 bandera=rs.getBoolean(1);}
                        
        }catch (SQLException e) {
             System.out.println(e.getMessage());
        } 
        return bandera;
    }
    public boolean ingresoMaterial(String prov, String mat, int cantidad){
        boolean bandera=false;
        Connection conn=getConnection();
        String query=
                "select prueba   ('"+prov+"','"+mat+"',"+cantidad+ ")";
        System.out.println(query);
        //"insert into Registro_Salida(ciEmpleado, horaSalida) values ("+ ci+",'"+fecha+"')";
        try {
            Statement stat = conn.createStatement();
            ResultSet rs =((java.sql.Statement) stat).executeQuery
            (query);
            if(rs.next()){
                 bandera=rs.getBoolean(1);}
                        
        }catch (SQLException e) {
             System.out.println(e.getMessage()+"bd");
        } 
        return bandera;
    }   
}
