package com.ps.cardPayment.CreditCardProcessing.controllers;

import com.google.gson.Gson;
import com.ps.cardPayment.CreditCardProcessing.Exceptions.InvalidCardDetailsException;
import com.ps.cardPayment.CreditCardProcessing.Exceptions.ProcessingError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * This controller class handles all exceptions at global level
 * Every scenario respond with a customised error response and codes.
 *
 * @author  Siddharth Shroff
 * @version 1.0
 * @since   13-06-2022
 */
@ControllerAdvice
public class ExceptionHandler extends Throwable {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    /**
     * This exception method handles exceptions where card details are
     * not valid according various checks in the project.
     * @return ResponseEntity<Object> This returns response of JSON error
     *         with success as false and appropriate error message.
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value = InvalidCardDetailsException.class)
    public ResponseEntity<Object> exception(InvalidCardDetailsException exception) {
        logger.error("Card number is not compatible with Luhn10",exception.getMessage());
        return new ResponseEntity<>(createResponseBody(true,"Card details are invalid"), HttpStatus.BAD_REQUEST);
    }
    /**
     * This exception method handles all system related exceptions.
     * @return ResponseEntity<Object> This returns response of JSON error
     *         with success as false and appropriate error message.
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value = ProcessingError.class)
    public ResponseEntity<Object> exception(ProcessingError exception) {
        logger.error("Error processing request", exception.getMessage());
        return new ResponseEntity<>(createResponseBody(true,"Error processing request"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    /**
     * This exception method handles invalid body in request.
     * @return ResponseEntity<Object> This returns response of JSON error
     *         with success as false and appropriate error message.
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(MethodArgumentNotValidException e) {
        logger.error("Request body parameters not valid", e.getMessage());
        return new ResponseEntity<>(createResponseBody(true,"Invalid request body."), HttpStatus.BAD_REQUEST);
    }

    private String createResponseBody(boolean status, String message) {
        Map responseMap = new HashMap();
        responseMap.put("success", status);
        responseMap.put("message",message);
        return new Gson().toJson(responseMap);
    }
}
