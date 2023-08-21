package com.digitalhouse.gestion_odontologica.DAOs;


import com.digitalhouse.gestion_odontologica.model.Odontologo;

import java.util.List;

public interface IOdontologoDAO {
    void guardar(Odontologo odontologo) throws Exception;

    List<Odontologo> listarTodos() throws Exception;
}

