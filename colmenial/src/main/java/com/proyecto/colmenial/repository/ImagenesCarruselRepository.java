package com.proyecto.colmenial.repository;

import com.proyecto.colmenial.model.ImagenesCarrusel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenesCarruselRepository extends JpaRepository<ImagenesCarrusel, Integer> {

}
