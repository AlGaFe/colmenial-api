package com.proyecto.colmenial.controller;

import com.proyecto.colmenial.dto.GradosDTO;
import com.proyecto.colmenial.model.Grados;
import com.proyecto.colmenial.repository.GradosRepository;
import com.proyecto.colmenial.services.GradosServices;
import com.proyecto.colmenial.services.impl.GradosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/colmenial")
public class GradosController {
    @Autowired
    GradosRepository gradosRepository;

    @Autowired
   GradosServices gradosService;

    @GetMapping("/grados")
    public List<GradosDTO> getAllGrados() {
        return gradosService.findAll();
    }

    @PostMapping("/grados")
    public Grados createGrado(@Valid @RequestBody Grados grado) { return gradosRepository.save(grado);}

    @GetMapping("/grados/id/{id}")
    public GradosDTO getGradosById(@PathVariable(value = "id") int id) {return gradosService.findByID(id);}

    @GetMapping("/grados/nombre/{nombre}")
    public GradosDTO getGradosByNombre(@PathVariable(value = "nombre") String nombre) {return gradosService.findByNombre(nombre);}

    @GetMapping("/grados/universidad/{id}")
    public List<GradosDTO> getGradosByUniversidad(@PathVariable(value = "id") int id) {return gradosService.findByUniversidades_Id(id);}

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