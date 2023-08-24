package com.digitalhouse.gestion_odontologica.Service;

import com.digitalhouse.gestion_odontologica.model.Paciente;
import com.digitalhouse.gestion_odontologica.model.Turno;

import java.util.List;

public interface ITurnoService {
    void guardar(Turno turno) throws Exception;

    List<Turno> listarTodos() throws Exception;

    void actualizar(Paciente paciente) throws Exception;

    void eliminar(int dni) throws Exception;
}
