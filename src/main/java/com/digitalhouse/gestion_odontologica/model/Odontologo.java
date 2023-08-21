package com.digitalhouse.gestion_odontologica.model;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Odontologo {
    private int numeroMatricula;
    private String nombre;
    private String apellido;
}