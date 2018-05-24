
package vista;

import Controlador.ControlInterfaz;

public interface InterfazVista {
   
    void setControlador(ControlInterfaz c);
    void init();
    
    static final String INGRESACLIENTE="Ingresa cliente";
    
}
