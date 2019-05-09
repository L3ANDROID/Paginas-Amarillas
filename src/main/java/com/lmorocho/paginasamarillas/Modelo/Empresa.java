package com.lmorocho.paginasamarillas.Modelo;

public class Empresa {
    private Integer id;
    private String nombre;
    private String direccion;
    private Integer telefono;
    private String correo;
    private String categoria;
    private String info;
    private String picture;

    public Empresa() {
    }

    public Empresa(Integer id, String nombre, String direccion, Integer telefono,String correo, String categoria, String info, String picture) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.categoria = categoria;
        this.info = info;
        this.picture = picture;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }

    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Integer getTelefono() { return telefono; }

    public void setTelefono(Integer telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }

    public void setCorreo(String correo) { this.correo = correo; }

    public String getCategoria() { return categoria; }

    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getInfo() { return info; }

    public void setInfo(String info) { this.info = info; }

    public String getPicture() { return picture; }

    public void setPicture(String picture) { this.picture = picture; }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", categoria='" + categoria + '\'' +
                ", info='" + info + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
