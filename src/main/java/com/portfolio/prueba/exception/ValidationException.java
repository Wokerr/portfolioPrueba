package com.portfolio.prueba.exception;

import org.springframework.validation.BindingResult;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {
    private final BindingResult bindingResult;
    
    public ValidationException(BindingResult bindingResult) {
        super("Validation error: Has found: " + bindingResult.getErrorCount());
        this.bindingResult = bindingResult;
    }
}
