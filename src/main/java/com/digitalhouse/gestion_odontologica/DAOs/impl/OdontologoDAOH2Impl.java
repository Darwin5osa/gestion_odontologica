package com.digitalhouse.gestion_odontologica.DAOs.impl;

import com.digitalhouse.gestion_odontologica.DAOs.IDao;
import com.digitalhouse.gestion_odontologica.Utils.SQLQueries;
import com.digitalhouse.gestion_odontologica.model.Odontologo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class OdontologoDAOH2Impl implements IDao<Odontologo> {

    private final Connection connection;

    @Autowired
    public OdontologoDAOH2Impl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) throws Exception {
        try (PreparedStatement statement = connection.prepareStatement(SQLQueries.INSERT_ODONTOLOGO)) {
            statement.setInt(1, odontologo.getMatricula());
            statement.setString(2, odontologo.getNombre());
            statement.setString(3, odontologo.getApellido());
            statement.execute();
            log.info("Odontólogo guardado en db H2: " + odontologo.getMatricula());
            return odontologo;
        } catch (Exception e) {
            log.error("No se pudo persistir: " + odontologo, e);
            throw new Exception("Sucedio un error al persistir", e);
        }
    }

    @Override
    public Odontologo buscar(Integer id) throws Exception {
        return null;
    }

    @Override
    public void eliminar(Integer id) throws Exception {

    }

    @Override
    public List<Odontologo> listarTodos() throws Exception {
        List<Odontologo> odontologos = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(SQLQueries.LISTAR_TODOS_PACIENTE)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Odontologo odontologo = new Odontologo(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
                odontologos.add(odontologo);
            }
        } catch (Exception e) {
            log.error("No se pudo obtener la información de los odontologos de la base de datos H2", e);
            throw new Exception("No se pudo obtener la información", e);
        }

        return odontologos;
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) { //todo
        return null;
    }
}