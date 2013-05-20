package com.octo.red.newsql.services;

import com.octo.red.newsql.dao.*;
import com.octo.red.newsql.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Service
public class TransactionService {
	private static final String EUR = "EUR";
	@Autowired
	VatRepository vatRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	SaleTransactionRepository saleTransactionRepository;
	@Autowired
	SaleOperationRepository saleOperationRepository;
	@Autowired
	StockRepository stockRepository;
	@Autowired
	CurrencyConverter currencyConverter;
	
	@Transactional
	public SaleOperation buy(String countryCode, long productId, long storeId, Long txId) {
		if(countryCode == null || countryCode.length()== 0) {
			throw new IllegalArgumentException("countryCode must not be null");
		}
		
		Product p = productRepository.findOne(productId);
		VAT v = vatRepository.findOneByCountryCodeAndProductId(countryCode.toUpperCase(), productId);
		//If no VAT is defined for this product, use the VAT for the product category it belongs to
		if(v == null) {
		}
		
		if(p == null || v == null) {
			throw new SystemException(String.format("Product %s or VAT %s not found, check database", productId, countryCode));
		}
		
		//Compute Price in Euro
		BigDecimal eurPrice = v.getVatRate().add(BigDecimal.ONE).multiply(p.getSellPrice());
		//Price in the catalog are in EUR, convert according to the country
		String operationCurrency = currencyConverter.getCurrency(countryCode);
		BigDecimal price = currencyConverter.convert(eurPrice, EUR, operationCurrency);
		//Update corresponding transaction
		SaleTransaction saleTransaction = null;
		if(txId != null) {
			saleTransaction = saleTransactionRepository.findOne(txId);
			if(saleTransaction == null) {
				throw new SystemException("No transaction found for id " + txId);
			}
		} else {
			saleTransaction = new SaleTransaction();
			saleTransaction.setCancellation(null);
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
			saleTransaction.setDiscountRate(0L);
			saleTransaction.setGroupId(1);
			saleTransaction.setStartDate(new Date());
			saleTransaction.setTicketNumber(1);
			saleTransaction.setTotalAmount(BigDecimal.ZERO);
			saleTransaction.setTransactionKey("transactionKey");
		}
		
		saleTransaction.setTotalAmount(saleTransaction.getTotalAmount().add(eurPrice));
		saleTransactionRepository.save(saleTransaction);
		
		//Register the SaleOperation and link it to the transaction
		SaleOperation saleOperation = new SaleOperation();
		saleOperation.setAmount(price);
		saleOperation.setCurrency(operationCurrency);
		Calendar annulationDateCal = Calendar.getInstance();
		saleOperation.setAnnulation(annulationDateCal.getTime());
		saleOperation.setAnnulationCashierName("annulationCashierName");
		saleOperation.setAnnulationCashierNumber(1);
		saleOperation.setAnnulationType(1);
		saleOperation.setBossTransactionNumber("bossTransactionNumber");
		saleOperation.setBusinessCategory(1);
		saleOperation.setCashierName("cashierName");
		saleOperation.setCashierNumber(1);
		Calendar calendar = Calendar.getInstance();
		saleOperation.setDate(calendar.getTime());
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
		saleOperation.setSaleTransaction(saleTransaction);
		saleOperationRepository.save(saleOperation);
		
		//Update the stock of the corresponding store
		final Stock stock  = stockRepository.findOneByStoreAndProductId(storeId, productId);
		if(stock == null) {
			throw new SystemException(String.format("No stock found for storeId {0} and productId {1}", storeId, productId));
		}
		stock.setQuantity(stock.getQuantity() - saleOperation.getQuantity());
		return saleOperation;
		
	}

	public TotalVo computeTotal(long txId) {
		SaleTransaction saleTransaction = saleTransactionRepository.findOne(txId);
		if(saleTransaction == null) {
			throw new SystemException("No transaction found for id " + txId);
		}
		//Transaction amount is computed in Euros
		return new TotalVo(saleTransaction.getTotalAmount(), EUR);
	}
}
