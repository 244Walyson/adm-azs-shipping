package com.waly.desafioaz.controllers.handlers;

import com.waly.desafioaz.dtos.CustomError;
import com.waly.desafioaz.exceptions.DatabaseException;
import com.waly.desafioaz.exceptions.ResourceNotFoundException;
import com.waly.desafioaz.exceptions.ValidateException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExceptionHanddler {

    @ExceptionHandler(ValidateException.class)
    public ResponseEntity<CustomError> handlerValidationException(ValidateException validateException, HttpServletRequest request){
        CustomError customError = new CustomError();
        int status = HttpStatus.BAD_REQUEST.value();
        customError.setTimestamp(Instant.now());
        customError.setError(validateException.getMessage());
        customError.setStatus(status);
        customError.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(customError);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFoundException(ResourceNotFoundException resourceNotFoundException, HttpServletRequest request){
        CustomError customError = new CustomError();
        int status = HttpStatus.NOT_FOUND.value();
        customError.setTimestamp(Instant.now());
        customError.setError(resourceNotFoundException.getMessage());
        customError.setStatus(status);
        customError.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(customError);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomError> database(DatabaseException databaseException, HttpServletRequest request){
        CustomError customError = new CustomError();
        int status = HttpStatus.BAD_REQUEST.value();
        customError.setTimestamp(Instant.now());
        customError.setError(databaseException.getMessage());
        customError.setStatus(status);
        customError.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(customError);
    }

}
