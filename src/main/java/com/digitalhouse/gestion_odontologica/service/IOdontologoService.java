package com.digitalhouse.gestion_odontologica.service;

import com.digitalhouse.gestion_odontologica.entity.Odontologo;

import java.util.List;

public interface IOdontologoService {
    Odontologo guardar(Odontologo odontologo);

    List<Odontologo> listarTodos();

    Odontologo actualizar(Odontologo odontologo);

    void eliminar(Long id);
}
