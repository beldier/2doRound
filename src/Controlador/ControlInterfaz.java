
package Controlador;

import static Controlador.Conector.getConnection;
import Modelo.Empleado;
import Modelo.Dao.EmpleadoDao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import vista.ConsultaEmpleado;
import vista.IngresoAlmacen;
import vista.PantallaIngresoSalida;
import vista.RegistroSalida;
import vista.SalidaAlmacen;
import vista.SeleccionFuncion;



public class ControlInterfaz implements ActionListener {

    private SeleccionFuncion seleccionFuncion;
    private Conector c;
    private RegistroSalida registroSalida;
    private PantallaIngresoSalida ingresoSalida;
    private ConsultaEmpleado consultaEmpleado;
    private IngresoAlmacen ingresoAlmacen;
    private SalidaAlmacen salidaAlmacen;
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
            case "Abrir registro personal":abrirConsultaEmpleado();break;
            case "Abrir habilitados instancia":break;
            case "Abrir registro comedor":break;
            case "Abrir cronograma mantenimiento":break;
            case "Abrir ubicacion custodia bienes":break;
            case "Abrir materiales consumibles":abrirIngresoSalida();break;
            case "Abrir productos sin usar":break;
            case "Abrir computadoras mantenimiento":break;
            case "Abrir registro vacacion":break;
            case "Abrir registro ingreso almacen":abrirIngresoAlmacen();break;
            case "Abrir registro salida almacen":abrirSalidaAlmacen();break;
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

    private void abrirIngresoSalida() {
        ingresoSalida=new PantallaIngresoSalida();
        ingresoSalida.setControlador(this);
    }

    private void abrirConsultaEmpleado() {
        consultaEmpleado=new ConsultaEmpleado();
        consultaEmpleado.setControlador(this);
    }

    private void abrirIngresoAlmacen() {
        ingresoAlmacen=new IngresoAlmacen();
        ingresoAlmacen.setControlador(this);
    }

    private void abrirSalidaAlmacen() {
        salidaAlmacen=new SalidaAlmacen();
        salidaAlmacen.setControlador(this);
    }

}
