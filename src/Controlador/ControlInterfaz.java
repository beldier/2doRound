
package Controlador;

import static Controlador.Conector.getConnection;
import Modelo.Cliente;
import Modelo.Dao.ClienteDao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import vista.Ventanta;


public class ControlInterfaz implements ActionListener {

    private Ventanta ventana;
    private Conector c;
    public ControlInterfaz(Ventanta v)
    {
        this.ventana=v;
        c=new Conector();        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String orden=e.getActionCommand();
        //System.out.println(orden);
        switch(orden){
            case "Ingresa cliente":obtenerCliente();break;
            default :System.out.println("Error en actioncomand");break;    
        }        
    }
    public void obtenerCliente()
    {
        ClienteDao cliente=new ClienteDao();
        ventana.setNombreCliente(cliente.getCliente(ventana.getCi()));
    }

}
