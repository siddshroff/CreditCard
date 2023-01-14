package com.ps.cardPayment.CreditCardProcessing.service;

import com.ps.cardPayment.CreditCardProcessing.bean.CardDetails;
import com.ps.cardPayment.CreditCardProcessing.dao.FetchRecordsDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This service class deals with all endpoints related to
 * fetching card details
 *
 * @author  Siddharth Shroff
 * @version 1.0
 * @since   13-06-2022
 */
@Service
public class GetCardsImpl implements GetCards {

    private static final Logger logger = LoggerFactory.getLogger(GetCardsImpl.class);
    @Autowired
    private FetchRecordsDaoImpl getAllCards;

    /**
     * This method is used to insert card details. This also check
     * if the card number is according to Luhn10.
     * @return List This returns list of objects containing card
     *          details.
     */

    public List<CardDetails> getAllCards() {
        logger.info("Fetching all cards");
        return getAllCards.getAllCards();
    }

}
