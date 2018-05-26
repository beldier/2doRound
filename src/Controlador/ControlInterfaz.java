
package Controlador;

import static Controlador.Conector.getConnection;
import Modelo.Trabajador;
import Modelo.Dao.TrabajadorDao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import vista.RegistroSalida;
import vista.SeleccionFuncion;



public class ControlInterfaz implements ActionListener {

    private SeleccionFuncion seleccionFuncion;
    private Conector c;
    private RegistroSalida registroSalida;
    public ControlInterfaz(SeleccionFuncion s)
    {
        this.seleccionFuncion=s;
        c=new Conector();        

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String orden=e.getActionCommand();
        System.out.println(orden);
        switch(orden){
            ////////////////////////////SOLO PARA ABRIR VENTANAS 
            case "Abrir registro ingreso":break;
            case "Abrir registro salida":abrirRegistroSalida();break;
            case "Abrir registro personal":break;
            case "Abrir habilitados instancia":break;
            case "Abrir registro comedor":break;
            case "Abrir cronograma mantenimiento":break;
            case "Abrir ubicacion custodia bienes":break;
            case "Abrir materiales consumibles":break;
            case "Abrir productos sin usar":break;
            case "Abrir computadoras mantenimiento":break;
            case "Abrir registro vacacion":break;
            ///////////////////////////////
            
            case "Sale trabajador":salidaTrabajador();break;
            case "Limpiar registro salida":limpiarRegistro();break;
            default :System.out.println("Error en actioncomand");break;    
        }        
    }
    public void abrirRegistroSalida()
    {   
        registroSalida=new RegistroSalida();
        registroSalida.setControlador(this);
    }
    public void salidaTrabajador()
    {
            System.out.println("salida");
   
    }
    public void limpiarRegistro()
    {
             System.out.println("limpiar");
    }

}
