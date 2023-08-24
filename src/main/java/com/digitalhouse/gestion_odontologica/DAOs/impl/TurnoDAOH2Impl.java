package com.digitalhouse.gestion_odontologica.DAOs.impl;

import com.digitalhouse.gestion_odontologica.DAOs.IDao;
import com.digitalhouse.gestion_odontologica.model.Turno;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class TurnoDAOH2Impl implements IDao<Turno> { //todo
    @Override
    public Turno guardar(Turno turno) throws Exception {
        return null;
    }

    @Override
    public Turno buscar(Integer id) throws Exception {
        return null;
    }

    @Override
    public void eliminar(Integer id) throws Exception {

    }

    @Override
    public List<Turno> listarTodos() throws Exception {
        return null;
    }

    @Override
    public Turno actualizar(Turno turno) throws SQLException, ClassNotFoundException {
        return null;
    }
}
