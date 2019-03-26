package com.example.terretaurbana.Modelos;

public class ResultadoCoreo
{
    String posicion;
    String nombre;

    public ResultadoCoreo() {
    }

    public ResultadoCoreo(String posicion, String nombre) {
        this.posicion = posicion;
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
