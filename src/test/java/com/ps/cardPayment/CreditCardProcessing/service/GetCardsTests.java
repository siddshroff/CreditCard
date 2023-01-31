package com.ps.cardPayment.CreditCardProcessing.service;

import com.ps.cardPayment.CreditCardProcessing.Exceptions.InvalidCardDetailsException;
import com.ps.cardPayment.CreditCardProcessing.Exceptions.ProcessingError;
import com.ps.cardPayment.CreditCardProcessing.bean.CardDetails;
import com.ps.cardPayment.CreditCardProcessing.dao.FetchRecordsDaoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class GetCardsTests {

    @Autowired
    @MockBean
    private FetchRecordsDaoImpl getAllCards;

    @BeforeEach
    public void setUp() throws Exception {
        // Initialize mocks created above
        MockitoAnnotations.initMocks(this);
        // Change behaviour of `resource`
        when(getAllCards.getAllCards()).thenReturn(new ArrayList<CardDetails>());
    }

    @Test
    public void fetchCardsTest(){

        Assert.isInstanceOf(List.class, getAllCards.getAllCards());
    }

    @Test
    public void fetchCardsFailedTest(){
        when(getAllCards.getAllCards()).thenThrow(new RuntimeException("Dummy error"));
        Assertions.assertThrows(RuntimeException.class, ()->{
            getAllCards.getAllCards();
        });
    }
}
