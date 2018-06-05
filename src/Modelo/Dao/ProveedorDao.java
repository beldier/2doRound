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
import Modelo.Proveedor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProveedorDao {
    public ArrayList<Proveedor> getListaMateriales()
    {
        Connection conn=getConnection();
        String query="select nombre from material";
        System.out.println(query);
        Proveedor c=null;
        ArrayList proveedores =new ArrayList<Proveedor>();
        try {
            Statement stat = conn.createStatement();
            ResultSet rs =((java.sql.Statement) stat).executeQuery(query);
            if(rs.next()){
                c=new Proveedor();
                c.setNombre(rs.getString("nombre"));
                proveedores.add(c);
            }            
        }catch (SQLException e) {
             System.out.println(e.getMessage());
        }   
        return proveedores;
    }        
    public ArrayList<String> getListaProveedores()
    {
        Connection conn=getConnection();
        String query="select nombre from proveedor";
        System.out.println(query);
        Proveedor c=null;
        ArrayList proveedores =new ArrayList<Proveedor>();
        try {
            Statement stat = conn.createStatement();
            ResultSet rs =((java.sql.Statement) stat).executeQuery(query);
            while(rs.next()){
                proveedores.add(rs.getString("nombre"));
            }            
        }catch (SQLException e) {
             System.out.println(e.getMessage());
        }   
        return proveedores;
       }        


}
