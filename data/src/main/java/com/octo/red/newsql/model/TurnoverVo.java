package com.octo.red.newsql.model;

import java.math.BigDecimal;

public class TurnoverVo {
	private long groupId;
	private BigDecimal totalAmount;
	private String currency;
	
	public long getGroupId() {
		return groupId;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public String getCurrency() {
		return currency;
	}
	
	public TurnoverVo(long groupId, BigDecimal totalAmount, String currency) {
		this.groupId = groupId;
		this.totalAmount = totalAmount;
		this.currency = currency;
	}
	
}
