package com.ps.cardPayment.CreditCardProcessing.service;

import com.ps.cardPayment.CreditCardProcessing.Exceptions.InvalidCardDetailsException;
import com.ps.cardPayment.CreditCardProcessing.bean.CardDetails;

/**
 * This service interface deals with all endpoints related to
 * adding card details
 *
 * @author  Siddharth Shroff
 * @version 1.0
 * @since   13-06-2022
 */
public interface AddCard {
    void insertCardDetails(CardDetails cardDetails) throws InvalidCardDetailsException;
}
