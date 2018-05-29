/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author lurianne
 */
public abstract class ControlVacacion {
    
    public static int getDias(int diff)
    {
        int dias=0;
        if(diff>0){
            if(diff>10)
                dias=dias+((diff-10)*30)+100+75;
            if(diff>5&&diff<=10)
                dias=dias+((diff-5)*20)+75;
            if(diff>0&&diff<=5)
                dias=dias+(diff*15);
        }
        return dias;
    }
    public static int getDiferencia(Date actual,Date contratacion)
    {
        Calendar a= getCalendar(contratacion);
        Calendar b= getCalendar(actual);
        int diff=b.get(Calendar.YEAR)-a.get(Calendar.YEAR);
        if(a.get(Calendar.MONTH)> b.get(Calendar.MONTH) || ( a.get(Calendar.MONTH)== b.get(Calendar.MONTH)&& a.get(Calendar.DAY_OF_MONTH)>b.get(Calendar.DAY_OF_MONTH)) )
            diff--;        
        return diff;
    }
    private static Calendar getCalendar(Date date)
    {
        Calendar cal= Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
        
    }
    
    
}
