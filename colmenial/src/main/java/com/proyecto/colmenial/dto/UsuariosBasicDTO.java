package com.proyecto.colmenial.dto;

import java.util.Date;

public class UsuariosBasicDTO {
    private int id;

    private String nombre;

    private String password;

    private Date fechaNacimieto;

    private String email;

    private String imagenPeril;

    private String direccion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaNacimieto() {
        return fechaNacimieto;
    }

    public void setFechaNacimieto(Date fechaNacimieto) {
        this.fechaNacimieto = fechaNacimieto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagenPeril() {
        return imagenPeril;
    }

    public void setImagenPeril(String imagenPeril) {
        this.imagenPeril = imagenPeril;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public UsuariosBasicDTO() {
    }

    public UsuariosBasicDTO(int id, String nombre, String password, Date fechaNacimieto, String email, String imagenPeril, String direccion) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.fechaNacimieto = fechaNacimieto;
        this.email = email;
        this.imagenPeril = imagenPeril;
        this.direccion = direccion;
    }
}
