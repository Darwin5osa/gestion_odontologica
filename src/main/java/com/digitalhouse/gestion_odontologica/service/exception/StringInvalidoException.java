package com.digitalhouse.gestion_odontologica.service.exception;

import lombok.Getter;

@Getter
public abstract class StringInvalidoException extends RuntimeException {
    private final String texto;

    public StringInvalidoException(String texto) {
        super("El valor " + texto + " no es valido");
        this.texto = texto;
    }
}
