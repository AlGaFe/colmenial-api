package com.proyecto.colmenial.repository;

import com.proyecto.colmenial.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios,Integer> {
    public List<Usuarios> findByNombre(String nombre);
}
