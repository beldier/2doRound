
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
    public boolean verificarAlmuerzo(int ci)
    {
        boolean ans=true;
        Connection conn=getConnection();
        String query="select ciEmpleado from registroAlmuerzo where ciEmpleado="+ci;
        try {
            Statement stat = conn.createStatement();
            ResultSet rs =((java.sql.Statement) stat).executeQuery(query);
            if(!rs.next())
                ans=false;
        }catch (SQLException e) {
             System.out.println(e.getMessage());
        }   
        return ans;
    }
    public boolean verificarCena(int ci)
    {
        boolean ans=true;
        Connection conn=getConnection();
        String query="select ciEmpleado from registroCena where ciEmpleado="+ci;
        try {
            Statement stat = conn.createStatement();
            ResultSet rs =((java.sql.Statement) stat).executeQuery(query);
            if(!rs.next())
                ans=false;
        }catch (SQLException e) {
             System.out.println(e.getMessage());
        }   
        return ans;
    }
    public void almuerzo(String fecha,int ci)
    {
        Connection c=getConnection();
        String query="insert into registroAlmuerzo(fecha,ciEmpleado) values('"+fecha+"',"+ci+")";
        try {
            PreparedStatement pstmt;
            pstmt = c.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    
    }
    public void cena(String fecha,int ci)
    {
            Connection c=getConnection();
        String query="insert into registroCena(fecha,ciEmpleado) values('"+fecha+"',"+ci+")";
        try {
            PreparedStatement pstmt;
            pstmt = c.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    
    }
       public ArrayList consultaEmpleadoActivo()
    {
        ArrayList empleados =new ArrayList <Empleado> ();
        Connection conn=getConnection();
        String query="select ciempleado, nombre, apellido from empleado where activo=true";
        System.out.println(query);
        Empleado c=null;
        try {
            Statement stat = conn.createStatement();
            ResultSet rs =((java.sql.Statement) stat).executeQuery(query);
            while(rs.next()){
                c=new Empleado();
                c.setCi(rs.getString("ciempleado"));
                
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                 System.out.println(c.getApellido());
                empleados.add(c);
            }            
        }catch (SQLException e) {
             System.out.println(e.getMessage());
        }   
        return empleados;
    }
    
    public ArrayList<String> getListaEmpleados()
    {
        Connection conn=getConnection();
        String query="select ciempleado from empleado";
        System.out.println(query);
        Empleado c=null;
        ArrayList empleados =new ArrayList<String>();
        try {
            Statement stat = conn.createStatement();
            ResultSet rs =((java.sql.Statement) stat).executeQuery(query);
            while(rs.next()){
                c=new Empleado();
                c.setCi(Integer.toString(rs.getInt("ciempleado")));
                empleados.add(c.getCi());
            }            
        }catch (SQLException e) {
             System.out.println(e.getMessage());
        }   
        return empleados;
    }        
}
