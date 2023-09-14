package com.digitalhouse.gestion_odontologica.repository;

import com.digitalhouse.gestion_odontologica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface OdontolgoRepository extends JpaRepository<Odontologo,Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Odontologo o " +
            "SET o.nombre = :nombre, o.apellido = :apellido " +
            "WHERE o.id = :id")
    void update(Long id, String nombre, String apellido);
}
