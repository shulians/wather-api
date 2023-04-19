package com.example.proxy.handler;

import com.example.proxy.dto.ErrorDTO;
import com.example.proxy.dto.response.ResponseDTO;
import com.example.proxy.exception.BusinessException;
import com.example.proxy.exception.TechnicalException;
import io.micrometer.common.lang.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler({ TechnicalException.class })
    @Nullable
    public ResponseEntity<ResponseDTO> handlerTechnicalException(final TechnicalException exception,
                                                                 final WebRequest request) {

        return new ResponseEntity<>(
                ErrorDTO.builder().code(exception.getCode()).message(exception.getMessage()).build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ BusinessException.class, })
    @Nullable
    public ResponseEntity<ResponseDTO> handlerBusinessException(final BusinessException exception,
                                                                final WebRequest request) {

        return new ResponseEntity<>(
                ErrorDTO.builder().code(exception.getCode()).message(exception.getMessage()).build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
