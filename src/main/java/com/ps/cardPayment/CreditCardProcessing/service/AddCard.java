package com.ps.cardPayment.CreditCardProcessing.service;

import com.ps.cardPayment.CreditCardProcessing.Exceptions.InvalidCardDetailsException;
import com.ps.cardPayment.CreditCardProcessing.bean.CardDetails;


public interface AddCard {

    public abstract void insertCardDetails(CardDetails cardDetails) throws InvalidCardDetailsException;
}
