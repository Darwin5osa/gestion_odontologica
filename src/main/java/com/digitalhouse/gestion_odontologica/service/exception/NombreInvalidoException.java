package com.digitalhouse.gestion_odontologica.service.exception;

import lombok.Getter;

@Getter
public class NombreInvalidoException extends StringInvalidoException {
    public NombreInvalidoException(String nombre) {
        super(nombre);
    }
}