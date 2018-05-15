package com.proyecto.colmenial.controller;

import com.proyecto.colmenial.model.Asignaturas;
import com.proyecto.colmenial.model.GradosAsignaturas;
import com.proyecto.colmenial.repository.AsignaturasRepository;
import com.proyecto.colmenial.repository.GradosAsignaturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/colmenial")
public class GradosAsignaturasController {
    @Autowired
    GradosAsignaturasRepository gradosAsignaturasRepository;
    @Autowired
    AsignaturasRepository asignaturasRepository;


    @GetMapping("/gradosasignaturas")
    public List<GradosAsignaturas> getAllAsignaturas() {
        return gradosAsignaturasRepository.findAll();
    }

    @PostMapping("/gradosasignaturas")
    public GradosAsignaturas createGradoAsignatura(@Valid @RequestBody GradosAsignaturas gradosAsignaturas) {

        return gradosAsignaturasRepository.save(gradosAsignaturas);
    }

    @GetMapping("/gradosasignaturas/asignatura/{codigo}")
    public GradosAsignaturas getGradosAsignaturasByIdAsignatura(@PathVariable(value = "codigo") String codigo) {
        return gradosAsignaturasRepository.findByAsignatura(codigo);
    }

    @GetMapping("/gradosasignaturas/grado/{id}")
    public List<Asignaturas> getGradosAsignaturasByIdGrado(@PathVariable(value = "id") int id) {
        List<GradosAsignaturas> gradosAsignaturas = gradosAsignaturasRepository.findByGrado(id);
        List<Asignaturas>listaAsignaturas = new ArrayList<Asignaturas>();
        for (int i=0; i<gradosAsignaturas.size();i++) {
            listaAsignaturas.add(asignaturasRepository.findOne(gradosAsignaturas.get(i).getAsignaturas()));
        }
        return listaAsignaturas;
        }

    @PutMapping("/gradosasignaturas/{codigo}")
    public GradosAsignaturas updateGradosAsignaturas(@PathVariable(value = "codigo") String codigo, @Valid @RequestBody GradosAsignaturas gradosAsignaturasDetails) {
        GradosAsignaturas gradosAsignaturas = gradosAsignaturasRepository.findOne(codigo);

        gradosAsignaturas.setAsignaturas(gradosAsignaturas.getAsignaturas());
        gradosAsignaturas.setGrados(gradosAsignaturas.getGrados());
        GradosAsignaturas updatedGradosAsignaturas = gradosAsignaturasRepository.save(gradosAsignaturas);
        return updatedGradosAsignaturas;
    }

    @DeleteMapping("/gradosasignaturas/{codigo}")
    public ResponseEntity<?> deleteGradosAsignaturas(@PathVariable(value = "codigo") String codigo) {
        GradosAsignaturas gradosAsignaturas = gradosAsignaturasRepository.findOne(codigo);
        gradosAsignaturasRepository.delete(gradosAsignaturas);
        return ResponseEntity.ok().build();
    }
}