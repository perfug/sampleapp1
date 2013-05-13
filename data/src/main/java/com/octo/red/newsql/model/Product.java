package com.octo.red.newsql.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Integer groupId;
	private String productLabel;
	private Integer productMarginType;
	private BigDecimal commission;
	private BigDecimal marginCoefficient;
	private Long margin;
	private Boolean isSellable;
	private Boolean canPutBack;
	private Boolean isOnlineProduct;
	private Boolean isGenericProdct;
	private Integer ranking;
	private Date deletionDate;
	@ManyToOne
	private CategoryFamily categoryFamily;
	private Boolean isFollowInStock;
	private BigDecimal sellPrice;
	private Boolean updatablePrice;
	private Date modificationDate;
	private Boolean isReference;
	private Integer productType;
	private Boolean manualVat;
	private Boolean manualMarginType;
	private Boolean manualMargin;
	private Integer deliveredQuantity;
	private Boolean isProductionMonitoringManual;
	private Long buyPrice;
	private Long previousBuyPrice;
	private Boolean isActive;
	private String eanCode;
	@OneToOne
	private Product parentProduct;
	@OneToMany(mappedBy = "parentProduct")
	private Set<Product> childProducts;

	public Long getId() {
		return id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupeId) {
		this.groupId = groupeId;
	}

	public String getProductLabel() {
		return productLabel;
	}

	public void setProductLabel(String productLabel) {
		this.productLabel = productLabel;
	}

	public Integer getProductMarginType() {
		return productMarginType;
	}

	public void setProductMarginType(Integer productMarginType) {
		this.productMarginType = productMarginType;
	}

	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
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

	public Boolean getIsSellable() {
		return isSellable;
	}

	public void setIsSellable(Boolean isSellable) {
		this.isSellable = isSellable;
	}

	public Boolean getCanPutBack() {
		return canPutBack;
	}

	public void setCanPutBack(Boolean canPutBack) {
		this.canPutBack = canPutBack;
	}

	public Boolean getIsOnlineProduct() {
		return isOnlineProduct;
	}

	public void setIsOnlineProduct(Boolean isOnlineProduct) {
		this.isOnlineProduct = isOnlineProduct;
	}

	public Boolean getIsGenericProdct() {
		return isGenericProdct;
	}

	public void setIsGenericProdct(Boolean isGenericProdct) {
		this.isGenericProdct = isGenericProdct;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public Date getDeletionDate() {
		return deletionDate;
	}

	public void setDeletionDate(Date deletionDate) {
		this.deletionDate = deletionDate;
	}

	public CategoryFamily getCategoryFamily() {
		return categoryFamily;
	}

	public void setCategoryFamily(CategoryFamily categoryFamily) {
		this.categoryFamily = categoryFamily;
	}

	public Boolean getIsFollowInStock() {
		return isFollowInStock;
	}

	public void setIsFollowInStock(Boolean isFollowInStock) {
		this.isFollowInStock = isFollowInStock;
	}

	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Boolean getUpdatablePrice() {
		return updatablePrice;
	}

	public void setUpdatablePrice(Boolean updatablePrice) {
		this.updatablePrice = updatablePrice;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Boolean getIsReference() {
		return isReference;
	}

	public void setIsReference(Boolean isReference) {
		this.isReference = isReference;
	}

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public Boolean getManualVat() {
		return manualVat;
	}

	public void setManualVat(Boolean manualVat) {
		this.manualVat = manualVat;
	}

	public Boolean getManualMarginType() {
		return manualMarginType;
	}

	public void setManualMarginType(Boolean manualMarginType) {
		this.manualMarginType = manualMarginType;
	}

	public Boolean getManualMargin() {
		return manualMargin;
	}

	public void setManualMargin(Boolean manualMargin) {
		this.manualMargin = manualMargin;
	}

	public Integer getDeliveredQuantity() {
		return deliveredQuantity;
	}

	public void setDeliveredQuantity(Integer deliveredQuantity) {
		this.deliveredQuantity = deliveredQuantity;
	}

	public Boolean getIsProductionMonitoringManual() {
		return isProductionMonitoringManual;
	}

	public void setIsProductionMonitoringManual(
			Boolean isProductionMonitoringManual) {
		this.isProductionMonitoringManual = isProductionMonitoringManual;
	}

	public Long getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Long buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Long getPreviousBuyPrice() {
		return previousBuyPrice;
	}

	public void setPreviousBuyPrice(Long previousBuyPrice) {
		this.previousBuyPrice = previousBuyPrice;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getEanCode() {
		return eanCode;
	}

	public void setEanCode(String eanCode) {
		this.eanCode = eanCode;
	}
	
	/**
	 * No setter for parentProduct, use addParentProduct() instead
	 * @return
	 */
	public Product getParentProduct() {
		return parentProduct;
	}

	public Set<Product> getChildProducts() {
		return childProducts;
	}

	public void setChildProducts(Set<Product> childProducts) {
		this.childProducts = childProducts;
	}
	
	public void addChildProduct(Product childProduct) {
		if(childProduct == null)
			return;
		
		childProduct.parentProduct = this;
		this.childProducts.add(childProduct);
	}
}
