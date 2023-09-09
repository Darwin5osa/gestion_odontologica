package com.digitalhouse.gestion_odontologica.service;

import com.digitalhouse.gestion_odontologica.entity.Turno;

import java.util.List;

public interface ITurnoService {
    Turno guardar(Turno turno);

    List<Turno> listarTodos();

    Turno actualizar(Turno turno);

    void eliminar(Long id);

}
