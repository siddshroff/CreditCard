package com.ps.cardPayment.CreditCardProcessing.controllers;

import com.ps.cardPayment.CreditCardProcessing.Exceptions.InvalidCardDetailsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler extends Throwable {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = InvalidCardDetailsException.class)
    public ResponseEntity<Object> exception(InvalidCardDetailsException exception) {
        return new ResponseEntity<>("Card details are invalid", HttpStatus.BAD_REQUEST);
    }
}
