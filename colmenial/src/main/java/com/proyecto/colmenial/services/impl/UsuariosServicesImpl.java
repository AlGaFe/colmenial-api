package com.proyecto.colmenial.services.impl;

import com.proyecto.colmenial.model.Usuarios;
import com.proyecto.colmenial.repository.UsuariosRepository;
import com.proyecto.colmenial.services.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class UsuariosServicesImpl implements UsuariosServices {
    @Autowired
    UsuariosRepository usuariosRepository;

    @Override
    public int validarUsuario(Usuarios usuario) {
        List<Usuarios> usuarios = usuariosRepository.findAll();
        for(Usuarios usuarioRegistrado : usuarios){
            if(usuarioRegistrado.getEmail().equals((usuario.getEmail()))){
                if(usuarioRegistrado.getNombre().equals((usuario.getNombre()))) {
                    if(usuarioRegistrado.getPassword().equals((usuario.getPassword()))){
                        return 3;
                    }
                }else{return 1;}
            }else{return 0;}
        }
        return 0;
    }

    @Override
    public int registrarUsuario(Usuarios usuario) {
        List<Usuarios> usuarios = usuariosRepository.findAll();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getEmail().equals(usuario.getEmail())) {
                return 0;
            } else if (usuarios.get(i).getNombre().equals(usuario.getNombre())) {
                return 1;
            }
        }
        usuariosRepository.save(usuario);
        return 2;
    }
}
