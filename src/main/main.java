
package main;

import Controlador.Conector;
import Controlador.ControlInterfaz;
import vista.SeleccionFuncion;
public class main {
    public static void main(String args[])
    {
        SeleccionFuncion s=new SeleccionFuncion();
        ControlInterfaz c=new ControlInterfaz(s);
        s.setControlador(c);      
    }
}
