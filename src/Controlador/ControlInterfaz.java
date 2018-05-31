
package Controlador;

import static Controlador.Conector.getConnection;
import Modelo.Empleado;
import Modelo.Dao.EmpleadoDao;
import Modelo.Dao.trabajadorDAO;

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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.ConsultaEmpleado;
import vista.IngresoAlmacen;
import vista.PantallaIngresoSalida;
import vista.RegistroComedor;
import vista.RegistroSalida;
import vista.SalidaAlmacen;
import vista.SeleccionFuncion;
import vista.VacacionEmpleado;
import vista.jfregistrar;



public class ControlInterfaz implements ActionListener {

    private SeleccionFuncion seleccionFuncion;
    private Conector c;
    private RegistroSalida registroSalida;
    private PantallaIngresoSalida ingresoSalida;
    private ConsultaEmpleado consultaEmpleado;
    private IngresoAlmacen ingresoAlmacen;
    private SalidaAlmacen salidaAlmacen;
    private VacacionEmpleado vacacion;
    private RegistroComedor comedor;
    private jfregistrar vistaC;
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
            case "Abrir registro ingreso":abrirRegistroIngreso();break;
            case "Abrir registro salida":abrirRegistroSalida();break;
            case "Abrir registro personal":abrirConsultaEmpleado();break;
            case "Abrir habilitados instancia":break;
            case "Abrir registro comedor":abrirRegistroComedor();break;
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
            case "Solicita comida":solicitaComida();break;
            case "Cancela comida":cancelaComida();break;
            default :System.out.println("Error en actioncomand");break;    
        } 
        
        if(e.getSource() == vistaC.btnregistrar)
            insertaTrabajador();
         if(e.getSource()== vistaC.btnlistar){
            llenarTabla(vistaC.jtdatos);
        }
    }
    public void abrirRegistroIngreso()
    {
        vistaC=new jfregistrar();
        vistaC.setVisible(true);
        vistaC.setLocationRelativeTo(null);
            
       vistaC.btnregistrar.addActionListener(this);
       vistaC.btnlistar.addActionListener(this);
    }
         
    public void llenarTabla(JTable tablaD){
        System.out.println("Controlador.ControlInterfaz.llenarTabla()");
        trabajadorDAO modeloC=new trabajadorDAO();
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("Codigo Trabajador");
        modeloT.addColumn("C.I");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Apellido");
        modeloT.addColumn("Hora");
        modeloT.addColumn("Fecha");
        
        Object [] columna = new Object [6];
        int numRegistros = modeloC.ListTrabajador().size();
        for (int i = 0; i<numRegistros; i++){
            columna[0] = modeloC.ListTrabajador().get(i).getCod_empleado();
            columna[1] = modeloC.ListTrabajador().get(i).getCiempleado();
            columna[2] = modeloC.ListTrabajador().get(i).getNombre();
            columna[3] = modeloC.ListTrabajador().get(i).getApellido();
            columna[4] = modeloC.ListTrabajador().get(i).getHora();
            columna[5] = modeloC.ListTrabajador().get(i).getFecha();
            modeloT.addRow(columna);
        
        }
    }
    
    public void insertaTrabajador()
    {
        System.out.println("Controlador.ControlInterfaz.insertaTrabajador()");
        trabajadorDAO modeloC=new trabajadorDAO();     
        String cod_empleado = vistaC.txtcodigo.getText();
        String ciempleado = vistaC.txtci.getText();
        String nombre = vistaC.txtnombre.getText();
        String apellido = vistaC.txtapellido.getText();
        String hora = vistaC.txthora.getText();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formatoFecha.format(vistaC.jdfecha.getDate());    
        String respuestaRegistro = modeloC.insertTrabajador(cod_empleado, ciempleado, nombre, apellido, fecha, hora);
            if(respuestaRegistro!=null){
                JOptionPane.showMessageDialog(null, respuestaRegistro);
            }
            /*else{
                JOptionPane.showMessageDialog(null, "Registro Erroneo");
             }*/
        //else{
            //System.out.println("No funciona el boton listar");
       // }
    }
    public void abrirRegistroComedor()
    {
        comedor=new RegistroComedor();
        comedor.setControlador(this);
    }
    public void cancelaComida()
    {
        comedor.dispose();
    }
    public void solicitaComida()
    {
        Empleado e=new EmpleadoDao().getEmpleado(comedor.getCi());
        if(e!=null){
            SimpleDateFormat df = new SimpleDateFormat("YYYY/MM/dd hh:mm:ss");
            Calendar calendar = Calendar.getInstance();
            Date horaActual=calendar.getTime();
            boolean posibleAlmuerzo=ControlHora.horaAlmuerzo(horaActual);
            boolean posibleCena=ControlHora.horaCena(horaActual);
            if(posibleAlmuerzo==true || posibleCena==true){
                boolean duplicado=false;
                if(posibleAlmuerzo==true){
                    duplicado=new EmpleadoDao().verificarAlmuerzo(comedor.getCi());
                    if(duplicado==false){
                        new EmpleadoDao().almuerzo(ControlHora.getDia(), comedor.getCi());
                        comedor.exito();
                        comedor.limpiar();
                    }
                    else
                    {
                        comedor.errorDuplicado();
                        comedor.limpiar();
                    }
                }
                else{
                    duplicado=new EmpleadoDao().verificarCena(comedor.getCi());
                    if(duplicado==false){
                        new EmpleadoDao().cena(ControlHora.getDia(), comedor.getCi());
                        comedor.exito();
                        comedor.limpiar();
                    }
                    else
                    {
                        comedor.errorDuplicado();
                        comedor.limpiar();
                    }
                }
            }
            else
            {
                comedor.errorFueraHorario();
                comedor.limpiar();
            
            }
            
        }
        else
        {
            comedor.noExisteCi();
            comedor.limpiar();
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
        vacacion.dispose();
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
