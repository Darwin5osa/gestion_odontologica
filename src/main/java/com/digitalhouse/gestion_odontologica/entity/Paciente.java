package com.digitalhouse.gestion_odontologica.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "PACIENTE")
@Getter
@Setter
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    private String apellido;

    private String dni;

    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;

    @OneToOne(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;

    @ManyToMany(mappedBy = "pacientes") // Relación muchos a muchos mapeada desde la propiedad "pacientes" en la clase relacionada
    private Set<Turno> turnos = new HashSet<>(); // Colección de turnos asociados con este paciente

}
