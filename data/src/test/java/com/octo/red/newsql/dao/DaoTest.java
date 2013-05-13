package com.octo.red.newsql.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.unitils.reflectionassert.ReflectionAssert;

import com.octo.red.newsql.model.CategoryFamily;
import com.octo.red.newsql.model.Country;
import com.octo.red.newsql.model.Product;
import com.octo.red.newsql.model.SaleOperation;
import com.octo.red.newsql.model.SampleFactory;
import com.octo.red.newsql.model.Stock;
import com.octo.red.newsql.model.Store;
import com.octo.red.newsql.model.VAT;

@ContextConfiguration("classpath:com/octo/rnd/PersistenceTests-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DaoTest {

	@Autowired
	VatRepository vatRepository;
	@Autowired
	StockRepository stockRepository;
	@Autowired
	SaleOperationRepository saleOperationRepository;
	@PersistenceContext
	EntityManager entityManager;
	
	@Test
	@Transactional
	public void testFindVatByCountryCode() {
		//Given
		final Country c = SampleFactory.buildCountry();
		final String countryCode = "FRA";
		c.setAlpha3Code(countryCode);
		entityManager.persist(c);
		final VAT v = SampleFactory.buildVAT();
		//Set custom value
		v.setVatRate(new BigDecimal("0.206"));
		c.addVat(v);
		entityManager.persist(v);
		CategoryFamily cf = SampleFactory.buildCategoryFamily();
		cf.addVat(v);
		entityManager.persist(cf);
		final Product p  = SampleFactory.buildProduct();
		p.setCategoryFamily(cf);
		entityManager.persist(p);
		final long productId = p.getId();
		entityManager.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		entityManager.clear();
		//When
		VAT rtvVat = vatRepository.findOneByCountryCodeAndProductId(countryCode, productId);
		//Then
		ReflectionAssert.assertLenientEquals(v, rtvVat);
		
	}
	
	@Test
	@Transactional
	public void testFindStockByCountryCodeAndProductId() {
		//Given
		final Product p = SampleFactory.buildProduct();
		entityManager.persist(p);
		final Store s = SampleFactory.buildStore();
		entityManager.persist(s);
		final Stock stock = SampleFactory.buildStock();
		stock.setProduct(p);
		s.addStock(stock);
		entityManager.persist(stock);
		final long productId= p.getId();
		final long storeId = s.getId();
		entityManager.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		entityManager.clear();
		//When
		Stock rtvStock = stockRepository.findOneByStoreAndProductId(storeId, productId);
		ReflectionAssert.assertLenientEquals(stock, rtvStock);
	}
	
	
	@Test
	@Transactional
	public void testAggregateDailyAmount() {
		//Given
		final int groupId = 1;
		final SaleOperation[] saleOperationSamples = SampleFactory.buildSaleOperationsSet();
		entityManager.persist(saleOperationSamples[0]);
		entityManager.persist(saleOperationSamples[1]);
		entityManager.persist(saleOperationSamples[2]);
		entityManager.persist(saleOperationSamples[3]);
		entityManager.persist(saleOperationSamples[4]);
		entityManager.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		entityManager.clear();
		//When
		List<Object[]> res = saleOperationRepository.aggregateAmount(groupId, SampleFactory.buildDate(2011, 1, 1));
		//Then
		Assert.assertNotNull(res);
		Assert.assertEquals(2, res.size());
		Object[] l0 = res.get(0);
		Assert.assertEquals(0, new BigDecimal("102.2").compareTo((BigDecimal)l0[0]));
		Assert.assertEquals("EUR", l0[1]);
		Object[] l1 = res.get(1);
		Assert.assertEquals(0, new BigDecimal("3.3").compareTo((BigDecimal)l1[0]));
		Assert.assertEquals("USD", l1[1]);
	}

}
