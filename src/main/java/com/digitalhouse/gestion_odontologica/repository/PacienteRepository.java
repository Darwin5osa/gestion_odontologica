package com.digitalhouse.gestion_odontologica.repository;

import com.digitalhouse.gestion_odontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Paciente p " +
            "SET p.nombre = :nombre, p.apellido = :apellido " +
            "WHERE p.id = :id")
    void update(String nombre, String apellido, Long id);
}