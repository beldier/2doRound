/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author gio
 */
public class Instancia {
    private int n;
    private int codigoSis;
    private String materia;

    public void setN(int n) {
        this.n = n;
    }

    public void setCodigoSis(int codigoSis) {
        this.codigoSis = codigoSis;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }

    public int getN() {
        return n;
    }

    public int getCodigoSis() {
        return codigoSis;
    }

    public String getMateria() {
        return materia;
    }

    public int getNota() {
        return nota;
    }

    public String getHabilitado() {
        return habilitado;
    }
    private int nota;
    private String habilitado;
}
