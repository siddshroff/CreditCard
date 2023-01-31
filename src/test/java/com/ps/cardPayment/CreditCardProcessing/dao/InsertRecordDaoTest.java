package com.ps.cardPayment.CreditCardProcessing.dao;

import com.ps.cardPayment.CreditCardProcessing.bean.CardDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import static org.mockito.Mockito.when;

@SpringBootTest
public class InsertRecordDaoTest {

    @Autowired
    @MockBean
    CardRepository cardRepository;

    @Autowired
    InsertRecordDaoImpl insertRecordDao;

    @BeforeEach
    public void setUp() throws Exception {
        CardDetails cardDetails = new CardDetails();
        cardDetails.setCardNumber(79927398713l);
        cardDetails.setLimit(500l);
        cardDetails.setBalance(60l);
        cardDetails.setName("dummy");
        // Initialize mocks created above
        MockitoAnnotations.initMocks(this);
        when(cardRepository.save(cardDetails)).thenReturn(cardDetails);
    }

    @Test
    public void insertCardDetailsTest(){
        CardDetails cardDetails = new CardDetails();
        cardDetails.setCardNumber(79927398713l);
        cardDetails.setLimit(500l);
        cardDetails.setBalance(60l);
        cardDetails.setName("dummy");
        Assert.isInstanceOf(CardDetails.class, insertRecordDao.saveCardDetails(cardDetails));
    }
}
