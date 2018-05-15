package com.proyecto.colmenial.controller;

import com.proyecto.colmenial.model.ImagenesCarrusel;
import com.proyecto.colmenial.repository.ImagenesCarruselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/colmenial")
public class ImagenesCarruselController {
    @Autowired
    ImagenesCarruselRepository imagenesCarruselRepository;

    @GetMapping("/imagenesCarrusel")
    public List<ImagenesCarrusel> getAllGrados() {
        return imagenesCarruselRepository.findAll();
    }

    @PostMapping("/imagenesCarrusel")
    public ImagenesCarrusel createImagenesCarrusel(@Valid @RequestBody ImagenesCarrusel imagenesCarrusel) {

        return imagenesCarruselRepository.save(imagenesCarrusel);
    }

    @GetMapping("/imagenesCarrusel/{id}")
    public ImagenesCarrusel getImagenesCarruselById(@PathVariable(value = "id") int id) {
        return imagenesCarruselRepository.findOne(id);
    }

    @PutMapping("/imagenesCarrusel/{id}")
    public ImagenesCarrusel updateImagenesCarrusel(@PathVariable(value = "id") int id, @Valid @RequestBody ImagenesCarrusel imagenesCarruselDetails) {
        ImagenesCarrusel imagenCarrusel = imagenesCarruselRepository.findOne(id);

        imagenCarrusel.setTitulo(imagenesCarruselDetails.getTitulo());
        imagenCarrusel.setDescripcion(imagenesCarruselDetails.getDescripcion());
        imagenCarrusel.setUrl(imagenesCarruselDetails.getUrl());

        ImagenesCarrusel updateImagenesCarrusel = imagenesCarruselRepository.save(imagenCarrusel);
        return updateImagenesCarrusel;
    }

    @DeleteMapping("/imagenesCarrusel/{id}")
    public ResponseEntity<?> deleteImagenesCarrusel(@PathVariable(value = "id") int id) {
        ImagenesCarrusel imagenesCarrusel = imagenesCarruselRepository.findOne(id);
        imagenesCarruselRepository.delete(imagenesCarrusel);
        return ResponseEntity.ok().build();
    }
}