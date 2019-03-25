package com.example.terretaurbana.Modelos;

public class Noticia
{
    String imagen;
    String descripcion;

    public Noticia() {
    }

    public Noticia(String imagen, String descripcion) {
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
