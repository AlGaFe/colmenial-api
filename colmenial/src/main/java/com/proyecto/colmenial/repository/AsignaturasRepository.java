package com.proyecto.colmenial.repository;

import com.proyecto.colmenial.model.Asignaturas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturasRepository extends JpaRepository<Asignaturas, String> {

}


