package com.digitalhouse.gestion_odontologica.Service;

import com.digitalhouse.gestion_odontologica.model.Odontologo;

import java.util.List;

public interface IOdontologoService {
    void guardar(Odontologo odontologo) throws Exception;

    List<Odontologo> listarTodos() throws Exception;

    void actualizar(Odontologo odontologo) throws Exception;

    void eliminar(int matricula) throws Exception;
}
