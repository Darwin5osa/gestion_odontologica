package com.digitalhouse.gestion_odontologica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "DOMICILIO")
@Getter
@Setter
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "num_puerta")
    private Integer numPuerta;

    private String calle;

    private String ciudad;

    private String departamento;

    private String pais;

    @OneToOne(mappedBy = "domicilio", cascade = CascadeType.ALL)
    @JsonIgnore
    private Paciente paciente;
}
