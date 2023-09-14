package com.digitalhouse.gestion_odontologica.service;

import com.digitalhouse.gestion_odontologica.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    Usuario guardar(Usuario usuario);

    List<Usuario> listarTodos();

    Usuario actualizar(Usuario usuario);

    void eliminar(Long id);
}
