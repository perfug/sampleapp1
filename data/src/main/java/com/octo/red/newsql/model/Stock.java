package com.octo.red.newsql.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Integer groupId;
	private Integer stockType;
	private Integer quantity;
	private Boolean isKeptAfterCallback;
	@OneToOne
	private Product product;
	private Date modificationDate;
	@ManyToOne
	private Store store;

	public Long getId() {
		return id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupeId) {
		this.groupId = groupeId;
	}

	public Integer getStockType() {
		return stockType;
	}

	public void setStockType(Integer stockType) {
		this.stockType = stockType;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getIsKeptAfterCallback() {
		return isKeptAfterCallback;
	}

	public void setIsKeptAfterCallback(Boolean isKeptAfterCallback) {
		this.isKeptAfterCallback = isKeptAfterCallback;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Store getStore() {
		return store;
	}

	void setStore(Store store) {
		this.store = store;
	}

}
