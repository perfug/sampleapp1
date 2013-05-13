package com.octo.red.newsql.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class CategoryFamily {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Integer groupid;
	private String label;
	private Integer marginType;
	private BigDecimal commissionRate;
	private BigDecimal marginCoefficient;
	private Long margin;
	private Long minimumAuthorisedAmount;
	private Long maximumAuthorisedAmount;
	private Boolean isDeletable;
	private Boolean isDiscountable;
	private Date deletionDate;
	@ManyToMany
	private Set<VAT> vats = new HashSet<VAT>();
	private Date modificationDate;
	private String familyType;
	private Integer productType;
	private Boolean isTracked;
	private Integer familyPressType;

	public Long getId() {
		return id;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getMarginType() {
		return marginType;
	}

	public void setMarginType(Integer marginType) {
		this.marginType = marginType;
	}

	public BigDecimal getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(BigDecimal commissionRate) {
		this.commissionRate = commissionRate;
	}

	public BigDecimal getMarginCoefficient() {
		return marginCoefficient;
	}

	public void setMarginCoefficient(BigDecimal marginCoefficient) {
		this.marginCoefficient = marginCoefficient;
	}

	public Long getMargin() {
		return margin;
	}

	public void setMargin(Long margin) {
		this.margin = margin;
	}

	public Long getMinimumAuthorisedAmount() {
		return minimumAuthorisedAmount;
	}

	public void setMinimumAuthorisedAmount(Long minimumAuthorisedAmount) {
		this.minimumAuthorisedAmount = minimumAuthorisedAmount;
	}

	public Long getMaximumAuthorisedAmount() {
		return maximumAuthorisedAmount;
	}

	public void setMaximumAuthorisedAmount(Long maximumAuthorisedAmount) {
		this.maximumAuthorisedAmount = maximumAuthorisedAmount;
	}

	public Boolean getIsDeletable() {
		return isDeletable;
	}

	public void setIsDeletable(Boolean isDeletable) {
		this.isDeletable = isDeletable;
	}

	public Boolean getIsDiscountable() {
		return isDiscountable;
	}

	public void setIsDiscountable(Boolean isDiscountable) {
		this.isDiscountable = isDiscountable;
	}

	public Date getDeletionDate() {
		return deletionDate;
	}

	public void setDeletionDate(Date deletionDate) {
		this.deletionDate = deletionDate;
	}

	/**
	 * Do not use setter but addVat()
	 * @return
	 */
	public Set<VAT> getVats() {
		return vats;
	}

	public void addVat(VAT vat) {
		assert vat != null;
		vats.add(vat);
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public String getFamilyType() {
		return familyType;
	}

	public void setFamilyType(String familyType) {
		this.familyType = familyType;
	}

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public Boolean getIsTracked() {
		return isTracked;
	}

	public void setIsTracked(Boolean isTracked) {
		this.isTracked = isTracked;
	}

	public Integer getFamilyPressType() {
		return familyPressType;
	}

	public void setFamilyPressType(Integer familyPressType) {
		this.familyPressType = familyPressType;
	}

}
