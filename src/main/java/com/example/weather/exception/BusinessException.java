package com.example.weather.exception;

/**
 * Excepción específica para manejar errores relacionados con reglas de negocio.
 * Esta excepción extiende {@link CustomException} y proporciona un código y un mensaje
 * específicos para identificar y describir el error.
 */
public class BusinessException extends CustomException {
    public BusinessException(String code, String message) {
        super(code, message);
    }
}
