package com.proyecto.colmenial.controller;

import com.proyecto.colmenial.model.Apuntes;
import com.proyecto.colmenial.model.Asignaturas;
import com.proyecto.colmenial.repository.ApuntesRepository;
import com.proyecto.colmenial.repository.AsignaturasRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/colmenial")
public class ApuntesController {
    @Autowired
    ApuntesRepository apuntesRepository;
    @Autowired
    AsignaturasRepository asignaturasRepository;

    @GetMapping("/apuntes")
    public List<Apuntes> getAllApuntes() {

        return apuntesRepository.findAll();
    }

    @PostMapping("/apuntes")
    public Apuntes createApunte(@Valid @RequestBody Apuntes apunte) {

        return apuntesRepository.save(apunte);
    }

    @GetMapping("/apuntes/id/{id}")
    public Apuntes getApunteById(@PathVariable(value = "id") int id) {

        return apuntesRepository.findById(id);
    }

    @GetMapping("/apuntes/asignatura/{codigo}")
    public List<Apuntes> getApunteByAsignatura(@PathVariable(value = "codigo") String codigo) {
        return apuntesRepository.findByAsignatura(codigo);
    }

    @PutMapping("/apuntes/{id}")
    public Apuntes updateApunte(@PathVariable(value = "id") int id, @Valid @RequestBody Apuntes apunteDetails) {
        Apuntes apunte = apuntesRepository.findOne(id);

        apunte.setTitulo(apunteDetails.getTitulo());
        apunte.setDescripcion(apunteDetails.getDescripcion());
        apunte.setAsignatura(apunteDetails.getAsignatura());
        apunte.setCreador(apunteDetails.getCreador());
        apunte.setPrecio(apunteDetails.getPrecio());

        Apuntes updatedApunte = apuntesRepository.save(apunte);
        return updatedApunte;
    }

    @DeleteMapping("/apuntes/{id}")
    public ResponseEntity<?> deleteApunte(@PathVariable(value = "id") int id) {
        Apuntes apunte = apuntesRepository.findOne(id);
        apuntesRepository.delete(apunte);
        return ResponseEntity.ok().build();
    }
}
