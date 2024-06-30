package com.example.laboratorio.entidades;

public class Videojuego {
    private Integer id;
    private String consola;
    private String nombre;
    private String genero;
    private String clasificacion;
    private String descripcion;
    private Integer id_desarrollador;
    private Integer id_distribuidor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId_desarrollador() {
        return id_desarrollador;
    }

    public void setId_desarrollador(Integer id_desarrollador) {
        this.id_desarrollador = id_desarrollador;
    }

    public Integer getId_distribuidor() {
        return id_distribuidor;
    }

    public void setId_distribuidor(Integer id_distribuidor) {
        this.id_distribuidor = id_distribuidor;
    }
}