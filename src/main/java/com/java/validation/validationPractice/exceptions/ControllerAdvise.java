package com.java.validation.validationPractice.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Map<String,Set<String>>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, Set<String>> validationErrors = new HashMap<>();
                ex.getBindingResult().getFieldErrors()
                .forEach(fieldError -> validationErrors.computeIfAbsent(fieldError.getField(),
                        key -> new HashSet<>()).add(fieldError.getDefaultMessage() != null ?
                        fieldError.getDefaultMessage() : ""));
        return new ResponseEntity<>(getErrorsMap(validationErrors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, Map<String,Set<String>>> getErrorsMap(Map<String, Set<String>> errors) {
        Map<String, Map<String, Set<String>>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }


}
