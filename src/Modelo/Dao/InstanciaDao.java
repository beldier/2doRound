/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Controlador.Conector;
import static Controlador.Conector.getConnection;
import Controlador.ControlInstancia;
import Modelo.Instancia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.ConsultaInstancia;
import static vista.ConsultaInstancia.modelo;
import static vista.ConsultaInstancia.modeloTabla;

/**
 *
 * @author gio
 */
public class InstanciaDao {

    public InstanciaDao() {
    }
    
    
    public static ArrayList<Instancia>  setFilas(String mate,String doc)
    {
        System.out.println(mate+""+doc ); 
     Connection conn=getConnection();
     ArrayList instancia =new ArrayList<Instancia>();
        String Sql="select i.idinscripcion ,i.idestudiante,m.nombre,i.promediofinal,i.habilitado\n" +
                   "from inscripcion i ,materia m,docente d\n" +
                   "where m.idmateria=i.idmateria and m.ciempleado=d.ciempleado and m.nombre='"
                    +mate+"'\n" +
                   "and d.nombre='"+doc+"'\n" +
                   "and promediofinal>=26 ";
       
        try {
            Statement stat = conn.createStatement();
            ResultSet rs =((java.sql.Statement) stat).executeQuery(Sql);   
             Object [] datos=new Object[5];
             Instancia c=null;
        
             while(rs.next())
             {
                 c=new Instancia();
                 for (int i = 0; i <5; i++) {
                     datos[i] =rs.getObject(i+1);
                     //System.out.println(datos[i] ); 
                     switch(i)
                     {
                         case 0: c.setN((int)datos[i]);break;
                         case 1:c.setCodigoSis((int)datos[i]);break;
                         case 2:c.setMateria((String)datos[i]);break;
                         case 3:c.setNota((int)datos[i]);break;
                         case 4:c.setHabilitado((String)datos[i]);break;
                     }
                 }  
               instancia.add(c);                 
                modeloTabla.addRow(datos);
             } 
             rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaInstancia.class.getName()).log(Level.SEVERE, null, ex);
        }
         //System.out.println("fsdf"+(modeloTabla.getRowCount()-1));
             if(instancia.size()<=0)
             { 
                 ControlInstancia.existe=false;
             }
             else{ ControlInstancia.existe=true;
                     }
        //this.revalidate();
        return instancia;
    }
}
