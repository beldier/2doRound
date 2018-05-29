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
public ArrayList<Material> getListaMateriales()
    {
        Connection conn=getConnection();
        String query="select nombre from material";
        System.out.println(query);
        Material c=null;
        ArrayList materiales =new ArrayList<Material>();
        try {
            Statement stat = conn.createStatement();
            ResultSet rs =((java.sql.Statement) stat).executeQuery(query);
            if(rs.next()){
                c=new Material();
                c.setNombre(rs.getString("nombre"));
                materiales.add(c);
            }            
        }catch (SQLException e) {
             System.out.println(e.getMessage());
        }   
        return materiales;
    }
    public boolean ingresarMaterial(String prov, String mat, int cantidad){
        boolean bandera=false; 
        return bandera;
    }
    public boolean salidaMaterial(String ciEmp, String mat, int cantidad){
        boolean bandera=false; 
        return bandera;
    }   
}
