package com.digitalhouse.gestion_odontologica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PACIENTE")
@Getter
@Setter
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String nombre;

    private String apellido;

    private String dni;

    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;

    @OneToOne(cascade = CascadeType.ALL/*, fetch = FetchType.LAZY*/)
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private List<Turno> turnos = new ArrayList<>();
}
