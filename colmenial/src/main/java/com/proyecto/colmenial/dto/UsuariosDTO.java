package com.proyecto.colmenial.dto;

import java.util.List;

public class UsuariosDTO extends UsuariosBasicDTO {
    private List<ApuntesDTO> apuntes;

    public List<ApuntesDTO> getApuntes() {
        return apuntes;
    }

    public void setApuntes(List<ApuntesDTO> apuntes) {
        this.apuntes = apuntes;
    }

    public UsuariosDTO(List<ApuntesDTO> apuntes) {
        super();
        this.apuntes = apuntes;
    }

    public UsuariosDTO() {
        super();
    }


}
