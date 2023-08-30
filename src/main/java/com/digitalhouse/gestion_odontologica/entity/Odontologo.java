package com.digitalhouse.gestion_odontologica.entity;

import lombok.*;

import javax.persistence.*;

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

    @OneToOne(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JoinColumn(name = "turno_id", referencedColumnName = "id")
    private Turno turno;
}
