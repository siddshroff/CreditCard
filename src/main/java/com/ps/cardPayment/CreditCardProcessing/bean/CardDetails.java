package com.ps.cardPayment.CreditCardProcessing.bean;

import lombok.*;

import javax.persistence.*;
//import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @Digits(integer = 19, fraction = 0, message = "Card number is not valid")
    @Column(name = "card_number")
    private Long cardNumber;

    @NotNull
    @Column(name = "`limit`")
    private Long limit;
    @Column(name = "balance")
    private Long balance = 0l;

    public CardDetails(CardDetails cardDetails) {
    }
}
