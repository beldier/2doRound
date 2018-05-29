
package Modelo.Dao;

import static Controlador.Conector.getConnection;
import Modelo.Empleado;
import Modelo.RegistroSalida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class EmpleadoDao {
    //Cliente 

    public Empleado getEmpleado(int ci)
    {
        Connection conn=getConnection();
        String query="select nombre,fecha_contratacion,diasTomados from empleado where ciEmpleado="+ci;
        Empleado c=null;
        try {
            Statement stat = conn.createStatement();
            ResultSet rs =((java.sql.Statement) stat).executeQuery(query);
            if(rs.next()){
                c=new Empleado();
                c.setNombre(rs.getString("nombre"));
                c.setFechaContratacion(rs.getString("fecha_contratacion"));
                c.setDiasTomados(Integer.parseInt(rs.getString("diasTomados")));
            }            
        }catch (SQLException e) {
             System.out.println(e.getMessage());
        }   
        return c;
    }
    public void marcarSalida(int ci,String fecha)
    {
        Connection c=getConnection();
        String query="insert into Registro_Salida(ciEmpleado, horaSalida) values ("
                + ci+",'"+fecha+"')";
        System.out.println(query);
        try {
            PreparedStatement pstmt;
            pstmt = c.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    public RegistroSalida getSalida(String date,int ci)
    {
        Connection conn=getConnection();
        String query="select idRegistroSalida,ciEmpleado,horaSalida "
                + "from registro_salida where date(horaSalida)='"+date+"' and ciEmpleado="+ci;
        RegistroSalida c=null;
        try {
            Statement stat = conn.createStatement();
            ResultSet rs =((java.sql.Statement) stat).executeQuery(query);
            if(rs.next()){
                c=new RegistroSalida();
                c.setIdRegistroSalida(Integer.parseInt(rs.getString("idRegistroSalida")));
                c.setCi(Integer.parseInt(rs.getString("ciEmpleado")));
                c.setHora(rs.getString("horaSalida"));
            }            
        }catch (SQLException e) {
             System.out.println(e.getMessage());
        }   
        return c;
    }
    public void agregarVacacion(int ci,int dias)
    {
        Connection c=getConnection();
        String query="update empleado set diasTomados=diasTomados+"+dias+" where ciempleado="+ci;
        System.out.println(query);
        try {
            PreparedStatement pstmt;
            pstmt = c.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
}
