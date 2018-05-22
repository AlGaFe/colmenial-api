package com.proyecto.colmenial.services;

import com.proyecto.colmenial.dto.GradosDTO;

import java.util.List;

public interface GradosServices {
    public GradosDTO findByID(int id);

    public List<GradosDTO> findAll();

    public GradosDTO findByNombre(String nomrbe);

    public List<GradosDTO> findByUniversidades_Id(int id);
}
