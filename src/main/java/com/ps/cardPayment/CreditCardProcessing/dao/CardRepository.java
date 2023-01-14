package com.ps.cardPayment.CreditCardProcessing.dao;

import com.ps.cardPayment.CreditCardProcessing.bean.CardDetails;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<CardDetails, Integer> {
}
