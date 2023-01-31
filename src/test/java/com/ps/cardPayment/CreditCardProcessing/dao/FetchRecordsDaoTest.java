package com.ps.cardPayment.CreditCardProcessing.dao;

import com.ps.cardPayment.CreditCardProcessing.bean.CardDetails;
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
public class FetchRecordsDaoTest {

    @Autowired
    @MockBean
    CardRepository cardRepository;

    @Autowired
    FetchRecordsDaoImpl fetchRecordsDao;

    @BeforeEach
    public void setUp() throws Exception {
        // Initialize mocks created above
        MockitoAnnotations.initMocks(this);
        // Change behaviour of `resource`
        when(cardRepository.findAll()).thenReturn(new ArrayList<CardDetails>());
    }

    @Test
    public void fetchAllCardsTest(){

        Assert.isInstanceOf(List.class, fetchRecordsDao.getAllCards());
    }
}
