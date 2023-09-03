package com.digitalhouse.gestion_odontologica.repository;

import com.digitalhouse.gestion_odontologica.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrunoRepository extends JpaRepository<Turno,Long> {
    // todo asignación de un paciente
    // todo setear nueva hora
    // todo asignar un odontologo
}
