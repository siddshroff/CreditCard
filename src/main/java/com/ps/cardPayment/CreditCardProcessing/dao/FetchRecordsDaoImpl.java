package com.ps.cardPayment.CreditCardProcessing.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FetchRecordsDaoImpl {
    private static final Logger logger = LoggerFactory.getLogger(FetchRecordsDaoImpl.class);
    private final String hashReference = "CardDetails";
    @Autowired
    private RedisTemplate<String, Object> template;

    public List<Object> getAllCards() {
        logger.info("Fetching all cards from database");
        return template.opsForHash().values(hashReference);
    }


}
