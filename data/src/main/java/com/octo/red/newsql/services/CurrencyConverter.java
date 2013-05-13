package com.octo.red.newsql.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CurrencyConverter {
	public BigDecimal convert(BigDecimal fromAmount, String fromCurrency, String targetCurrency) {
		//Fake
		return fromAmount;
	}
	
	public String getCurrency(String countryAlphaCode3) {
		//Fake
		if(countryAlphaCode3 == "FRA") {
			return "EUR";
		}
		else if(countryAlphaCode3 == "USA") {
			return "USD";
		}
		else if(countryAlphaCode3 == "GBR") {
			return "GBP";
		}
		else {
			return "USD";
		}
	}
}