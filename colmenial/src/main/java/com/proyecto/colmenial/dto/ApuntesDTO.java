package com.proyecto.colmenial.dto;


import java.util.Date;

public class ApuntesDTO {
    private int id;
    private String descripcion;
    private Date fecha;
    private AsignaturasBasicDTO asignatura;
    private double precio;
    private int creador;
    private int valoracion;
    private String titulo;
    private String imagen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public AsignaturasBasicDTO getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(AsignaturasBasicDTO asignatura) {
        this.asignatura = asignatura;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCreador() {
        return creador;
    }

    public void setCreador(int creador) {
        this.creador = creador;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public ApuntesDTO() {
    }

    public ApuntesDTO(int id, String descripcion, Date fecha, AsignaturasBasicDTO asignatura, double precio, int creador, int valoracion, String titulo, String imagen) {
        super();
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.asignatura = asignatura;
        this.precio = precio;
        this.creador = creador;
        this.valoracion = valoracion;
        this.titulo = titulo;
        this.imagen = imagen;
    }
}
