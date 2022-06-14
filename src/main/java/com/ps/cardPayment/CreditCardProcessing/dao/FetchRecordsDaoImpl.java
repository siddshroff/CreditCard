package com.ps.cardPayment.CreditCardProcessing.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * This data access class fetches the card record/s
 * from database.
 *
 * @author  Siddharth Shroff
 * @version 1.0
 * @since   13-06-2022
 */
@Repository
public class FetchRecordsDaoImpl {
    private static final Logger logger = LoggerFactory.getLogger(FetchRecordsDaoImpl.class);
    private final String hashReference = "CardDetails";
    @Autowired
    private RedisTemplate<String, Object> template;

    /**
     * This data access method is used to fetch all card details.
     * @return List This returns list of data objects and passed to
     *              higher layers.
     */
    public List<Object> getAllCards() {
        logger.info("Fetching all cards from database");
        return template.opsForHash().values(hashReference);
    }


}
