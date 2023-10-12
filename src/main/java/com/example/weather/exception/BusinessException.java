package com.example.weather.exception;

public class BusinessException extends CustomException {
    public BusinessException(String code, String message) {
        super(code, message);
    }
}
