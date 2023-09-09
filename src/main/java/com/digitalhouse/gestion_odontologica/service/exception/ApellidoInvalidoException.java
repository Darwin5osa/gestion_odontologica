package com.digitalhouse.gestion_odontologica.service.exception;

import lombok.Getter;

@Getter
public class ApellidoInvalidoException extends StringInvalidoException {
    public ApellidoInvalidoException(String apellido) {
        super(apellido);
    }
}