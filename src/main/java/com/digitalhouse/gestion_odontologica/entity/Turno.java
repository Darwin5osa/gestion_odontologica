package com.digitalhouse.gestion_odontologica.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
public class Turno {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Paciente paciente;

    private Odontologo odontologo;

    // @Column(name = "fecha")
    // private Date fecha;

    @ManyToMany
    @JoinTable(name = "turno_paciente", // Nombre de la tabla de unión en la base de datos
            joinColumns = @JoinColumn(name = "turno_id"), // Columna que enlaza a la tabla de esta entidad
            inverseJoinColumns = @JoinColumn(name = "paciente_id")) // Columna que enlaza a la tabla de la entidad relacionada
    private Set<Paciente> pacientes = new HashSet<>(); // Colección de pacientes asociados con este turno

    @Column(name = "fecha") // Mapea este campo a una columna en la base de datos con el nombre "fecha"
    private Date fecha; // Fecha del turno
}

