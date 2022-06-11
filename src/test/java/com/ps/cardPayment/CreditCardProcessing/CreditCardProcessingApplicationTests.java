package com.ps.cardPayment.CreditCardProcessing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CreditCardProcessingApplicationTests {

	@Autowired
	private CreditCardProcessingApplication creditCardProcessingApplication;
	@Test
	void contextLoads() {
		assertThat(creditCardProcessingApplication).isNotIn();
	}

}
