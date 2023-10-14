package com.example.weather.exception;

/**
 * Excepción específica para manejar errores técnicos.
 * Esta excepción extiende {@link CustomException} y proporciona un código y un mensaje
 * específicos para identificar y describir el error técnico.
 */
public class TechnicalException extends CustomException {
    public TechnicalException(String code, String message) {
        super(code, message);
    }
}
