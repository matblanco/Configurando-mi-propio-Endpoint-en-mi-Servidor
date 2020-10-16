package com.andromotica.petagram.pojo;

public class MiPet {

    String id;
    String nombre;
    String foto;
    String descripcion;
    String fechaPost;



    public MiPet(String nombre, String foto, String descripcion, String fechaPost) {
        this.nombre = nombre;
        this.foto = foto;
        this.descripcion = descripcion;
        this.fechaPost = fechaPost;
    }

    public MiPet() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaPost() {
        return fechaPost;
    }

    public void setFechaPost(String fechaPost) {
        this.fechaPost = fechaPost;
    }
}
