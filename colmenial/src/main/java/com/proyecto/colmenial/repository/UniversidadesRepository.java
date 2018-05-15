package com.proyecto.colmenial.repository;

import com.proyecto.colmenial.model.Universidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversidadesRepository extends JpaRepository<Universidades, Integer> {

}