package com.proyecto.colmenial.services;

import com.proyecto.colmenial.dto.AsignaturasDTO;
import com.proyecto.colmenial.model.Asignaturas;

import java.util.List;

public interface AsignaturasServices {
    public AsignaturasDTO findByCodigo(String codigo);

    public List<AsignaturasDTO> findAll();

    public AsignaturasDTO findByNombre(String nomrbe);

    public List<AsignaturasDTO> findByGrados_Id(int id);

    public Asignaturas addAsignaturas(Asignaturas asignatura);
}
