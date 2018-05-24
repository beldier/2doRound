
package Modelo.Dao;

import static Controlador.Conector.getConnection;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDao {

    public Cliente getCliente(String ci)
    {
        Connection conn=getConnection();
        String query="select nombre from jugador where ci="+ci;
        System.out.println(query);
        Cliente c=null;
        try {
            Statement stat = conn.createStatement();
            ResultSet rs =((java.sql.Statement) stat).executeQuery(query);
            if(rs.next()){
                c=new Cliente();
                c.setNombre(rs.getString("nombre"));
            }            
        }catch (SQLException e) {
             System.out.println(e.getMessage());
        }   
        return c;
    }
}
