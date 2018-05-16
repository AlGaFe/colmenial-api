package com.proyecto.colmenial.dto;

import java.util.List;

public class UniversidadesDTO {
    private int id;
    private String nombre;
    private List<GradosBasicDTO> asignaturas;
    public int getId() {
        return id;
    }

    public List<GradosBasicDTO> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<GradosBasicDTO> asignaturas) {
        this.asignaturas = asignaturas;
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

    public UniversidadesDTO() {
        super();
    }

    public UniversidadesDTO(int id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }
}
