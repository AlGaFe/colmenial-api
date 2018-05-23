package com.proyecto.colmenial.services;

import com.proyecto.colmenial.model.Usuarios;

public interface UsuariosServices {
    public int validarUsuario(Usuarios usuario);
    public int registrarUsuario(Usuarios usuario);
}