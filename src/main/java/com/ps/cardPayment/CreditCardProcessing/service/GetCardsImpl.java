package com.ps.cardPayment.CreditCardProcessing.service;

import com.ps.cardPayment.CreditCardProcessing.dao.FetchRecordsDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCardsImpl implements GetCards {

    private static final Logger logger = LoggerFactory.getLogger(GetCardsImpl.class);
    @Autowired
    private FetchRecordsDaoImpl getAllCards;

    /**
     * @return
     */

    public List<Object> getAllCards() {
        List<Object> lstCards = getAllCards.getAllCards();
        return lstCards;
    }

}
