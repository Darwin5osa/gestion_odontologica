package com.digitalhouse.gestion_odontologica.service;

import com.digitalhouse.gestion_odontologica.entity.Turno;

import java.util.List;

public interface ITurnoService {
    Turno guardar(Turno turno) throws Exception;

    List<Turno> listarTodos() throws Exception;

    Turno actualizar(Turno turno) throws Exception;

    void eliminar(Long id) throws Exception;

}
