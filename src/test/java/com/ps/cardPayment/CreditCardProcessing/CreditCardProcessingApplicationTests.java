package com.ps.cardPayment.CreditCardProcessing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ps.cardPayment.CreditCardProcessing.controllers.CardServicesHandler;
import com.ps.cardPayment.CreditCardProcessing.dao.InsertRecordDaoImpl;
import com.ps.cardPayment.CreditCardProcessing.service.AddCardImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CreditCardProcessingApplicationTests {

	@Autowired
	private CreditCardProcessingApplication creditCardProcessingApplication;
	@Autowired
	private CardServicesHandler cardServicesHandler;
	@Autowired
	private AddCardImpl addCard;
	@Autowired
	private InsertRecordDaoImpl insertRecordDao;
	@Autowired
	private MockMvc mockMvc;
	private static final String API = "/v1/cards";
	@Test
	void contextLoads() {
		assertThat(creditCardProcessingApplication).isNotNull();
	}
	@Test
	public void testInsertCard() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String,Object> body = new HashMap<>();
		body.put("name","dummy");
		body.put("cardNumber","79927398713");
		body.put("limit","500");

		this.mockMvc.perform(post(API).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(body)))
				.andExpect(status().isCreated());
	}
	@Test
	public void testInsertInvalidCard() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String,Object> body = new HashMap<>();
		body.put("name","dummy");
		body.put("cardNumber","12345");
		body.put("limit","500");

		this.mockMvc.perform(post(API).accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(body)))
				.andExpect(status().isBadRequest())
				.andExpect(content().string(containsString("Card details are invalid")));;
	}
	@Test
	public void testInsertInvalidCardNumber() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String,Object> body = new HashMap<>();
		body.put("cardNumber","79927398713");
		body.put("limit","500");

		this.mockMvc.perform(post(API).accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(body)))
				.andExpect(status().isBadRequest())
				.andExpect(content().string(containsString("Invalid request body.")));
	}
	@Test
	public void testFetchCards() throws Exception {

		this.mockMvc.perform(get(API).accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
