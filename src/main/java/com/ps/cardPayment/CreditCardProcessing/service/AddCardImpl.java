package com.ps.cardPayment.CreditCardProcessing.service;

import com.ps.cardPayment.CreditCardProcessing.Exceptions.InvalidCardDetailsException;
import com.ps.cardPayment.CreditCardProcessing.bean.CardDetails;
import com.ps.cardPayment.CreditCardProcessing.dao.InsertRecordDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddCardImpl implements AddCard {

    private CardDetails newCard = new CardDetails();
    private static final Logger logger = LoggerFactory.getLogger(AddCardImpl.class);
    @Autowired
    private InsertRecordDaoImpl insertCard;
    /**
     * @param cardDetails
     * @return
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
    private boolean checkLuhn(String cardNo)
    {
        logger.info("Checking if card number is compatible with Luhn10");
        int nDigits = cardNo.length();

        int nSum = 0;
        boolean isSecond = false;
        for (int i = nDigits - 1; i >= 0; i--)
        {

            int d = cardNo.charAt(i) - '0';

            if (isSecond)
                d = d * 2;

            nSum += d / 10;
            nSum += d % 10;

            isSecond = !isSecond;
        }
        return (nSum % 10 == 0);
    }
}