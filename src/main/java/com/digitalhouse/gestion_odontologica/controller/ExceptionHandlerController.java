package com.digitalhouse.gestion_odontologica.controller;

import com.digitalhouse.gestion_odontologica.dto.ErrorDTO;
import com.digitalhouse.gestion_odontologica.service.exception.ApellidoInvalidoException;
import com.digitalhouse.gestion_odontologica.service.exception.NombreInvalidoException;
import com.digitalhouse.gestion_odontologica.service.exception.StringInvalidoException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;

@Log4j2
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(StringInvalidoException.class)
    public ResponseEntity<ErrorDTO> StringInvalidoHandler(StringInvalidoException exception) {
        String tipoString = obtenerTipoStringInvalido(exception);
        String mensaje = "El " + tipoString + " no es valido, su valor es " + exception.getTexto();

        logException(exception, mensaje);

        ErrorDTO response = new ErrorDTO(HttpStatus.BAD_REQUEST.getReasonPhrase(), mensaje);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ErrorDTO> EntityNotFoundHandler(EntityNotFoundException exception) {
        String mensaje = "No se encontro el recurso";

        logException(exception, mensaje);

        ErrorDTO response = new ErrorDTO(HttpStatus.NOT_FOUND.getReasonPhrase(), mensaje);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<ErrorDTO> NoSuchElementHandler(NoSuchElementException exception) {
        String mensaje = "No se encontro el recurso";

        logException(exception, mensaje);

        ErrorDTO response = new ErrorDTO(HttpStatus.NOT_FOUND.getReasonPhrase(), mensaje);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    private void logException(RuntimeException exception, String mensajeRespuesta) {
        log.error("Se atrapo una excepcion de tipo " + exception.getClass() + ", con el mensaje " + exception.getMessage() + ", se respondera con el mensaje: " + mensajeRespuesta, exception);
    }

    private String obtenerTipoStringInvalido(StringInvalidoException exception) {
        if (exception instanceof NombreInvalidoException) {
            return "nombre";
        } else if (exception instanceof ApellidoInvalidoException) {
            return "apellido";
        } else return "string";
    }
}
