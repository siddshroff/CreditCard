package com.ps.cardPayment.CreditCardProcessing.service;

import com.ps.cardPayment.CreditCardProcessing.Exceptions.InvalidCardDetailsException;
import com.ps.cardPayment.CreditCardProcessing.bean.CardDetails;
import com.ps.cardPayment.CreditCardProcessing.dao.InsertRecordDaoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import javax.smartcardio.Card;

import static org.mockito.Mockito.when;

@SpringBootTest
public class AddCardTests {
    @Autowired
    private AddCardImpl addCard;
    @Autowired
    @MockBean
    private InsertRecordDaoImpl insertRecordDao;
    @BeforeEach
    public void setUp() throws Exception {
        CardDetails cardDetails = new CardDetails();
        cardDetails.setCardNumber(79927398713l);
        cardDetails.setLimit(500l);
        cardDetails.setBalance(60l);
        cardDetails.setName("dummy");
        // Initialize mocks created above
        MockitoAnnotations.initMocks(this);
        // Change behaviour of `resource`
        when(insertRecordDao.saveCardDetails(cardDetails)).thenReturn(cardDetails);
    }
    @Test
    public void insertCardDetailsTest(){
        CardDetails cardDetails = new CardDetails();
        cardDetails.setCardNumber(79927398713l);
        cardDetails.setLimit(500l);
        cardDetails.setBalance(60l);
        cardDetails.setName("dummy");
        //Mockito.doNothing().when(insertRecordDao).saveCardDetails(cardDetails);
        when(insertRecordDao.saveCardDetails(cardDetails)).thenReturn(cardDetails);
        Assert.isInstanceOf(CardDetails.class, addCard.insertCardDetails(cardDetails));
    }
    @Test
    public void insertCardDetailsTestFailures(){
        CardDetails cardDetails = new CardDetails();
        cardDetails.setCardNumber(79927398714l);
        cardDetails.setLimit(500l);
        cardDetails.setBalance(60l);
        cardDetails.setName("dummy");
        //Mockito.doNothing().when(insertRecordDao).saveCardDetails(cardDetails);
        when(insertRecordDao.saveCardDetails(cardDetails)).thenReturn(cardDetails);
        Assertions.assertThrows(InvalidCardDetailsException.class, ()->{
            addCard.insertCardDetails(cardDetails);
        });
    }
}
