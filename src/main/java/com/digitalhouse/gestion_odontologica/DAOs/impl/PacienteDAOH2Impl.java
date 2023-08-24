package com.digitalhouse.gestion_odontologica.DAOs.impl;

import com.digitalhouse.gestion_odontologica.DAOs.IDao;
import com.digitalhouse.gestion_odontologica.model.Paciente;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PacienteDAOH2Impl implements IDao<Paciente> {
    @Override
    public Paciente guardar(Paciente paciente) throws Exception {//todo
        return null;
    }

    @Override
    public Paciente buscar(Integer id) throws Exception {
        return null;
    }

    @Override
    public void eliminar(Integer id) throws Exception {

    }

    @Override
    public List<Paciente> listarTodos() throws Exception {//todo
        return null;
    }

    @Override
    public Paciente actualizar(Paciente paciente) {//todo
        return null;
    }
}
