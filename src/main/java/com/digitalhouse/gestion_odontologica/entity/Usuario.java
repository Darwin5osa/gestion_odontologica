package com.digitalhouse.gestion_odontologica.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "USUARIO")
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String nombre;

    private String username;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UsuarioRoleEnum rol;
}
