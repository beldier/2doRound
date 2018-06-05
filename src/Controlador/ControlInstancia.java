/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Dao.InstanciaDao;
import Modelo.Instancia;
import java.util.ArrayList;

/**
 *
 * @author gio
 */
public abstract class ControlInstancia {
     public static boolean existe=false;
    public static ArrayList<Instancia> verificarExistencia(String materiaSol,String docenteSol)
    {      
        ArrayList<Instancia> res=null;
       if (!materiaSol.equals("")&& !docenteSol.equals("")){
       res=InstanciaDao.setFilas(materiaSol,docenteSol);          
       }else{   
           existe =false;           
       }       
       return res;
    }
}
