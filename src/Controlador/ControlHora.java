/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author lurianne
 */
public abstract class ControlHora {
    public static boolean saleAntes(Date horaActual)
    {
        Calendar cal = Calendar.getInstance();  
        cal.setTime(new Date());  
        cal.set(Calendar.HOUR_OF_DAY, 19);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);
        Date horaSalida=cal.getTime();
        boolean ans=false;
        if(horaActual.before(horaSalida)){
            ans=true;
        }
        return ans;
    }
    public static boolean entraDespues(Date horaActual)
    {
        Calendar cal = Calendar.getInstance();  
        cal.setTime(new Date());  
        cal.set(Calendar.HOUR_OF_DAY, 19);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);
        Date horaEntrada=cal.getTime();
        boolean ans=false;
        if(horaActual.after(horaEntrada)){
            ans=true;
        }
        return ans;
    }
    public static String getDia()
    {
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        return df.format(date);
    }
    public static boolean horaAlmuerzo(Date horaActual)
    {
        Calendar cal = Calendar.getInstance();  
        cal.setTime(new Date());  
        cal.set(Calendar.HOUR_OF_DAY, 11);  
        cal.set(Calendar.MINUTE, 00);  
        cal.set(Calendar.SECOND, 0);
        Date horaInicio=cal.getTime();
        cal.set(Calendar.HOUR_OF_DAY, 14);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);
        Date horaFin=cal.getTime();  
        boolean ans=true;
        if(horaActual.before(horaInicio)||horaActual.after(horaFin))
            ans=false;
        return ans;
    }
    public static boolean horaCena(Date horaActual)
    {
        Calendar cal = Calendar.getInstance();  
        cal.setTime(new Date());  
        cal.set(Calendar.HOUR_OF_DAY, 17);  
        cal.set(Calendar.MINUTE, 00);  
        cal.set(Calendar.SECOND, 0);
        Date horaInicio=cal.getTime();
        cal.set(Calendar.HOUR_OF_DAY, 19);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);
        Date horaFin=cal.getTime();  
        boolean ans=true;
        if(horaActual.before(horaInicio)||horaActual.after(horaFin))
            ans=false;
        return ans;
    }
}
