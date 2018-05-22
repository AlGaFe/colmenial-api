package com.proyecto.colmenial.controller;

import com.proyecto.colmenial.model.Universidades;
import com.proyecto.colmenial.repository.UniversidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/colmenial")
public class UniversidadesController {

    @Autowired
    UniversidadesRepository universidadesRepository;

    @GetMapping("/universidades")
    public List<Universidades> getAllUniversidades() {
        return universidadesRepository.findAll();
    }

    @PostMapping("/universidades")
    public Universidades createUniversidad(@Valid @RequestBody Universidades univesidad) {

        return universidadesRepository.save(univesidad);
    }

    @GetMapping("/universidades/{id}")
    public Universidades getUniversidadesById(@PathVariable(value = "id") int id) {
        return universidadesRepository.findById(id);
    }


    @PutMapping("/universidades/{id}")
    public Universidades updateUnivesidades(@PathVariable(value = "id") int id, @Valid @RequestBody Universidades universidadDetails) {
        Universidades universidad = universidadesRepository.findOne(id);

        universidad.setNombre(universidadDetails.getNombre());

        Universidades updateUniversidad = universidadesRepository.save(universidad);
        return updateUniversidad;
    }

    @DeleteMapping("/universidades/{id}")
    public ResponseEntity<?> deleteUniversidad(@PathVariable(value = "id") int id) {
        Universidades universidad = universidadesRepository.findOne(id);
        universidadesRepository.delete(universidad);
        return ResponseEntity.ok().build();
    }

}
