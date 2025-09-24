package com.tecsup.semana_05.model.entities;

public class Curso {
    private String codigo;
    private String nombre;
    private int creditos;

    public Curso() {}

    public Curso(String chrCurCodigo, String vchCurNombre, int intCurCreditos) {
        this.codigo = chrCurCodigo;
        this.nombre = vchCurNombre;
        this.creditos = intCurCreditos;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
}
