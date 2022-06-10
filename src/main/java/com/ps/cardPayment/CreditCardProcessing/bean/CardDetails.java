package com.ps.cardPayment.CreditCardProcessing.bean;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("CardDetails")
public class CardDetails implements Serializable {

    private static final long serialVersionUID = -7817224776021728682L;
    @Id
    private String Id;
    @NonNull
    private String name;
    @NonNull
    private String cardNumber;
    @NonNull
    private String limit;
    private String balance = "0";

}
