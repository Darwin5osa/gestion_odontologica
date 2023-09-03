package com.digitalhouse.gestion_odontologica.repository;

import com.digitalhouse.gestion_odontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    /*@Modifying
    @Query(value = "") TODO finish the update to just update the nombre y appellido
    Paciente update(Paciente paciente);*/
}
