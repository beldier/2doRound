/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ASUS
 */
public class trabajador {
    String cod_empleado;
    String ciempleado;
    String nombre;
    String apellido;
    String fecha;
    String hora;
    
    public trabajador(){
        cod_empleado="";
        ciempleado="";
        nombre="";
        apellido="";
        hora="";
        fecha="";
    
    } 

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(String cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    public String getCiempleado() {
        return ciempleado;
    }

    public void setCiempleado(String ciempleado) {
        this.ciempleado = ciempleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
}
