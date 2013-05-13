package com.octo.red.newsql.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.unitils.reflectionassert.ReflectionAssert;

import com.octo.red.newsql.model.CategoryFamily;
import com.octo.red.newsql.model.Country;
import com.octo.red.newsql.model.Product;
import com.octo.red.newsql.model.SaleOperation;
import com.octo.red.newsql.model.SaleTransaction;
import com.octo.red.newsql.model.Stock;
import com.octo.red.newsql.model.Store;
import com.octo.red.newsql.model.VAT;

@ContextConfiguration("classpath:com/octo/rnd/PersistenceTests-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PersistenceTest {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Test
	@Transactional
	public void testSaveAndGetCategoryFamily() throws Exception {
		
		CategoryFamily categoryFamily = SampleFactory.buildCategoryFamily();
		VAT vat = SampleFactory.buildVAT();
		entityManager.persist(vat);
		categoryFamily.addVat(vat);
		entityManager.persist(categoryFamily);
		entityManager.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		entityManager.clear();
		CategoryFamily rtvCategoryFamily = (CategoryFamily)entityManager.find(CategoryFamily.class, categoryFamily.getId());
		ReflectionAssert.assertLenientEquals(categoryFamily, rtvCategoryFamily);	
	}
	
	@Test
	@Transactional
	public void testSaveAndGetCountry() throws Exception {
		
		Country country = SampleFactory.buildCountry();
		entityManager.persist(country);
		VAT vat = SampleFactory.buildVAT();
		entityManager.persist(vat);
		country.addVat(vat);
		entityManager.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		entityManager.clear();
		Country rtvCountry = (Country)entityManager.find(Country.class, country.getAlpha3Code());
		ReflectionAssert.assertLenientEquals(country, rtvCountry);	
	}
	
	@Test
	@Transactional
	public void testSaveAndGetProduct() throws Exception {
		
		Product product = SampleFactory.buildProduct("product1");
		Product parentProduct = SampleFactory.buildProduct("productParent");
		Product childProduct1 = SampleFactory.buildProduct("productChild1");
		Product childProduct2 = SampleFactory.buildProduct("productChild2");
		CategoryFamily categoryFamily = SampleFactory.buildCategoryFamily();
		entityManager.persist(parentProduct);
		entityManager.persist(childProduct1);
		entityManager.persist(childProduct2);
		entityManager.persist(categoryFamily);
		parentProduct.addChildProduct(product);
		product.setCategoryFamily(categoryFamily);
		product.addChildProduct(childProduct1);
		product.addChildProduct(childProduct2);
		entityManager.persist(product);
		entityManager.persist(parentProduct); //Again, child products list modified
		entityManager.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		entityManager.clear();
		Product rtvProduct = (Product)entityManager.find(Product.class, product.getId());
		ReflectionAssert.assertLenientEquals(product, rtvProduct);	
	}
	
	@Test
	@Transactional
	public void testSaveAndGetSaleOperation() throws Exception {
		
		SaleOperation saleOperation = SampleFactory.buildSaleOperation();
		SaleTransaction saleTransaction = SampleFactory.buildSaleTransaction();
		Product product = SampleFactory.buildProduct();
		entityManager.persist(saleTransaction);
		entityManager.persist(product);
		saleOperation.setSaleTransaction(saleTransaction);
		saleOperation.setProduct(product);
		entityManager.persist(saleOperation);
		
		entityManager.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		entityManager.clear();
		SaleOperation rtvSaleOperation = (SaleOperation)entityManager.find(SaleOperation.class, saleOperation.getId());
		ReflectionAssert.assertLenientEquals(saleOperation, rtvSaleOperation);	
	}
	
	@Test
	@Transactional
	public void testSaveAndGetSaleTransaction() throws Exception {
		
		SaleTransaction saleTransaction = SampleFactory.buildSaleTransaction();
		entityManager.persist(saleTransaction);
		entityManager.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		entityManager.clear();
		SaleTransaction rtvSaleTransaction = (SaleTransaction)entityManager.find(SaleTransaction.class, saleTransaction.getId());
		ReflectionAssert.assertLenientEquals(saleTransaction, rtvSaleTransaction);	
	}
	
	@Test
	@Transactional
	public void testSaveAndGetStock() throws Exception {
		
		Stock stock = SampleFactory.buildStock();
		Product product = SampleFactory.buildProduct();
		entityManager.persist(product);
		Store store = SampleFactory.buildStore();
		entityManager.persist(store);
		store.addStock(stock);
		stock.setProduct(product);
		entityManager.persist(stock);
		entityManager.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		entityManager.clear();
		Stock rtvStock = (Stock)entityManager.find(Stock.class, stock.getId());
		ReflectionAssert.assertLenientEquals(stock, rtvStock);	
	}

	@Test
	@Transactional
	public void testSaveAndGetStore() throws Exception {
		
		Store store = SampleFactory.buildStore();
		Stock stock = SampleFactory.buildStock();
		entityManager.persist(stock);
		store.addStock(stock);
		entityManager.persist(store);
		entityManager.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		entityManager.clear();
		Store rtvStore = (Store)entityManager.find(Store.class, store.getId());
		ReflectionAssert.assertLenientEquals(store, rtvStore);	
	}
	
	@Test
	@Transactional
	public void testSaveAndGetVat() throws Exception {
		
		VAT vat = SampleFactory.buildVAT();
		Country country = SampleFactory.buildCountry();
		entityManager.persist(country);
		country.addVat(vat);
		entityManager.persist(vat);
		entityManager.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		entityManager.clear();
		VAT rtvVat = (VAT)entityManager.find(VAT.class, vat.getId());
		ReflectionAssert.assertLenientEquals(vat, rtvVat);	
	}
}
