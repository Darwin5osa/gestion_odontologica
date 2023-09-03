package com.digitalhouse.gestion_odontologica.service;

import com.digitalhouse.gestion_odontologica.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    Paciente guardar(Paciente paciente) throws Exception;
    void eliminar(Long id) throws Exception;
    Paciente actualizar(Paciente paciente) throws Exception;
    List<Paciente> listarTodos() throws Exception;
}
