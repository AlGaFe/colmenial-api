package com.proyecto.colmenial.repository;

import com.proyecto.colmenial.model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {

}

