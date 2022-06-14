package com.ps.cardPayment.CreditCardProcessing.dao;

import com.ps.cardPayment.CreditCardProcessing.bean.CardDetails;

/**
 * This data access interface inserts the card record into database.
 *
 * @author  Siddharth Shroff
 * @version 1.0
 * @since   13-06-2022
 */
public interface InsertRecordDao {

    void saveCardDetails(CardDetails cardDetails);

}
