package com.digitalhouse.gestion_odontologica.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@Table(name = "USUARIO")
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String nombre;

    private String apellido;
}
