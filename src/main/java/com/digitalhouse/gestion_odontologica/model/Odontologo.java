package com.digitalhouse.gestion_odontologica.model;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Odontologo {
    private int matricula;
    private String nombre;
    private String apellido;
}