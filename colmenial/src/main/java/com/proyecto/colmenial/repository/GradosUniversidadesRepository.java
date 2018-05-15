package com.proyecto.colmenial.repository;

import com.proyecto.colmenial.controller.GradosController;
import com.proyecto.colmenial.model.GradosUniversidades;
import com.proyecto.colmenial.model.Grados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradosUniversidadesRepository extends JpaRepository<GradosUniversidades, Integer> {
    public List<GradosUniversidades> findByUniversidad(int id);
    public GradosUniversidades findByGrado(int id);
}