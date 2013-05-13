package com.octo.red.newsql.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SaleTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Integer groupId;
	private Date startDate;
	private Integer clerkNumber;
	private String clerkName;
	private Date cancellation;
	private Integer cancellationClerkNumber;
	private String cancellationClerkName;
	private Integer ticketNumber;
	private Integer clientNumber;
	private String clientName;
	private BigDecimal totalAmount;
	private String changeAmount;
	private Long discountRate;
	private String discountAmount;
	private Integer cancellationTicketNumber;
	private Integer cancellationType;
	private String transactionKey;

	public Long getId() {
		return id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getClerkNumber() {
		return clerkNumber;
	}

	public void setClerkNumber(Integer clerkNumber) {
		this.clerkNumber = clerkNumber;
	}

	public String getClerkName() {
		return clerkName;
	}

	public void setClerkName(String clerkName) {
		this.clerkName = clerkName;
	}

	public Date getCancellation() {
		return cancellation;
	}

	public void setCancellation(Date cancellation) {
		this.cancellation = cancellation;
	}

	public Integer getCancellationClerkNumber() {
		return cancellationClerkNumber;
	}

	public void setCancellationClerkNumber(Integer cancellationClerkNumber) {
		this.cancellationClerkNumber = cancellationClerkNumber;
	}

	public String getCancellationClerkName() {
		return cancellationClerkName;
	}

	public void setCancellationClerkName(String cancellationClerkName) {
		this.cancellationClerkName = cancellationClerkName;
	}

	public Integer getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(Integer ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public Integer getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(Integer clientNumber) {
		this.clientNumber = clientNumber;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getChangeAmount() {
		return changeAmount;
	}

	public void setChangeAmount(String changeAmount) {
		this.changeAmount = changeAmount;
	}

	public Long getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(Long discountRate) {
		this.discountRate = discountRate;
	}

	public String getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(String discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Integer getCancellationTicketNumber() {
		return cancellationTicketNumber;
	}

	public void setCancellationTicketNumber(Integer cancellationTicketNumber) {
		this.cancellationTicketNumber = cancellationTicketNumber;
	}

	public Integer getCancellationType() {
		return cancellationType;
	}

	public void setCancellationType(Integer cancellationType) {
		this.cancellationType = cancellationType;
	}

	public String getTransactionKey() {
		return transactionKey;
	}

	public void setTransactionKey(String transactionKey) {
		this.transactionKey = transactionKey;
	}

}
