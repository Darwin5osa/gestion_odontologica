package com.digitalhouse.gestion_odontologica.repository;

import com.digitalhouse.gestion_odontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    @Modifying
    @Query(value = "update Paciente p SET p.nombre = :paciente.nombre, p.apellido = :paciente.apellido WHERE p.id = :paciente.id")
    Paciente update(Paciente paciente);
}
