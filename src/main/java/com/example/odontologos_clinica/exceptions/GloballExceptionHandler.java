package com.example.odontologos_clinica.exceptions;

import org.apache.log4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GloballExceptionHandler {

    private final Logger logger = Logger.getLogger(GloballExceptionHandler.class);

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String>procesarErrorBadRequest(BadRequestException exception){
        logger.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler({ResourceNotFoundExcepcion.class})
    public ResponseEntity<String>procesarRespurceNotFoundExcepcion(ResourceNotFoundExcepcion excepcion){
        logger.error(excepcion.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(excepcion.getMessage());
    }
}
