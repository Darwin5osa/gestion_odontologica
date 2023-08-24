package com.digitalhouse.gestion_odontologica.Utils;

public class SQLQueries { // TODO evaluar si no se puede dividir en subclases a futuro, para cada entidad y que create tables llame a cada sub clase para obtener declaracion de la tabla.
    ///region Odontologo
    public static final String INSERT_ODONTOLOGO = "INSERT INTO ODONTOLOGO VALUES(?,?,?);";

    public static final String OBTENER_ODONTOLOGO_POR_MATRICULA = "SELECT * FROM ODONTOLOGO WHERE DNI=?";

    public static final String ACTUALIZAR_ODONTOLOGO = "UPDATE ODONTOLOGO SET +++ WHERE DNI=?"; // todo rellenar la data

    public static final String ELIMINAR_ODONTOLOGO_POR_MATRICULA = "SELECT * FROM ODONTOLOGO WHERE DNI=?";

    public static final String LISTAR_TODOS_ODONTOLOGO = "SELECT * FROM ODONTOLOGO";
    ///endregion

    ///region Paciente
    public static final String INSERT_PACIENTE = "INSERT INTO PACIENTE VALUES(?,?,?,?,?);";

    public static final String LISTAR_TODOS_PACIENTE = "SELECT * FROM PACIENTE";
    ///endregion
}
