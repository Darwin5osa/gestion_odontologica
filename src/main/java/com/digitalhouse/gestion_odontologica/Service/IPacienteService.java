package com.digitalhouse.gestion_odontologica.Service;

import com.digitalhouse.gestion_odontologica.model.Odontologo;
import com.digitalhouse.gestion_odontologica.model.Paciente;

import java.util.List;

public interface IPacienteService {
    void guardar(Odontologo odontologo) throws Exception;
    void eliminar(int id) throws Exception;
    Paciente obtenerUnoPorId(int id) throws Exception;
    List<Odontologo> listarTodos() throws Exception;
}
