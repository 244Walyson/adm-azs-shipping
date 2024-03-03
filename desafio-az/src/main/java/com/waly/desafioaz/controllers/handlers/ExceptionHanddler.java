package com.waly.desafioaz.controllers.handlers;

import com.waly.desafioaz.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
        customError.setError("Validation error");
        customError.setStatus(status);
        customError.setMessage(customError.getMessage());
        customError.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(customError);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFoundException(ResourceNotFoundException resourceNotFoundException, HttpServletRequest request){
        CustomError customError = new CustomError();
        int status = HttpStatus.NOT_FOUND.value();
        customError.setTimestamp(Instant.now());
        customError.setError("Resource not found");
        customError.setStatus(status);
        customError.setMessage(customError.getMessage());
        customError.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(customError);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomError> database(DatabaseException databaseException, HttpServletRequest request){
        CustomError customError = new CustomError();
        int status = HttpStatus.BAD_REQUEST.value();
        customError.setTimestamp(Instant.now());
        customError.setError("Database Exception");
        customError.setStatus(status);
        customError.setPath(request.getRequestURI());
        customError.setMessage(customError.getMessage());
        return ResponseEntity.status(status).body(customError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError error = new ValidationError();
        error.setError("Validate Exception");
        error.setPath(request.getRequestURI());
        error.setStatus(status.value());
        error.setTimestamp(Instant.now());
        for (FieldError f : e.getBindingResult().getFieldErrors()){
            error.addError(f.getField(), f.getDefaultMessage());
        }
        return ResponseEntity.status(status.value()).body(error);
    }

}
