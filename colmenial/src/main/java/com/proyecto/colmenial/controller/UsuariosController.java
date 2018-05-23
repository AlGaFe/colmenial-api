package com.proyecto.colmenial.controller;

import com.proyecto.colmenial.model.Usuarios;
import com.proyecto.colmenial.repository.UsuariosRepository;
import com.proyecto.colmenial.services.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/colmenial")
public class UsuariosController {

    @Autowired
    UsuariosRepository usuariosRepository;

    @Autowired
    UsuariosServices usuariosServices;

    @GetMapping("/usuarios")
    public List<Usuarios> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    @PostMapping("/usuarios")
    public int createUsuarios(@Valid @RequestBody Usuarios usuario) {return usuariosServices.registrarUsuario(usuario);}

    @GetMapping("/usuarios/id/{id}")
    public Usuarios findUsuariosById(@PathVariable(value = "id") int id) {
        return usuariosRepository.findById(id);
    }

    @GetMapping("/usuarios/nombre/{nombre}")
    public List<Usuarios> findUsuariosByNombre(@PathVariable(value = "nombre") String id) {
        return usuariosRepository.findByNombre(id);
    }
    @PutMapping("/usuarios/{id}")
    public Usuarios updateUsuarios(@PathVariable(value = "id") int id, @Valid @RequestBody Usuarios usuariosDetails) {
        Usuarios usuario = usuariosRepository.findOne(id);

        usuario.setNombre(usuariosDetails.getNombre());
        usuario.setPassword(usuariosDetails.getPassword());
        usuario.setDireccion(usuariosDetails.getDireccion());
        usuario.setEmail(usuariosDetails.getDireccion());
        usuario.setFechaNacimieto(usuariosDetails.getFechaNacimieto());

        Usuarios updateUsuario = usuariosRepository.save(usuario);
        return updateUsuario;
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable(value = "id") int id) {
        usuariosRepository.delete(usuariosRepository.findById(id));
        return ResponseEntity.ok().build();
    }

}
