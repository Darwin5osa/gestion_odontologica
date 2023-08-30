package com.digitalhouse.gestion_odontologica.Service;

import com.digitalhouse.gestion_odontologica.entity.Turno;

import java.util.List;

public interface ITurnoService {
    void guardar(Turno turno) throws Exception;

    List<Turno> listarTodos() throws Exception;

    void actualizar(Turno turno) throws Exception;

    void eliminar(int dni) throws Exception;
}
