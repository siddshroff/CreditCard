package com.ps.cardPayment.CreditCardProcessing.controllers;

import com.google.gson.Gson;
import com.ps.cardPayment.CreditCardProcessing.Exceptions.ProcessingError;
import com.ps.cardPayment.CreditCardProcessing.bean.CardDetails;
import com.ps.cardPayment.CreditCardProcessing.service.AddCard;
import com.ps.cardPayment.CreditCardProcessing.service.GetCards;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CardServicesHandler {
    private static final Logger logger = LoggerFactory.getLogger(CardServicesHandler.class);
    @Autowired
    AddCard addCardDetails;
    @Autowired
    GetCards getCards;

    @RequestMapping(value = "/addCard", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value= "/addCard")
    public ResponseEntity insertCardDetails( @Valid @RequestBody CardDetails cardDetails) throws ExceptionHandler {
        try {
            logger.info("Attempting insertion of card details");
            addCardDetails.insertCardDetails(cardDetails);
            logger.info("Inserted card details successfully");

            return new ResponseEntity<>("{\"Success\":true,\"Message\":\"Card is added successfully\"}", HttpStatus.CREATED);
        }catch(Exception e){
            logger.error("Error adding card details",e.getMessage());
            throw new ProcessingError("Error adding card details");
        }
    }

    @RequestMapping(value = "/getAllCards", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCards() {
        try {
            logger.info("Fetching all card details");
            List<Object> cards = getCards.getAllCards();
            return new ResponseEntity<>(new Gson().toJson(cards.stream().map(CardDetails.class::cast)
                    .collect(Collectors.toList())), HttpStatus.OK);
        }catch(Exception e){
            logger.error("Error fetching card details",e.getMessage());
            throw new ProcessingError("Error fetching card details");
        }
    }

}
