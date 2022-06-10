package com.ps.cardPayment.CreditCardProcessing.controllers;

import com.google.gson.Gson;
import com.ps.cardPayment.CreditCardProcessing.bean.CardDetails;
import com.ps.cardPayment.CreditCardProcessing.service.AddCard;
import com.ps.cardPayment.CreditCardProcessing.service.GetCards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.smartcardio.Card;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CardServicesHandler {
    @Autowired
    AddCard addCardDetails;
    @Autowired
    GetCards getCards;

    @RequestMapping(value = "/addCard", method = RequestMethod.POST)
    public ResponseEntity insertCardDetails(@RequestBody CardDetails cardDetails) throws ExceptionHandler {
        addCardDetails.insertCardDetails(cardDetails);
        return new ResponseEntity<>("Card is added successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity getAllCards() {
        List cards = getCards.getAllCards();
        //cards.stream().map(CardDetails.class::cast).collect(Collectors.toList());
        //cards.stream().flatMap(x -> ((CardDetails)x).getCardNumber()).collect(Collectors.toList());
        //CardDetails obj = (CardDetails) cards.get(0);


        //objGson.toJson(cards.stream().map(CardDetails::getCardNumber).flatMap(Collection::stream));
        return new ResponseEntity<>(new Gson().toJson(cards.stream().map(CardDetails.class::cast).collect(Collectors.toList())), HttpStatus.OK);
    }
}
