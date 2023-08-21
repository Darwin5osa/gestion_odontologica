package com.digitalhouse.gestion_odontologica.Service;

import com.digitalhouse.gestion_odontologica.model.Odontologo;

import java.util.List;

public interface IOdontologoService {
    boolean guardar(Odontologo odontologo);
    List<Odontologo> listarTodos();
}
