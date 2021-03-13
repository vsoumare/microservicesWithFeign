package com.saraya.microservices.currencyexchangeservice2.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.microservices.currencyexchangeservice2.bean.CurrencyExchange;
import com.saraya.microservices.currencyexchangeservice2.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository cer;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		//CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to,BigDecimal.valueOf(50));
		CurrencyExchange currencyExchange = cer.findByFromAndTo(from, to);
		String port = environment.getProperty("local.server.port");
		if(currencyExchange == null) {
			throw new RuntimeException("Unable to Find data for " + from +
					"to" + to);
		}
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}
}
