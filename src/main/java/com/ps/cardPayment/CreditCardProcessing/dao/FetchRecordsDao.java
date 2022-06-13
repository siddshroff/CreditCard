package com.ps.cardPayment.CreditCardProcessing.dao;

import java.util.List;
/**
 * This data access interface fetches the card record/s
 * from database.
 *
 * @author  Siddharth Shroff
 * @version 1.0
 * @since   13-06-2022
 */
public interface FetchRecordsDao {

    List<Object> getAllCards();

}
