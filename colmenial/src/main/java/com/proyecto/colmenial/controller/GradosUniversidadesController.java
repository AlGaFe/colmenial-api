package com.proyecto.colmenial.controller;

import com.proyecto.colmenial.model.Grados;
import com.proyecto.colmenial.model.GradosUniversidades;
import com.proyecto.colmenial.repository.GradosRepository;
import com.proyecto.colmenial.repository.GradosUniversidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/colmenial")
public class GradosUniversidadesController {
    @Autowired
    GradosUniversidadesRepository gradosUniversidadesRepository;
    @Autowired
    GradosRepository gradosRepository;

    @GetMapping("/gradosUniversidades")
    public List<GradosUniversidades> getAllGradosUniversidades() {
        return gradosUniversidadesRepository.findAll();
    }

    @PostMapping("/gradosUniversidades")
    public GradosUniversidades createGradosUniversidades(@Valid @RequestBody GradosUniversidades gradosUniversidades) {
        return gradosUniversidadesRepository.save(gradosUniversidades);
    }

    @GetMapping("/gradosUniversidades/grado/{id}")
    public GradosUniversidades getGradosUniversidadesByIdGrado(@PathVariable(value = "id") int id) {
        return  gradosUniversidadesRepository.findByGrado(id);
    }

    @GetMapping("/gradosUniversidades/univesidad/{id}")
    public List<Grados> getGradosUniversidadesByIdUniversidad(@PathVariable(value = "id") int id) {

        List<GradosUniversidades> gradoUniversidades=gradosUniversidadesRepository.findByUniversidad(id);
        List<Grados>listagrados = new ArrayList<Grados>() ;
        for (int i=0; i<gradoUniversidades.size();i++) {
            listagrados.add(gradosRepository.findById(gradoUniversidades.get(i).getGrado()));
        }
        return listagrados;
    }

    @PutMapping("/gradosUniversidades/{id}")
    public GradosUniversidades updateGradosUniversidades(@PathVariable(value = "id") int id, @Valid @RequestBody GradosUniversidades gradosUniversidadesDetails) {
        GradosUniversidades gradosUniversidades = gradosUniversidadesRepository.findOne(id);

        gradosUniversidades.setGrado(gradosUniversidades.getGrado());
        gradosUniversidades.setGrado(gradosUniversidades.getGrado());
        GradosUniversidades updatedGradosUniversidades = gradosUniversidadesRepository.save(gradosUniversidades);
        return updatedGradosUniversidades;
    }

    @DeleteMapping("/gradosUniversidades/{id}")
    public ResponseEntity<?> deleteGradosUniversidades(@PathVariable(value = "id") int id) {
        GradosUniversidades gradosUniversidades = gradosUniversidadesRepository.findOne(id);
        gradosUniversidadesRepository.delete(gradosUniversidades);
        return ResponseEntity.ok().build();
    }
}