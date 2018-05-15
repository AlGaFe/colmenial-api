package com.proyecto.colmenial.repository;

import com.proyecto.colmenial.model.GradosAsignaturas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradosAsignaturasRepository extends JpaRepository<GradosAsignaturas, String> {
    public List<GradosAsignaturas> findByGrado(int id);
    public GradosAsignaturas findByAsignatura(String codigo);
}