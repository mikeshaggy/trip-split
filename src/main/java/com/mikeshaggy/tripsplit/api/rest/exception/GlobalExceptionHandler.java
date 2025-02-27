package com.mikeshaggy.tripsplit.api.rest.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {

        ErrorDetails errorDetails = ErrorDetails.builder()
                .type("https://example.com/probs/general-error")
                .title("Internal Server Error")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .detail(ex.getMessage())
                .instance(request.getDescription(false))
                .build();

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleEntityNotFoundException(Exception ex, WebRequest request) {

        ErrorDetails errorDetails = ErrorDetails.builder()
                .type("https://example.com/probs/entity-not-found")
                .title("Entity Not Found")
                .status(HttpStatus.NOT_FOUND.value())
                .detail(ex.getMessage())
                .instance(request.getDescription(false))
                .build();

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        for (ObjectError error : ex.getAllErrors()) {
            String key = (error instanceof FieldError) ? ((FieldError) error).getField() : error.getObjectName();
            errors.put(key, error.getDefaultMessage());
        }

        ErrorDetails errorDetails = ErrorDetails.builder()
                .type("https://example.com/probs/validation-error")
                .title("Validation Error")
                .status(HttpStatus.BAD_REQUEST.value())
                .detail("One or more fields are invalid")
                .instance(request.getDescription(false))
                .errors(errors)
                .build();

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
