package com.digitalhouse.gestion_odontologica.repository;

import com.digitalhouse.gestion_odontologica.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio,Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Domicilio d " +
            "SET d.numPuerta = :numPuerta, d.calle = :calle, d.ciudad = :ciudad, d.departamento = :departamento, d. pais= :pais " +
            "WHERE d.id = :id")
    void update(Long id, Integer numPuerta, String calle, String ciudad, String departamento, String pais);
}
