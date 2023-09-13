package com.digitalhouse.gestion_odontologica.util;

import com.digitalhouse.gestion_odontologica.service.exception.ApellidoInvalidoException;
import com.digitalhouse.gestion_odontologica.service.exception.NombreInvalidoException;

import java.util.regex.*;

public class Validaciones {
    public static void validarNombre(String nombre) {
        Pattern pat = Pattern.compile(obtenerRegexNombre(1, 39));
        Matcher mat = pat.matcher(nombre);

        if (!mat.matches()) {
            throw new NombreInvalidoException(nombre);
        }
    }

    public static void validarApellido(String nombre) {
        Pattern pat = Pattern.compile(obtenerRegexNombre(2, 49));
        Matcher mat = pat.matcher(nombre);

        if (!mat.matches()) {
            throw new ApellidoInvalidoException(nombre);
        }
    }

    private static String obtenerRegexNombre(int minLargo, int maxLargo) {
        return "^[\\p{L}áéíóúÁÉÍÓÚ]{" + minLargo + "," + maxLargo + "}$";
    }
}

