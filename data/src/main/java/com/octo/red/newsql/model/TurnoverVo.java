package com.octo.red.newsql.model;

import java.math.BigDecimal;

public class TurnoverVo {
	private long groupId;
	private BigDecimal totalAmout;
	private String currency;
	
	public long getGroupId() {
		return groupId;
	}
	public BigDecimal getTotalAmout() {
		return totalAmout;
	}
	public String getCurrency() {
		return currency;
	}
	
	public TurnoverVo(long groupId, BigDecimal totalAmout, String currency) {
		super();
		this.groupId = groupId;
		this.totalAmout = totalAmout;
		this.currency = currency;
	}
	
}
