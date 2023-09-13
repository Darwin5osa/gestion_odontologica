package com.digitalhouse.gestion_odontologica.repository;

import com.digitalhouse.gestion_odontologica.entity.Usuario;
import com.digitalhouse.gestion_odontologica.entity.UsuarioRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Usuario u " +
            "SET u.nombre = :nombre, u.username = :username, u.email = :email, u.password = :password, u.rol = :rol " +
            "WHERE u.id = :id")
    void update(Long id, String nombre, String username, String email, String password, UsuarioRoleEnum rol);
}
