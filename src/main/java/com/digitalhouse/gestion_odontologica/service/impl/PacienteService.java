package com.digitalhouse.gestion_odontologica.service.impl;

import com.digitalhouse.gestion_odontologica.entity.Domicilio;
import com.digitalhouse.gestion_odontologica.repository.DomicilioRepository;
import com.digitalhouse.gestion_odontologica.service.IPacienteService;
import com.digitalhouse.gestion_odontologica.entity.Paciente;
import com.digitalhouse.gestion_odontologica.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Service
public class PacienteService implements IPacienteService {
    private final PacienteRepository pacienteRepository;
    private final DomicilioRepository domicilioRepository;

    @Override
    public Paciente guardar(Paciente paciente) {
        Validaciones.validarNombre(paciente.getNombre());
        Validaciones.validarApellido(paciente.getApellido());

        paciente.setDomicilio(domicilioRepository.save(paciente.getDomicilio()));
        paciente = pacienteRepository.save(paciente);
        log.debug("Se guardo el paciente id " + paciente.getId());
        return paciente;
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
        log.debug("Se elimino el paciente id " + id);
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        Validaciones.validarNombre(paciente.getNombre());
        Validaciones.validarApellido(paciente.getApellido());

        paciente = pacienteRepository.update(paciente.getNombre(), paciente.getApellido(), paciente.getId());
        log.debug("Se actualizo el paciente id " + paciente.getId());
        return paciente;
    }

    @Override
    public Paciente actualizar(Long id, Domicilio domicilio) {
        Paciente paciente = pacienteRepository.getReferenceById(id);
        Long domicilioId = paciente.getDomicilio().getId();

        domicilio = domicilioRepository.update(domicilioId, domicilio.getNumPuerta(), domicilio.getCalle(), domicilio.getCiudad(),domicilio.getDepartamento(), domicilio.getPais());
        paciente.setDomicilio(domicilio);
        log.debug("Se actualizo el domicilio de paciente id " + paciente.getId());
        return paciente;
    }

    @Override
    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }
}
