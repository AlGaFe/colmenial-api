package com.proyecto.colmenial.services.impl;

import com.proyecto.colmenial.dto.AsignaturasDTO;
import com.proyecto.colmenial.dto.GradosBasicDTO;
import com.proyecto.colmenial.model.Asignaturas;
import com.proyecto.colmenial.model.Grados;
import com.proyecto.colmenial.repository.AsignaturasRepository;
import com.proyecto.colmenial.repository.GradosRepository;
import com.proyecto.colmenial.services.AsignaturasServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AsignaturasServicesImpl implements AsignaturasServices {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AsignaturasRepository asignaturasRepository;

    @Autowired
    GradosRepository gradosRepository;


    @Override
    public AsignaturasDTO findByCodigo(String codigo) {
        Asignaturas asignatura = asignaturasRepository.findByCodigo(codigo);
        return modelMapper.map(asignatura,AsignaturasDTO.class);
    }

    @Override
    public List<AsignaturasDTO> findAll() {
        List<Asignaturas> asignaturas = asignaturasRepository.findAll();
        List<AsignaturasDTO> asignaturasDTO = new ArrayList<AsignaturasDTO>();
        for(Asignaturas asignatura : asignaturas){
           AsignaturasDTO asignaturaDTO = modelMapper.map(asignatura,AsignaturasDTO.class);
            asignaturasDTO.add(asignaturaDTO);
        }
        return asignaturasDTO;
    }

    @Override
    public AsignaturasDTO findByNombre(String nomrbe) {
        Asignaturas asignatura = asignaturasRepository.findByNombre(nomrbe);
        return modelMapper.map(asignatura,AsignaturasDTO.class);
    }

    @Override
    public List<AsignaturasDTO> findByGrados_Id(int id) {
        List<Asignaturas> asignaturas = asignaturasRepository.findByGrados_Id(id);
        List<AsignaturasDTO>asignaturasDTO = new ArrayList<AsignaturasDTO>();
        for(Asignaturas asignatura : asignaturas){
            AsignaturasDTO asignaturaDTO = modelMapper.map(asignatura,AsignaturasDTO.class);
            asignaturasDTO.add(asignaturaDTO);
        }
        return asignaturasDTO;
    }

    @Override
    public Asignaturas addAsignaturas(Asignaturas asignatura) {
        for(Grados grado : asignatura.getGrados()){
            System.out.print(grado.getId());
          grado=gradosRepository.findById(grado.getId());
          grado.getAsignaturas().add(asignatura);
          gradosRepository.saveAndFlush(grado);
        }
        return  asignaturasRepository.save(asignatura);
    }
}
