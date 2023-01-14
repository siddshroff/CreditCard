package com.ps.cardPayment.CreditCardProcessing.bean;

import lombok.*;

import javax.persistence.*;
//import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
/**
 * This entity class refers to card details
 * record into database.
 *
 * @author  Siddharth Shroff
 * @version 1.0
 * @since   13-06-2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
//@RedisHash("CardDetails")
public class CardDetails implements Serializable {

    private static final long serialVersionUID = -7817224776021728682L;
    @Id
    @Column(name = "card_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long cardId;
    @NotBlank(message = "Name must not be blank")
    @Column(name = "name")
    private String name;
    @NotBlank
    @Digits(integer = 19, fraction = 0, message = "Card number is not valid")
    @Column(name = "card_number")
    private String cardNumber;
    @NotBlank(message = "Need to provide limit")
    @Column(name = "`limit`")
    private String limit;
    @Column(name = "balance")
    private String balance = "0";

    public CardDetails(CardDetails cardDetails) {
    }
}
