package com.digitalhouse.gestion_odontologica.repository;

import com.digitalhouse.gestion_odontologica.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio,Long> {
}
