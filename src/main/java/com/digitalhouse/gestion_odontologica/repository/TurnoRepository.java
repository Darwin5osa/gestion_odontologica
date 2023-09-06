package com.digitalhouse.gestion_odontologica.repository;

import com.digitalhouse.gestion_odontologica.entity.Odontologo;
import com.digitalhouse.gestion_odontologica.entity.Paciente;
import com.digitalhouse.gestion_odontologica.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TurnoRepository extends JpaRepository<Turno,Long> {
    @Modifying

    // todo asignación de un paciente
    @Query(value = "UPDATE Paciente p" +
            "SET p.nombre = :nombre, p.apellido = :apellido" +
            "WHERE p.id = :id")
    Paciente update(String nombre, String apellido, Long id);



    // todo setear nueva hora
    @Query(value = "SET Turno t" +
            "SET t.fecha = :fecha" +
            "WHERE t.id = :id")
    Turno update(Date fecha);


    // todo asignar un odontologo

    @Query(value = "SET Odontologo o" +
            "SET o.nombre = ::nombre, o.apellido = :apellido" +
            "WHERE o.id = :id")
    Odontologo update(Long id, String nombre, String apellido);


    void deleteById(Long id);
}