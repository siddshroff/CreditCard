package com.ps.cardPayment.CreditCardProcessing.dao;

import com.ps.cardPayment.CreditCardProcessing.bean.CardDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class InsertRecordDaoImpl {
    private static final Logger logger = LoggerFactory.getLogger(InsertRecordDaoImpl.class);
    private final String hashReference = "CardDetails";
    @Autowired
    private RedisTemplate<String, Object> template;

    public void saveCardDetails(CardDetails cardDetails) {
        UUID uniqueID = UUID.randomUUID();
        cardDetails.setId(uniqueID.toString());
        logger.info("Saving card details in database");
        template.opsForHash().putIfAbsent(hashReference, cardDetails.getId(), cardDetails);
    }
}
