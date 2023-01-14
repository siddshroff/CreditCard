package com.ps.cardPayment.CreditCardProcessing.service;

import com.ps.cardPayment.CreditCardProcessing.bean.CardDetails;

import java.util.List;
/**
 * This service interface deals with all endpoints related to
 * fetching card details
 *
 * @author  Siddharth Shroff
 * @version 1.0
 * @since   13-06-2022
 */
public interface GetCards {
    List<CardDetails> getAllCards();
}
