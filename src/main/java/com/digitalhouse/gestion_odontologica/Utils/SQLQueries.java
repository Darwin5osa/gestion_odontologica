package com.digitalhouse.gestion_odontologica.Utils;

public class SQLQueries {
    public static final String CREATETABLES =
            "DROP TABLE IF EXISTS ODONTOLOGO;" +
                    "CREATE TABLE ODONTOLOGO(MATRICULA INT PRIMARY KEY, NOMBRE VARCHAR(255), APELLIDO VARCHAR(255));";

    public static final String INSERT_CUSTOM = "INSERT INTO ODONTOLOGO VALUES(?,?,?);";

    public static final String LISTAR_TODOS_ODONTOLOGO = "SELECT * FROM ODONTOLOGO";
}
