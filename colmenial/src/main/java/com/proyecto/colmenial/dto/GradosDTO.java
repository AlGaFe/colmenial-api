package com.proyecto.colmenial.dto;

import java.util.List;

public class GradosDTO extends GradosBasicDTO {
    private List<AsignaturasBasicDTO> asignaturas;

    public List<AsignaturasBasicDTO> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<AsignaturasBasicDTO> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public GradosDTO(List<AsignaturasBasicDTO> asignaturas) {
        super();
        this.asignaturas = asignaturas;
    }

    public GradosDTO() {
        super();
    }

}
