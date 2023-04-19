package com.example.proxy.exception;

public class BusinessException extends CustomException {
    public BusinessException(String code, String message) {
        super(code, message);
    }
}
