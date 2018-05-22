package com.proyecto.colmenial.repository;


import com.proyecto.colmenial.model.Apuntes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApuntesRepository extends JpaRepository<Apuntes, Integer> {
    public List<Apuntes> findByAsignatura(String asignatura);
    public Apuntes findById(int id);
    public Apuntes findByTitulo(String titulo);
    public List<Apuntes> findByCreador(int id);
}


