package com.digitalhouse.gestion_odontologica.Service.impl;

import com.digitalhouse.gestion_odontologica.Service.IPacienteService;
import com.digitalhouse.gestion_odontologica.model.Odontologo;
import com.digitalhouse.gestion_odontologica.model.Paciente;

import java.util.List;

public class PacienteService implements IPacienteService {
    @Override
    public boolean guardar(Odontologo odontologo) {
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        return false;
    }

    @Override
    public Paciente obtenerUnoPorId(int id) {
        return null;
    }

    @Override
    public List<Odontologo> listarTodos() {
        return null;
    }
}
