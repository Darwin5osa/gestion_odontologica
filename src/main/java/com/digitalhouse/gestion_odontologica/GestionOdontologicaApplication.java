package com.digitalhouse.gestion_odontologica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class GestionOdontologicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionOdontologicaApplication.class, args);
	}

	@Bean
	public static Connection crearConnection() throws SQLException, ClassNotFoundException {
		try {
			Class.forName("org.h2.Driver");
			String url = "jdbc:h2:tcp://localhost/~/test";
			Connection connection = DriverManager.getConnection(url, "sa", "");
			//log.debug("Se establecio la conexion con la base de datos H2");
			return connection;
		} catch (Exception e) {
			//log.error("No se pudo establecer la conexión con la base de datos H2", e);
			throw e;
		}
	}
}
