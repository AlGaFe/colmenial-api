package com.proyecto.colmenial.services;

import com.proyecto.colmenial.dto.ApuntesDTO;

import java.util.List;

public interface ApuntesServices {
    public ApuntesDTO findByID(int id);

    public ApuntesDTO findByTitulo(String titulo);

    public List<ApuntesDTO> findAll();

    public List<ApuntesDTO> findByAsignatura(String codigo);

    public List<ApuntesDTO> findByCreadir(int id);
}
