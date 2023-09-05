package com.digitalhouse.gestion_odontologica.service;

import com.digitalhouse.gestion_odontologica.entity.Odontologo;

import java.util.List;

public interface IOdontologoService {
    Odontologo guardar(Odontologo odontologo) throws Exception;

    List<Odontologo> listarTodos() throws Exception;

    Odontologo actualizar(Odontologo odontologo) throws Exception;

    void eliminar(Long id) throws Exception;
}
