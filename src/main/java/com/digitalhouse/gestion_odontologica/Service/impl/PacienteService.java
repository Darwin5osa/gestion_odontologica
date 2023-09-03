package com.digitalhouse.gestion_odontologica.Service.impl;

import com.digitalhouse.gestion_odontologica.Service.IPacienteService;
import com.digitalhouse.gestion_odontologica.entity.Paciente;
import com.digitalhouse.gestion_odontologica.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PacienteService implements IPacienteService {
    private final PacienteRepository repository;

    @Override
    public Paciente guardar(Paciente paciente) {
        return repository.save(paciente);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Paciente actualizar(Paciente paciente) throws Exception {
        return repository.update(paciente);
    }

    @Override
    public List<Paciente> listarTodos() {
        return repository.findAll();
    }
}
