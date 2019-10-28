package com.epam.springadvanced.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(value = RuntimeException.class)
    public String exceptionHandler() {
        return "exception";
    }
}
