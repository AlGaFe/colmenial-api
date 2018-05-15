package com.proyecto.colmenial.repository;

import com.proyecto.colmenial.model.Grados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradosRepository extends JpaRepository<Grados, Integer> {
    public Grados findById(int id);
}