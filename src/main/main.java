
package main;

import Controlador.Conector;
import Controlador.ControlInterfaz;
import vista.Ventanta;
public class main {
    public static void main(String args[])
    {
        Ventanta v=new Ventanta();
        ControlInterfaz c=new ControlInterfaz(v);
        v.setControlador(c);      
    }
}
