package com.proyecto.colmenial.repository;

import com.proyecto.colmenial.model.Asignaturas;
import com.proyecto.colmenial.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignaturasRepository extends JpaRepository<Asignaturas, String> {
    public Asignaturas findByCodigo(String codigo);
    public Asignaturas findByNombre(String nombre);
    public List<Asignaturas> findByGrados_Id(int id);
}


