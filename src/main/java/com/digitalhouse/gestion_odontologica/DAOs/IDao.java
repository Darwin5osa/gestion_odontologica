package com.digitalhouse.gestion_odontologica.DAOs;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {
     T guardar(T t) throws Exception;
     T buscar(Integer id) throws Exception;
     void eliminar(Integer id) throws Exception;
     List<T> listarTodos() throws Exception;
     T actualizar(T t) throws SQLException, ClassNotFoundException;
}
