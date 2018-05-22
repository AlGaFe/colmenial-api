package com.proyecto.colmenial.services.impl;

import com.proyecto.colmenial.dto.GradosDTO;
import com.proyecto.colmenial.model.Grados;
import com.proyecto.colmenial.repository.GradosRepository;
import com.proyecto.colmenial.services.GradosServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GradosServiceImpl implements GradosServices {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    GradosRepository gradosRepository;

    @Override
    public GradosDTO findByID(int id) {
        Grados grado = gradosRepository.findById(id);
        GradosDTO gradoDTO = modelMapper.map(grado, GradosDTO.class);
        return gradoDTO;
    }

    @Override
    public List<GradosDTO> findAll() {
        List<Grados> grados = gradosRepository.findAll();
        List<GradosDTO> gradosDTO = new ArrayList<GradosDTO>();
        for(Grados grado : grados){
            GradosDTO gradoDTO = modelMapper.map(grado, GradosDTO.class);
            gradosDTO.add(gradoDTO);
        }
        return gradosDTO;
    }

    @Override
    public GradosDTO findByNombre(String nomrbe) {
        Grados grado = gradosRepository.findByNombre(nomrbe);
        GradosDTO gradoDTO = modelMapper.map(grado,GradosDTO.class);
        return gradoDTO;
    }

    @Override
    public List<GradosDTO> findByUniversidades_Id(int id) {
        List<Grados> grados = gradosRepository.findByUniversidades_Id(id);
        List<GradosDTO> gradosDTO = new ArrayList<GradosDTO>();
        for(Grados grado : grados){
            GradosDTO gradoDTO = modelMapper.map(grado, GradosDTO.class);
            gradosDTO.add(gradoDTO);
        }
        return gradosDTO;
    }
}
