package com.proyecto.colmenial.services.impl;

import com.proyecto.colmenial.dto.ApuntesDTO;
import com.proyecto.colmenial.model.Apuntes;
import com.proyecto.colmenial.repository.ApuntesRepository;
import com.proyecto.colmenial.services.ApuntesServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ApuntesServicesImpl implements ApuntesServices {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ApuntesRepository apuntesRepository;

    @Override
    public ApuntesDTO findByID(int id) {
        Apuntes apuntes = apuntesRepository.findById(id);
        return modelMapper.map(apuntes,ApuntesDTO.class);
    }

    @Override
    public ApuntesDTO findByTitulo(String titulo) {
        Apuntes apunte = apuntesRepository.findByTitulo(titulo);
        return modelMapper.map(apunte,ApuntesDTO.class);
    }

    @Override
    public List<ApuntesDTO> findAll() {
        List<Apuntes>apuntes = apuntesRepository.findAll();
        List<ApuntesDTO>apuntesDTO = new ArrayList<>();
        for(Apuntes apunte : apuntes){
            ApuntesDTO apunteDTO = modelMapper.map(apunte,ApuntesDTO.class);
            apuntesDTO.add(apunteDTO);
        }
        return apuntesDTO;
    }

    @Override
    public List<ApuntesDTO> findByAsignatura(String codigo) {
        List<Apuntes>apuntes = apuntesRepository.findByAsignatura(codigo);
        List<ApuntesDTO> apuntesDTO=new ArrayList<>();
        for(Apuntes apunte : apuntes){
            ApuntesDTO apunteDTO = modelMapper.map(apunte,ApuntesDTO.class);
            apuntesDTO.add(apunteDTO);
        }
        return apuntesDTO;
    }

    @Override
    public List<ApuntesDTO> findByCreadir(int id) {
        List<Apuntes>apuntes = apuntesRepository.findByCreador(id);
        List<ApuntesDTO> apuntesDTO=new ArrayList<>();
        for(Apuntes apunte : apuntes){
            ApuntesDTO apunteDTO = modelMapper.map(apunte,ApuntesDTO.class);
            apuntesDTO.add(apunteDTO);
        }
        return apuntesDTO;
    }
}
