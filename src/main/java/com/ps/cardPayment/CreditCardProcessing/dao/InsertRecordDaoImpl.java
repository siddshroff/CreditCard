package com.ps.cardPayment.CreditCardProcessing.dao;

import com.ps.cardPayment.CreditCardProcessing.bean.CardDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class InsertRecordDaoImpl {

    private final String hashReference = "CardDetails";
    @Autowired
    private RedisTemplate<String, Object> template;

    public void saveCardDetails(CardDetails cardDetails) {
        UUID uniqueID = UUID.randomUUID();
        cardDetails.setId(uniqueID.toString());
        //creates one record in Redis DB if record with that Id is not present
        template.opsForHash().putIfAbsent(hashReference, cardDetails.getId(), cardDetails);
    }

    public List<Object> getAllCard() {
        return template.opsForHash().values(hashReference);
    }


}
