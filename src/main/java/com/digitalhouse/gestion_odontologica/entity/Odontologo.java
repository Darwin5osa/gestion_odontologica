package com.digitalhouse.gestion_odontologica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ODONTOLOGO")
@Getter
@Setter
@RequiredArgsConstructor
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String nombre;

    private String apellido;

    private Integer matricula;

    @OneToMany(mappedBy = "odontologo")
    @JsonIgnore
    private List<Turno> turnos = new ArrayList<>();
}
