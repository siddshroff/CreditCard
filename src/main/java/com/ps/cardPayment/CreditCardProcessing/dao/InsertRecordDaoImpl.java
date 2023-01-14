package com.ps.cardPayment.CreditCardProcessing.dao;

import com.ps.cardPayment.CreditCardProcessing.bean.CardDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * This data access class inserts the card record into database.
 *
 * @author  Siddharth Shroff
 * @version 1.0
 * @since   13-06-2022
 */
@Repository
public class InsertRecordDaoImpl {
    private static final Logger logger = LoggerFactory.getLogger(InsertRecordDaoImpl.class);
    private final String hashReference = "CardDetails";
    //@Autowired
    //private RedisTemplate<String, Object> template;
    @Autowired
    CardRepository cardRepository;
    /**
     * This data access method is used to insert card details.
     * It generates a unique identifier for card IDs.
     * @param cardDetails This object has all card details.
     * @return void This returns nothing.
     */
    public void saveCardDetails(CardDetails cardDetails) {
        /*UUID uniqueID = UUID.randomUUID();
        cardDetails.setId(uniqueID);*/
        logger.info("Saving card details in database");
        cardRepository.save(cardDetails);
        //template.opsForHash().putIfAbsent(hashReference, cardDetails.getId(), cardDetails);
    }
}
