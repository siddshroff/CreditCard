package com.ps.cardPayment.CreditCardProcessing.dao;

import com.ps.cardPayment.CreditCardProcessing.bean.CardDetails;


public interface InsertRecordDao {

    void saveCardDetails(CardDetails cardDetails);

}
