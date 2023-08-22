package com.digitalhouse.gestion_odontologica.Service;

import com.digitalhouse.gestion_odontologica.model.Odontologo;
import com.digitalhouse.gestion_odontologica.model.Paciente;

import java.util.List;

public interface IPacienteService {
    boolean guardar(Odontologo odontologo);
    boolean eliminar(int id);
    Paciente obtenerUnoPorId(int id);
    List<Odontologo> listarTodos();
}
