package com.proyecto.colmenial.controller;

import com.proyecto.colmenial.model.Asignaturas;
import com.proyecto.colmenial.repository.AsignaturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/colmenial")
public class AsignaturasController {
    @Autowired
    AsignaturasRepository asignaturasRepository;

    @GetMapping("/asignaturas")
    public List<Asignaturas> getAllAsignaturas() {
        return asignaturasRepository.findAll();
    }

    @PostMapping("/asignaturas")
    public Asignaturas createAsignatura(@Valid @RequestBody Asignaturas asignatura) {

        return asignaturasRepository.save(asignatura);
    }

    @GetMapping("/asignaturas/{codigo}")
    public Asignaturas getAsignaturaById(@PathVariable(value = "codigo") String codigo) {
        return asignaturasRepository.findOne(codigo);
    }

    @PutMapping("/asignaturas/{codigo}")
    public Asignaturas updateAsignaturas(@PathVariable(value = "codigo") String codigo, @Valid @RequestBody Asignaturas asignaturaDetails) {
        Asignaturas asignatura = asignaturasRepository.findOne(codigo);

        asignatura.setCodigo(asignaturaDetails.getCodigo());
        asignatura.setNombre(asignaturaDetails.getNombre());

        Asignaturas updatedAsignatura = asignaturasRepository.save(asignatura);
        return updatedAsignatura;
    }

    @DeleteMapping("/asignaturas/{codigo}")
    public ResponseEntity<?> deleteAsignatura(@PathVariable(value = "codigo") String codigo) {
        Asignaturas asignatura = asignaturasRepository.findOne(codigo);
        asignaturasRepository.delete(asignatura);
        return ResponseEntity.ok().build();
    }
}