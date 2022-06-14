package com.ps.cardPayment.CreditCardProcessing.service;

import com.ps.cardPayment.CreditCardProcessing.Exceptions.InvalidCardDetailsException;
import com.ps.cardPayment.CreditCardProcessing.bean.CardDetails;
import com.ps.cardPayment.CreditCardProcessing.dao.InsertRecordDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This service class deals with all endpoints related to
 * adding card details
 *
 * @author  Siddharth Shroff
 * @version 1.0
 * @since   13-06-2022
 */
@Service
public class AddCardImpl implements AddCard {

    private CardDetails newCard = new CardDetails();
    private static final Logger logger = LoggerFactory.getLogger(AddCardImpl.class);
    @Autowired
    private InsertRecordDaoImpl insertCard;
    /**
     * This method is used to insert card details. This also check
     * if the card number is according to Luhn10.
     * @param cardDetails This object has all card details.
     * @return void This returns nothing.
     */

    public void insertCardDetails(CardDetails cardDetails) throws InvalidCardDetailsException {

        if(checkLuhn(cardDetails.getCardNumber())) {
            logger.info("Card number is compatible with Luhn10");
            insertCard.saveCardDetails(cardDetails);
        }else{
            logger.info("Checking if card number is not compatible with Luhn10");
            throw new InvalidCardDetailsException();
        }
    }

    /**
     * This method is used to check if the card number is
     * according to Luhn10. It returns true if it is validated
     * and false if not.
     * @param cardNo This is card number fetched from card details provided
     *               by request body.
     * @return void This returns nothing.
     */
    private boolean checkLuhn(String cardNo)
    {
        logger.info("Checking if card number is compatible with Luhn10");
        int numberOfDigits = cardNo.length()-1;

        int sum = 0,i=numberOfDigits;
        boolean isSecondDigit = false;
        while (i >= 0)
        {
            int temp = cardNo.charAt(i) - '0';
            if (isSecondDigit)
                temp *= 2;
            sum += temp / 10;
            sum += temp % 10;
            isSecondDigit = !isSecondDigit;
            i--;
        }
        return (sum % 10 == 0);
    }
}