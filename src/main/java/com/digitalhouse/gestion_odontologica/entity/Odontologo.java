package com.digitalhouse.gestion_odontologica.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ODONTOLOGO")
@Getter
@Setter
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    private String apellido;

    private Integer matricula;

    @OneToMany(mappedBy = "odontologo")
    private List<Turno> turnos = new ArrayList<>();
}
