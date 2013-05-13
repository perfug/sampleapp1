package com.octo.red.newsql.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import com.octo.red.newsql.model.CategoryFamily;
import com.octo.red.newsql.model.Country;
import com.octo.red.newsql.model.Product;
import com.octo.red.newsql.model.SaleOperation;
import com.octo.red.newsql.model.SaleTransaction;
import com.octo.red.newsql.model.Stock;
import com.octo.red.newsql.model.Store;
import com.octo.red.newsql.model.VAT;

/**
 * Build sample domain objects without any relations. 
 * Fields that refrence an domain objects remain null
 * Fields that reference a collection of domain object remain empty lists
 * @author mbo
 *
 */
public final class SampleFactory {
	

	public static Date buildDate(int year, int month, int date) {
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(year, month-1, date);
		return c.getTime();
	}
	
	public static CategoryFamily buildCategoryFamily() {
		CategoryFamily categoryFamily = new CategoryFamily();
		categoryFamily.setCommissionRate(new BigDecimal("0.1"));
		categoryFamily.setDeletionDate(SampleFactory.buildDate(2012, 01, 01));
		categoryFamily.setFamilyPressType(1);
		categoryFamily.setFamilyType("familyType");
		categoryFamily.setGroupid(1);
		categoryFamily.setIsDeletable(false);
		categoryFamily.setIsDiscountable(false);
		categoryFamily.setIsTracked(false);
		categoryFamily.setLabel("label");
		categoryFamily.setMargin(10L);
		categoryFamily.setMarginCoefficient(new BigDecimal("0.1"));
		categoryFamily.setMaximumAuthorisedAmount(10L);
		categoryFamily.setMinimumAuthorisedAmount(1L);
		categoryFamily.setModificationDate(SampleFactory.buildDate(2012, 01, 01));
		categoryFamily.setProductType(1);
		
		return categoryFamily;
	}
	
	public static Country buildCountry() {
		Country country = new Country("FRA", 250, "FRANCE", new HashSet<VAT>());
		return country;
	}
	
	public static Product buildProduct() {
		return buildProduct("productLabel");
	}
	
	public static Product buildProduct(String productLabel) {
		Product product = new Product();
		product.setBuyPrice(1L);
		product.setCanPutBack(false);
		product.setCategoryFamily(null);
		product.setChildProducts(new HashSet<Product>());
		product.setCommission(new BigDecimal(1));
		product.setDeletionDate(SampleFactory.buildDate(2012, 01, 01));
		product.setDeliveredQuantity(1);
		product.setEanCode("eanCode");
		product.setGroupId(1);
		product.setIsActive(false);
		product.setIsFollowInStock(false);
		product.setIsGenericProdct(false);
		product.setIsOnlineProduct(false);
		product.setIsProductionMonitoringManual(false);
		product.setIsReference(false);
		product.setIsSellable(false);
		product.setManualMargin(false);
		product.setManualMarginType(false);
		product.setManualVat(false);
		product.setMargin(1L);
		product.setMarginCoefficient(new BigDecimal(1));
		product.setModificationDate(SampleFactory.buildDate(2012, 01, 01));
		product.setPreviousBuyPrice(1L);
		product.setProductLabel(productLabel);
		product.setProductType(1);
		product.setRanking(1);
		product.setSellPrice(new BigDecimal(1));
		product.setUpdatablePrice(false);

		return product;
	}
	
	public static SaleOperation buildSaleOperation() {
		SaleOperation saleOperation = new SaleOperation();
		saleOperation.setAmount(new BigDecimal(10));
		saleOperation.setCurrency("EUR");
		saleOperation.setAnnulation(SampleFactory.buildDate(2012, 01, 01));
		saleOperation.setAnnulationCashierName("annulationCashierName");
		saleOperation.setAnnulationCashierNumber(1);
		saleOperation.setAnnulationType(1);
		saleOperation.setBossTransactionNumber("bossTransactionNumber");
		saleOperation.setBusinessCategory(1);
		saleOperation.setCashierName("cashierName");
		saleOperation.setCashierNumber(1);
		saleOperation.setDate(SampleFactory.buildDate(2012, 01, 01));
		saleOperation.setDiscountAmount("discountAmount");
		saleOperation.setDiscountRate(1L);
		saleOperation.setGroupId(1);
		saleOperation.setIncreaseRate(1L);
		saleOperation.setIsBackToStock(false);
		saleOperation.setIsReturn(false);
		saleOperation.setIsScanned(false);
		saleOperation.setOnlineSaleStatus("onlineSaleStatus");
		saleOperation.setProductLabel("productLabel");
		saleOperation.setQuantity(1);
		saleOperation.setReloadCode("reloadCode");
		saleOperation.setSalesCode("salesCode");
		saleOperation.setSaleTransaction(null);
		saleOperation.setSpecialOperationTypeSalePrice(1);
		saleOperation.setSupplierProductReference("supplierProductReference");
		return saleOperation;
	}
	
	public static SaleTransaction buildSaleTransaction() {
		SaleTransaction saleTransaction = new SaleTransaction();
		saleTransaction.setCancellation(SampleFactory.buildDate(2012, 01, 01));
		saleTransaction.setCancellationClerkName("cancellationClerkName");
		saleTransaction.setCancellationClerkNumber(1);
		saleTransaction.setCancellationTicketNumber(1);
		saleTransaction.setCancellationType(1);
		saleTransaction.setChangeAmount("changeAmount");
		saleTransaction.setClerkName("clerkName");
		saleTransaction.setClerkNumber(1);
		saleTransaction.setClientName("clientName");
		saleTransaction.setClientNumber(1);
		saleTransaction.setDiscountAmount("discountAmount");
		saleTransaction.setDiscountRate(1L);
		saleTransaction.setGroupId(1);
		saleTransaction.setStartDate(SampleFactory.buildDate(2012, 01, 01));
		saleTransaction.setTicketNumber(1);
		saleTransaction.setTotalAmount(new BigDecimal(10));
		saleTransaction.setTransactionKey("transactionKey");
		return saleTransaction;
	}
	
	public static Stock buildStock() {
		Stock stock = new Stock();
		stock.setGroupId(1);
		stock.setIsKeptAfterCallback(false);
		stock.setModificationDate(SampleFactory.buildDate(2012, 01, 01));
		stock.setProduct(null);
		stock.setQuantity(1);
		stock.setStockType(1);
		return stock;
	}
	
	public static Store buildStore() {
		Store store = new Store();
		store.setApeCode("apeCode");
		store.setContactReference("contactReference");
		store.setDealerParametersReference("dealerParametersReference");
		store.setDistributorParametersReference("distributorParametersReference");
		store.setGeneralParametersReference("generalParametersReference");
		store.setGroupId(1);
		store.setLegalForm("legalForm");
		store.setMailServerReference("mailServerReference");
		store.setManagementCenter1Reference("managementCenter1Reference");
		store.setManagementCenter2Reference("managementCenter2Reference");
		store.setManagementCenterSuscriber("managementCenterSuscriber");
		store.setnVAT("nVAT");
		store.setRcs("rcs");
		store.setStoreName("storeName");
		store.setStoreReference("storeReference");
		return store;
	}
	
	
	public static VAT buildVAT() {
		VAT vat = new VAT();
		vat.setCountry(null);
		vat.setDeletionDate(SampleFactory.buildDate(2012, 01, 01));
		vat.setGroupId(1);
		vat.setIsDeletable(false);
		vat.setIsExempted(false);
		vat.setVatLabel("vatLabel");
		vat.setVatRate(new BigDecimal("0.1"));
		vat.setVatType(1);
		return vat;
	}

	/**
	 * Build a set of 5 SaleOperations with the given total amount for groupId 1 after 20111202 and before 20120101
	 * EUR;101.1
	 * USD;3.3
	 * (transactions occur on 20120101 and a another transaction accurs on 20111201)
	 * @return
	 */
	public static SaleOperation[] buildSaleOperationsSet() {
		final SaleOperation so1 = buildSaleOperation();
		so1.setGroupId(1);
		so1.setAmount(new BigDecimal("100"));
		so1.setCurrency("EUR");
		final SaleOperation so2 = buildSaleOperation();
		so2.setGroupId(1);
		so2.setAmount(new BigDecimal("1.1"));
		so2.setCurrency("EUR");
		final SaleOperation so3 = buildSaleOperation();
		so3.setGroupId(1);
		so3.setAmount(new BigDecimal("1.1"));
		so3.setCurrency("USD");
		final SaleOperation so4 = buildSaleOperation();
		so4.setGroupId(1);
		so4.setAmount(new BigDecimal("2.2"));
		so4.setCurrency("USD");
		final SaleOperation so5 = buildSaleOperation();
		so5.setGroupId(1);
		so5.setAmount(new BigDecimal("1.1"));
		so5.setCurrency("EUR");
		so5.setDate(SampleFactory.buildDate(2011, 12, 1));
		final SaleOperation[] saleOperationSamples = new SaleOperation[] { so1, so2, so3, so4, so5 };
		return saleOperationSamples;
	}
	
	
}
