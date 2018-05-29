
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conector {
    private final String url = "jdbc:postgresql://localhost/xp";
    private final String user = "postgres";
    private final String password = "0488ecl";
    public static Connection conn; 
    public Conector()
    {
        try {
            conn = DriverManager.getConnection(url, user, password);
           // System.out.println("Connected to the PostgreSQL server successfully.");	        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }	 
    }
    
    public static Connection getConnection() 
    {
        return conn;
    } 
}