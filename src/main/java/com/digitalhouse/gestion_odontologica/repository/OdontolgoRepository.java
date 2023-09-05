package com.digitalhouse.gestion_odontologica.repository;

import com.digitalhouse.gestion_odontologica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontolgoRepository extends JpaRepository<Odontologo,Long> {
    @Modifying
    @Query(value = "UPDATE odontologo o" +
            "SET o.nombre = :nombre, o.apellido = :apellido" +
            "WHERE o.id = :id")
    Odontologo update(Long id, String nombre, String apellido);
}
