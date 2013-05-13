package com.octo.red.newsql.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class VAT {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Integer groupId;
	private String vatLabel;
	@Column(precision=20, scale=10)
	private BigDecimal vatRate;
	private Boolean isDeletable;
	private Integer vatType;
	private Boolean isExempted;
	private Date deletionDate;
	@ManyToOne
	private Country country;
	
	public Long getId() {
		return id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getVatLabel() {
		return vatLabel;
	}

	public void setVatLabel(String vatLabel) {
		this.vatLabel = vatLabel;
	}

	public BigDecimal getVatRate() {
		return vatRate;
	}

	public void setVatRate(BigDecimal vatRate) {
		this.vatRate = vatRate;
	}

	public Boolean getIsDeletable() {
		return isDeletable;
	}

	public void setIsDeletable(Boolean isDeletable) {
		this.isDeletable = isDeletable;
	}

	public Integer getVatType() {
		return vatType;
	}

	public void setVatType(Integer vatType) {
		this.vatType = vatType;
	}

	public Boolean getIsExempted() {
		return isExempted;
	}

	public void setIsExempted(Boolean isExempted) {
		this.isExempted = isExempted;
	}

	public Date getDeletionDate() {
		return deletionDate;
	}

	public void setDeletionDate(Date deletionDate) {
		this.deletionDate = deletionDate;
	}

	/**
	 * Do not use setter but rather addVat() on the country side
	 * @return
	 */
	public Country getCountry() {
		return country;
	}

	
	void setCountry(Country country) {
		this.country = country; 
	}
}