package com.digitalhouse.gestion_odontologica.service.impl;

import com.digitalhouse.gestion_odontologica.entity.Odontologo;
import com.digitalhouse.gestion_odontologica.repository.OdontolgoRepository;
import com.digitalhouse.gestion_odontologica.service.IOdontologoService;
import com.digitalhouse.gestion_odontologica.service.exception.RecursoNoEncontradoException;
import com.digitalhouse.gestion_odontologica.util.Validaciones;
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
public class OdontologoService implements IOdontologoService {

    private final OdontolgoRepository odontologoReository;

    public Odontologo guardar(Odontologo odontologo) {
        Validaciones.validarNombre(odontologo.getNombre());
        Validaciones.validarApellido(odontologo.getApellido());

        odontologo = odontologoReository.save(odontologo);
        log.info("Se guardo el odontologo id " + odontologo.getId());
        return odontologo;
    }

    public List<Odontologo> listarTodos() {
        try {
            return odontologoReository.findAll();
        } catch (NoSuchElementException | EntityNotFoundException exception) {
            throw new RecursoNoEncontradoException(exception.getMessage(), exception);
        }
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        try {
            Validaciones.validarNombre(odontologo.getNombre());
            Validaciones.validarApellido(odontologo.getApellido());

            odontologoReository.update(odontologo.getId(), odontologo.getNombre(), odontologo.getApellido());
            log.info("Se actualizo el paciente id " + odontologo.getId());
            return odontologoReository.findById(odontologo.getId()).get();
        } catch (NoSuchElementException | EntityNotFoundException exception) {
            throw new RecursoNoEncontradoException(exception.getMessage(), exception);
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            odontologoReository.deleteById(id);
            log.info("Se elimino el odontologo id " + id);
        } catch (EmptyResultDataAccessException exception) {
            log.info("El odontologo con id " + id + "no existía");
        }
    }
}