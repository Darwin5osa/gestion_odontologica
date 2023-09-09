package com.digitalhouse.gestion_odontologica.repository;

import com.digitalhouse.gestion_odontologica.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TurnoRepository extends JpaRepository<Turno,Long> {

    @Modifying
    @Query(value = "UPDATE Turno t " +
            "SET t.fecha = :fecha, t.paciente.id = :pacienteId, t.odontologo.id = :odontologoId " +
            "WHERE t.id = :id")
    Turno update(Long id, Date fecha, Long odontologoId, Long pacienteId);
}