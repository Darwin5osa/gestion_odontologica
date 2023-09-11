package com.digitalhouse.gestion_odontologica.service.impl;

import com.digitalhouse.gestion_odontologica.repository.OdontolgoRepository;
import com.digitalhouse.gestion_odontologica.repository.PacienteRepository;
import com.digitalhouse.gestion_odontologica.repository.TurnoRepository;
import com.digitalhouse.gestion_odontologica.service.ITurnoService;
import com.digitalhouse.gestion_odontologica.entity.Turno;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)

public class TurnoService implements ITurnoService {

    private final TurnoRepository turnoRepository;

    private final PacienteRepository pacienteRepository;

    private  final OdontolgoRepository odontolgoRepository;
    @Override
    public Turno guardar(Turno turno) { return turnoRepository.save(turno);}

    @Override
    public List<Turno> listarTodos()  {
        return turnoRepository.findAll();
    }

    @Override
    public Turno actualizar(Turno turno) throws Exception {
    return turnoRepository.update(turno.getFecha());
    }

    @Override
    public void eliminar(Long id)  {
        turnoRepository.deleteById(id);

    }
}
