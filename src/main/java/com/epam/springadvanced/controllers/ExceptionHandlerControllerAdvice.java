package com.epam.springadvanced.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(value = RuntimeException.class)
    public ModelAndView exceptionHandler(RuntimeException ex) {
        ModelAndView mav = new ModelAndView("exception");
        mav.addObject("message", ex.getMessage());
        return mav;
    }
}
