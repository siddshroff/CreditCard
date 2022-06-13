package com.ps.cardPayment.CreditCardProcessing.bean;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

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
@RedisHash("CardDetails")
public class CardDetails implements Serializable {

    private static final long serialVersionUID = -7817224776021728682L;
    @Id
    private String Id;
    @NotBlank(message = "Name must not be blank")
    private String name;
    @NotBlank
    @Digits(integer = 19, fraction = 0, message = "Card number is not valid")
    private String cardNumber;
    @NotBlank(message = "Need to provide limit")
    private String limit;
    private String balance = "0";

}
