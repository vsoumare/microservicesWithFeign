package com.saraya.microservices.currencyexchangeservice2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.microservices.currencyexchangeservice2.bean.CurrencyExchange;

@Repository
public interface CurrencyExchangeRepository extends 
		JpaRepository<CurrencyExchange, Long> {
	CurrencyExchange findByFromAndTo(String from, String to);
}
