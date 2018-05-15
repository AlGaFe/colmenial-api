package com.proyecto.colmenial.controller;

import com.proyecto.colmenial.model.Grados;
import com.proyecto.colmenial.repository.GradosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/colmenial")
public class GradosController {
    @Autowired
    GradosRepository gradosRepository;

    @GetMapping("/grados")
    public List<Grados> getAllGrados() {
        return gradosRepository.findAll();
    }

    @PostMapping("/grados")
    public Grados createGrado(@Valid @RequestBody Grados grado) {

        return gradosRepository.save(grado);
    }

    @GetMapping("/grados/{id}")
    public Grados getGradosById(@PathVariable(value = "id") int id) {
        return gradosRepository.findOne(id);
    }

    @PutMapping("/grados/{id}")
    public Grados updateGrados(@PathVariable(value = "id") int id, @Valid @RequestBody Grados gradoDetails) {
        Grados grado = gradosRepository.findOne(id);

        grado.setNombre(grado.getNombre());

        Grados updatedGrado = gradosRepository.save(grado);
        return updatedGrado;
    }

    @DeleteMapping("/grados/{id}")
    public ResponseEntity<?> deleteGrados(@PathVariable(value = "id") int id) {
        Grados grado = gradosRepository.findOne(id);
        gradosRepository.delete(grado);
        return ResponseEntity.ok().build();
    }
}