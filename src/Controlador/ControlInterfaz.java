
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import vista.ConsultaEmpleado;
import vista.IngresoAlmacen;
import vista.PantallaIngresoSalida;
import vista.RegistroSalida;
import vista.SalidaAlmacen;
import vista.SeleccionFuncion;
import vista.VacacionEmpleado;



public class ControlInterfaz implements ActionListener {

    private SeleccionFuncion seleccionFuncion;
    private Conector c;
    private RegistroSalida registroSalida;
    private PantallaIngresoSalida ingresoSalida;
    private ConsultaEmpleado consultaEmpleado;
    private IngresoAlmacen ingresoAlmacen;
    private SalidaAlmacen salidaAlmacen;
    private VacacionEmpleado vacacion;
    public ControlInterfaz(SeleccionFuncion s)
    {
        this.seleccionFuncion=s;
        c=new Conector();        

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String orden=e.getActionCommand();
        //System.out.println(orden);
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
            case "Abrir registro vacacion":abrirRegistroVacacion();break;
            case "Abrir registro ingreso almacen":abrirIngresoAlmacen();break;
            case "Abrir registro salida almacen":abrirSalidaAlmacen();break;
            ///////////////////////////////
            
            case "Sale trabajador":salidaTrabajador();break;
            case "Limpiar registro salida":limpiarRegistro();break;
            case "Buscar dias vacacion":buscarDiasVacacion();break;
            case "Otorgar vacacion":otorgarVacacion();break;
            case "Salir ventana vacacion":salirVentantaVacacion();break;
            default :System.out.println("Error en actioncomand");break;    
        }        
    }
    public void abrirRegistroVacacion()
    {
        vacacion=new VacacionEmpleado();
        vacacion.setControlador(this);
    }
    public void buscarDiasVacacion()
    {
       vacacion.deshabilitarVacacion();
        Empleado e=new EmpleadoDao().getEmpleado(vacacion.getCi());
        if(e!=null){
            int diasTomados=e.getDiasTomados();
            System.out.println(diasTomados);
            String contratacion=(e.getFechaContratacion()).replaceAll("-", "/");

            int diffYears=ControlVacacion.getDiferencia(new Date(ControlHora.getDia().replaceAll("-", "/")),new Date(contratacion));
            if(diffYears==0){
                vacacion.antiguedadInsuficiente();
            }
            else{
                int calculoDias=ControlVacacion.getDias(diffYears);
                if(calculoDias>diasTomados){
                    vacacion.mostrarDias(calculoDias-diasTomados);   
                    vacacion.habilitarVacacion();
                }
                else
                {
                    vacacion.mostrarDias(0);
                    vacacion.noVacacion();
                }
                
            }
           
        }
        else{
            vacacion.noExisteCi();
        }
        
    }
    public void otorgarVacacion()
    {
        int diasPedidos=vacacion.pedirDias();
        if(diasPedidos>vacacion.getDiasDisponibles())
            vacacion.errorDias();
        else{
            new EmpleadoDao().agregarVacacion(vacacion.getCi(), diasPedidos);
            vacacion.exito();
            vacacion.limpiar();
        }
            
                

    }
    public void salirVentantaVacacion()
    {
             System.out.println("salir");
   
    }
    public void abrirRegistroSalida()
    {   
        registroSalida=new RegistroSalida();
        registroSalida.setControlador(this);
        
    }
    public void salidaTrabajador()
    {
        int ci=registroSalida.getCi();
        Empleado e=new EmpleadoDao().getEmpleado(ci);
        if(e==null)
            registroSalida.ciInexistente();
        else{
            boolean salioAntes=ControlEmpleado.verificarSalidaPrevia(ci);
            if(salioAntes==false){
                SimpleDateFormat df = new SimpleDateFormat("YYYY/MM/dd hh:mm:ss");
                Calendar calendar = Calendar.getInstance();
                Date horaActual=calendar.getTime();
                String hora=(df.format(horaActual));
                if(ControlHora.saleAntes(horaActual)){
                    int ans=registroSalida.alerta();//si=0 ,no=1
                    if(ans==0){
                        new EmpleadoDao().marcarSalida(registroSalida.getCi(),hora);
                        registroSalida.exito();
                    }
                }
                else{
                    new EmpleadoDao().marcarSalida(registroSalida.getCi(),hora);
                    registroSalida.exito();
                }
            }   
            else{
                registroSalida.errorSalidaPrevia();
            }
        }
        limpiarRegistro();
   
    }
    public void limpiarRegistro()
    {
         registroSalida.limpiar();
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
