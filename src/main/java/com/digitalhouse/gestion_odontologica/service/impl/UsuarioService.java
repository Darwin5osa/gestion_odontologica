package com.digitalhouse.gestion_odontologica.service.impl;

import com.digitalhouse.gestion_odontologica.entity.Usuario;
import com.digitalhouse.gestion_odontologica.repository.UsuarioRepository;
import com.digitalhouse.gestion_odontologica.service.IUsuarioService;
import com.digitalhouse.gestion_odontologica.service.exception.RecursoNoEncontradoException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UsuarioService implements IUsuarioService {

    private final UsuarioRepository usuarioReository;

    public Usuario guardar(Usuario usuario) {
        usuario = usuarioReository.save(usuario);
        log.info("Se guardo el usuario id " + usuario.getId());
        return usuario;
    }

    public List<Usuario> listarTodos() {
        try {
            return usuarioReository.findAll();
        } catch (NoSuchElementException | EntityNotFoundException exception) {
            throw new RecursoNoEncontradoException(exception.getMessage(), exception);
        }
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
        try {
            usuarioReository.update(usuario.getId(), usuario.getNombre(), usuario.getUsername(), usuario.getEmail(), usuario.getPassword(), usuario.getRol());
            log.info("Se actualizo el paciente id " + usuario.getId());
            return usuarioReository.findById(usuario.getId()).get();
        } catch (NoSuchElementException | EntityNotFoundException exception) {
            throw new RecursoNoEncontradoException(exception.getMessage(), exception);
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            usuarioReository.deleteById(id);
            log.info("Se elimino el usuario id " + id);
        } catch (EmptyResultDataAccessException exception) {
            log.info("El usuario con id " + id + "no existía");
        }
    }
}
