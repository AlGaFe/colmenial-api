package com.proyecto.colmenial.dto;

import java.util.List;
public class AsignaturasDTO extends AsignaturasBasicDTO {
    private List<GradosBasicDTO> grados;

    public List<GradosBasicDTO> getGrados() {
        return grados;
    }

    public void setGrados(List<GradosBasicDTO> grados) {
        this.grados = grados;
    }

    public AsignaturasDTO() {
    }

    public AsignaturasDTO(String codigo, String nombre) {super(codigo, nombre);}
}
