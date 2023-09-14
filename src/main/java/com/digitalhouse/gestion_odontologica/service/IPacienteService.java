package com.digitalhouse.gestion_odontologica.service;

import com.digitalhouse.gestion_odontologica.entity.Domicilio;
import com.digitalhouse.gestion_odontologica.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    Paciente guardar(Paciente paciente);

    void eliminar(Long id);

    Paciente actualizar(Paciente paciente);

    Paciente actualizar(Long id, Domicilio domicilio);

    List<Paciente> listarTodos();
}
