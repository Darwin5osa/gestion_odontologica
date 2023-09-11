package com.digitalhouse.gestion_odontologica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Data
@Table(name = "TURNO")
@NoArgsConstructor
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "PacienteId")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "OdontologoId")
    private Odontologo odontologo;
}

