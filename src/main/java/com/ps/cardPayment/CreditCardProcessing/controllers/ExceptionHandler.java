package com.ps.cardPayment.CreditCardProcessing.controllers;

import com.ps.cardPayment.CreditCardProcessing.Exceptions.InvalidCardDetailsException;
import com.ps.cardPayment.CreditCardProcessing.Exceptions.ProcessingError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandler extends Throwable {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
    @org.springframework.web.bind.annotation.ExceptionHandler(value = InvalidCardDetailsException.class)
    public ResponseEntity<Object> exception(InvalidCardDetailsException exception) {
        logger.error("Card number is not compatible with Luhn10",exception.getMessage());
        return new ResponseEntity<>("{\"Success\":false,\"Message\":\"Card details are invalid\"}", HttpStatus.BAD_REQUEST);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(value = ProcessingError.class)
    public ResponseEntity<Object> exception(ProcessingError exception) {
        logger.error("Error processing request", exception.getMessage());
        return new ResponseEntity<>("{\"Success\":false,\"Message\":\"Error processing request\"}", HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(MethodArgumentNotValidException e) {
        logger.error("Request body parameters not valid", e.getMessage());
        return new ResponseEntity<>("{\"Success\":false,\"Message\":\"Invalid request body.\"}", HttpStatus.BAD_REQUEST);
    }
}
