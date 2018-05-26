
package Modelo;

public class Empleado {
    private String ci;
    private String nombre;
    private String apellido;
    private String fecha_nac;
    private String genero;
    private int edad;




    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCi()
    {
        return ci;
    }
    public String getNombre()
    {
        return nombre;
    }
    public String getApellido()
    {
        return apellido;
    }
    public int getEdad()
    {
        return edad;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }
    
    public String getFullName(){
        return this.nombre.trim() + " " + this.apellido.trim();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
