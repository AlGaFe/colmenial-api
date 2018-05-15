package com.proyecto.colmenial.repository;

import com.proyecto.colmenial.model.LineaPedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineaPedidosRepository extends JpaRepository<LineaPedidos, Integer> {

}
