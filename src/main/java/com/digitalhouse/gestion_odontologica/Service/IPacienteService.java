package com.digitalhouse.gestion_odontologica.Service;

import com.digitalhouse.gestion_odontologica.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    void guardar(Paciente paciente) throws Exception;
    void eliminar(int id) throws Exception;
    void actualizar(Paciente paciente) throws Exception;
    List<Paciente> listarTodos() throws Exception;
}
