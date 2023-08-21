package com.digitalhouse.gestion_odontologica.DAOs.impl;

import com.digitalhouse.gestion_odontologica.DAOs.IOdontologoDAO;
import com.digitalhouse.gestion_odontologica.Utils.SQLQueries;
import com.digitalhouse.gestion_odontologica.model.Odontologo;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OdontologoDAOH2Impl implements IOdontologoDAO {

    private static Connection connection;

    public OdontologoDAOH2Impl() {
        try {
            Class.forName("org.h2.Driver");
            String url = "jdbc:h2:tcp://localhost/~/test";
            connection = DriverManager.getConnection(url, "sa", "");
            log.debug("Se establecio la conexion con la base de datos H2");
        } catch (Exception e) {
            log.error("No se pudo establecer la conexión con la base de datos H2", e);
        }
    }

    public void crearTablas() throws Exception {
        Statement statement = connection.createStatement();
        statement.execute(SQLQueries.CREATETABLES);
        statement.close();
    }

    @Override
    public void guardar(Odontologo odontologo) throws Exception {
        try (PreparedStatement statement = connection.prepareStatement(SQLQueries.INSERT_CUSTOM)) {
            statement.setInt(1, odontologo.getNumeroMatricula());
            statement.setString(2, odontologo.getNombre());
            statement.setString(3, odontologo.getApellido());
            statement.execute();
            log.info("Odontólogo guardado en memoria: " + odontologo.getNumeroMatricula());
        } catch (Exception e) {
            log.error("No se pudo persistir: " + odontologo, e);
            throw new Exception("Sucedio un error al persistir", e);
        }
    }

    @Override
    public List<Odontologo> listarTodos() throws Exception {
        List<Odontologo> odontologos = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(SQLQueries.LISTAR_TODOS_ODONTOLOGO)) {
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
}