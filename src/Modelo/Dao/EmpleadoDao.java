
package Modelo.Dao;

import static Controlador.Conector.getConnection;
import Modelo.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpleadoDao {
    //Cliente 

    public Empleado getCliente(String ci)
    {
        Connection conn=getConnection();
        String query="select nombre from trabajador where ci="+ci;
        System.out.println(query);
        Empleado c=null;
        try {
            Statement stat = conn.createStatement();
            ResultSet rs =((java.sql.Statement) stat).executeQuery(query);
            if(rs.next()){
                c=new Empleado();
                c.setNombre(rs.getString("nombre"));
            }            
        }catch (SQLException e) {
             System.out.println(e.getMessage());
        }   
        return c;
    }
}
