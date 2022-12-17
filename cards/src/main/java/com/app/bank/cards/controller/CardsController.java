package com.app.bank.cards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.bank.cards.config.CardsServiceConfig;
import com.app.bank.cards.model.Cards;
import com.app.bank.cards.model.Customer;
import com.app.bank.cards.model.Properties;
import com.app.bank.cards.repository.CardsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class CardsController {
	
	@Autowired
	private CardsRepository cardRepository;
	
	@Autowired
	private CardsServiceConfig cardsConfig;

	@PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestBody Customer customer){
		List<Cards> cards = cardRepository.findByCustomerId(customer.getCustomerId());
		if(cards!=null){
			return cards;
		}
		return null;
	}
	
	@GetMapping("/card/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(cardsConfig.getMsg(), cardsConfig.getBuildVersion(),
				cardsConfig.getMailDetails(), cardsConfig.getActiveBranches());
		String jsonStr = ow.writeValueAsString(properties);
		return jsonStr;
	}
}
