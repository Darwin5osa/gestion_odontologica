package com.digitalhouse.gestion_odontologica.service.impl;

import com.digitalhouse.gestion_odontologica.entity.Usuario;
import com.digitalhouse.gestion_odontologica.repository.UsuarioRepository;
import com.digitalhouse.gestion_odontologica.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UsuarioService implements IUsuarioService {

    private final UsuarioRepository usuarioReository;

    public Usuario guardar(Usuario usuario) {
        usuario = usuarioReository.save(usuario);
        log.debug("Se guardo el usuario id " + usuario.getId());
        return usuario;
    }

    public List<Usuario> listarTodos() {
        return usuarioReository.findAll();
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
        usuarioReository.update(usuario.getId(), usuario.getNombre(), usuario.getUsername(), usuario.getEmail(), usuario.getPassword(), usuario.getRol());
        log.debug("Se actualizo el paciente id " + usuario.getId());
        return usuarioReository.findById(usuario.getId()).get();
    }

    @Override
    public void eliminar(Long id) {
        try {
            usuarioReository.deleteById(id);
            log.debug("Se elimino el usuario id " + id);
        } catch (EmptyResultDataAccessException exception) {
            log.debug("El usuario con id " + id + "no existía");
        }
    }
}
