package com.digitalhouse.gestion_odontologica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UsuarioResultadoDto {
    private Long id;
    private String nombre;
    private String username;
    private String email;
    private String password;
    private String rol;
}
