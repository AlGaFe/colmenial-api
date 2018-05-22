package com.proyecto.colmenial.controller;

import com.proyecto.colmenial.dto.AsignaturasDTO;
import com.proyecto.colmenial.model.Asignaturas;
import com.proyecto.colmenial.repository.AsignaturasRepository;
import com.proyecto.colmenial.services.AsignaturasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/colmenial")
public class AsignaturasController {
    @Autowired
    AsignaturasRepository asignaturasRepository;

    @Autowired
    AsignaturasServices asignaturasServices;

    @GetMapping("/asignaturas")
    public List<AsignaturasDTO> getAllAsignaturas() {
        return asignaturasServices.findAll();
    }

    @PostMapping("/asignaturas")
    public Asignaturas createAsignatura(@Valid @RequestBody Asignaturas asignatura) {
        return asignaturasRepository.save(asignatura);
    }

    @GetMapping("/asignaturas/codigo/{codigo}")
    public AsignaturasDTO getAsignaturaById(@PathVariable(value = "codigo") String codigo) {
        return asignaturasServices.findByCodigo(codigo);
    }
    @GetMapping("/asignaturas/nombre/{nombre}")
    public AsignaturasDTO getAsignaturaByNombre(@PathVariable(value = "nombre") String nombre) {
        return asignaturasServices.findByNombre(nombre);
    }
    @GetMapping("/asignaturas/grado/{id}")
    public List<AsignaturasDTO> getAsignaturaByGrado(@PathVariable(value = "id") int id) {
        return asignaturasServices.findByGrados_Id(id);
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