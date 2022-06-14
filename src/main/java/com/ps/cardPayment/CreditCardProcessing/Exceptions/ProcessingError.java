package com.ps.cardPayment.CreditCardProcessing.Exceptions;

/**
 * This RuntimeException child class is thrown when any
 * system exceptions are thrown
 *
 * @author  Siddharth Shroff
 * @version 1.0
 * @since   13-06-2022
 */
public class ProcessingError extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ProcessingError(String message) {
    }
}