package com.ps.cardPayment.CreditCardProcessing.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FetchRecordsDaoImpl {

    private final String hashReference = "CardDetails";
    @Autowired
    private RedisTemplate<String, Object> template;

    public List<Object> getAllCards() {
        return template.opsForHash().values(hashReference);
    }


}
