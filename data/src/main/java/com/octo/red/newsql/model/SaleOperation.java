package com.octo.red.newsql.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class SaleOperation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Integer groupId;
	@Column(name="OPERATIONDATE")
	private Date date;
	private String productLabel;
	private String supplierProductReference;
	private Integer businessCategory;
	private Integer quantity;
	private BigDecimal amount;
	private String currency;
	private Integer cashierNumber;
	private String cashierName;
	private Date annulation;
	private Integer annulationCashierNumber;
	private String annulationCashierName;
	private Boolean isReturn;
	private Boolean isBackToStock;
	private String reloadCode;
	private Integer specialOperationTypeSalePrice;
	private Long discountRate;
	private String discountAmount;
	private Long increaseRate;
	private Boolean isScanned;
	private String salesCode;
	@OneToOne
	private SaleTransaction saleTransaction;
	private Integer annulationType;
	private String onlineSaleStatus;
	private String bossTransactionNumber;
	@ManyToOne
	private Product product;

	public Long getId() {
		return id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupeid) {
		this.groupId = groupeid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getProductLabel() {
		return productLabel;
	}

	public void setProductLabel(String productLabel) {
		this.productLabel = productLabel;
	}

	public String getSupplierProductReference() {
		return supplierProductReference;
	}

	public void setSupplierProductReference(String supplierProductReference) {
		this.supplierProductReference = supplierProductReference;
	}

	public Integer getBusinessCategory() {
		return businessCategory;
	}

	public void setBusinessCategory(Integer businessCategory) {
		this.businessCategory = businessCategory;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getCashierNumber() {
		return cashierNumber;
	}

	public void setCashierNumber(Integer cashierNumber) {
		this.cashierNumber = cashierNumber;
	}

	public String getCashierName() {
		return cashierName;
	}

	public void setCashierName(String cashierName) {
		this.cashierName = cashierName;
	}

	public Date getAnnulation() {
		return annulation;
	}

	public void setAnnulation(Date annulation) {
		this.annulation = annulation;
	}

	public Integer getAnnulationCashierNumber() {
		return annulationCashierNumber;
	}

	public void setAnnulationCashierNumber(Integer annulationCashierNumber) {
		this.annulationCashierNumber = annulationCashierNumber;
	}

	public String getAnnulationCashierName() {
		return annulationCashierName;
	}

	public void setAnnulationCashierName(String annulationCashierName) {
		this.annulationCashierName = annulationCashierName;
	}

	public Boolean getIsReturn() {
		return isReturn;
	}

	public void setIsReturn(Boolean isReturn) {
		this.isReturn = isReturn;
	}

	public Boolean getIsBackToStock() {
		return isBackToStock;
	}

	public void setIsBackToStock(Boolean isBackToStock) {
		this.isBackToStock = isBackToStock;
	}

	public String getReloadCode() {
		return reloadCode;
	}

	public void setReloadCode(String reloadCode) {
		this.reloadCode = reloadCode;
	}

	public Integer getSpecialOperationTypeSalePrice() {
		return specialOperationTypeSalePrice;
	}

	public void setSpecialOperationTypeSalePrice(
			Integer specialOperationTypeSalePrice) {
		this.specialOperationTypeSalePrice = specialOperationTypeSalePrice;
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

	public Long getIncreaseRate() {
		return increaseRate;
	}

	public void setIncreaseRate(Long increaseRate) {
		this.increaseRate = increaseRate;
	}

	public Boolean getIsScanned() {
		return isScanned;
	}

	public void setIsScanned(Boolean isScanned) {
		this.isScanned = isScanned;
	}

	public String getSalesCode() {
		return salesCode;
	}

	public void setSalesCode(String salesCode) {
		this.salesCode = salesCode;
	}

	public SaleTransaction getSaleTransaction() {
		return saleTransaction;
	}

	public void setSaleTransaction(SaleTransaction saleTransaction) {
		this.saleTransaction = saleTransaction;
	}

	public Integer getAnnulationType() {
		return annulationType;
	}

	public void setAnnulationType(Integer annulationType) {
		this.annulationType = annulationType;
	}

	public String getOnlineSaleStatus() {
		return onlineSaleStatus;
	}

	public void setOnlineSaleStatus(String onlineSaleStatus) {
		this.onlineSaleStatus = onlineSaleStatus;
	}

	public String getBossTransactionNumber() {
		return bossTransactionNumber;
	}

	public void setBossTransactionNumber(String bossTransactionNumber) {
		this.bossTransactionNumber = bossTransactionNumber;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
