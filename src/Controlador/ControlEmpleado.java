/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Dao.EmpleadoDao;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author lurianne
 */
public abstract class ControlEmpleado {
    public static boolean verificarSalidaPrevia(int ci)
    {
        boolean ans=false;
        String dia=ControlHora.getDia();
        if(new EmpleadoDao().getSalida(dia,ci)!=null)
            ans=true;
        return ans;
    }
    
    
}
