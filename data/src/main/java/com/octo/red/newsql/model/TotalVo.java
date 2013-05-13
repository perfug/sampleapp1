package com.octo.red.newsql.model;

import java.math.BigDecimal;

public class TotalVo {
	private BigDecimal amount;
	private String currency;
		
	public BigDecimal getAmount() {
		return amount;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public TotalVo(BigDecimal amount, String currency) {
		super();
		this.amount = amount;
		this.currency = currency;
	}
	
}
