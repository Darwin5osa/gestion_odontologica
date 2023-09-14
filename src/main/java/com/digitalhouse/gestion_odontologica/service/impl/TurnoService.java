package com.digitalhouse.gestion_odontologica.service.impl;

import com.digitalhouse.gestion_odontologica.entity.Turno;
import com.digitalhouse.gestion_odontologica.repository.OdontolgoRepository;
import com.digitalhouse.gestion_odontologica.repository.PacienteRepository;
import com.digitalhouse.gestion_odontologica.repository.TurnoRepository;
import com.digitalhouse.gestion_odontologica.service.ITurnoService;
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
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Service

public class TurnoService implements ITurnoService {

    private final TurnoRepository turnoRepository;

    private final PacienteRepository pacienteRepository;

    private final OdontolgoRepository odontolgoRepository;

    @Override
    public Turno guardar(Turno turno) {
        try {
            turno.setOdontologo(odontolgoRepository.findById(turno.getOdontologo().getId()).get());
            turno.setPaciente(pacienteRepository.findById(turno.getPaciente().getId()).get());

            turno = turnoRepository.save(turno);
            log.info("Se guardo el turno id " + turno.getId());

            return turno;
        } catch (NoSuchElementException | EntityNotFoundException exception) {
            throw new RecursoNoEncontradoException(exception.getMessage(), exception);
        }
    }

    @Override
    public List<Turno> listarTodos() {
        try {
            return turnoRepository.findAll();
        } catch (NoSuchElementException | EntityNotFoundException exception) {
            throw new RecursoNoEncontradoException(exception.getMessage(), exception);
        }
    }

    @Override
    public Turno actualizar(Turno turno) {
        try {
            turno.setOdontologo(odontolgoRepository.findById(turno.getOdontologo().getId()).get());
            turno.setPaciente(pacienteRepository.findById(turno.getPaciente().getId()).get());

            turnoRepository.update(turno.getId(), turno.getFecha(), turno.getOdontologo().getId(), turno.getPaciente().getId());
            turno = turnoRepository.findById(turno.getId()).get();
            log.info("Se guardo el turno id " + turno.getId());

            return turno;
        } catch (NoSuchElementException | EntityNotFoundException exception) {
            throw new RecursoNoEncontradoException(exception.getMessage(), exception);
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            turnoRepository.deleteById(id);
            log.info("Se elimino el turno id " + id);
        } catch (EmptyResultDataAccessException exception) {
            log.info("El turno con id " + id + "no existía");
        }
    }
}
