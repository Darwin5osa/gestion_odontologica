package com.digitalhouse.gestion_odontologica.service.impl;

import com.digitalhouse.gestion_odontologica.entity.Turno;
import com.digitalhouse.gestion_odontologica.repository.OdontolgoRepository;
import com.digitalhouse.gestion_odontologica.repository.PacienteRepository;
import com.digitalhouse.gestion_odontologica.repository.TurnoRepository;
import com.digitalhouse.gestion_odontologica.service.ITurnoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Service
public class TurnoService implements ITurnoService {

    private final TurnoRepository turnoRepository;

    private final PacienteRepository pacienteRepository;

    private final OdontolgoRepository odontolgoRepository;

    @Override
    public Turno guardar(Turno turno) {
        turno.setOdontologo(odontolgoRepository.getReferenceById(turno.getOdontologo().getId()));
        turno.setPaciente(pacienteRepository.getReferenceById(turno.getPaciente().getId()));
        
        turno = turnoRepository.save(turno);
        log.debug("Se guardo el turno id " + turno.getId());

        return turno;
    }

    @Override
    public List<Turno> listarTodos() {
        return turnoRepository.findAll();
    }

    @Override
    public Turno actualizar(Turno turno) {
        turno.setOdontologo(odontolgoRepository.getReferenceById(turno.getOdontologo().getId()));
        turno.setPaciente(pacienteRepository.getReferenceById(turno.getPaciente().getId()));
        
        turnoRepository.update(turno.getId(), turno.getFecha(), turno.getOdontologo().getId(), turno.getPaciente().getId());
        turno = turnoRepository.findById(turno.getId()).get();
        log.debug("Se guardo el turno id " + turno.getId());

        return turno;
    }

    @Override
    public void eliminar(Long id) {
        turnoRepository.deleteById(id);
    }
}
