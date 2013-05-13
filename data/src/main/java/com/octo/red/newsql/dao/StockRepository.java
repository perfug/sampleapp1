package com.octo.red.newsql.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.octo.red.newsql.model.Stock;

public interface StockRepository extends CrudRepository<Stock, Long>, JpaSpecificationExecutor<Stock> {
	
	@Query("select s from Stock s where s.store.id = :storeId and s.product.id = :productId")
	public Stock findOneByStoreAndProductId(@Param("storeId") Long storeId, @Param("productId") Long productId);
	
	@Query("SELECT cat.label, cat.groupid, p.productLabel, stock.quantity FROM Stock stock INNER JOIN Stock.store as store INNER JOIN Stock.product as p INNER JOIN p.categoryFamily as cat WHERE store.id = :storeId")
	public List<Object []> getAllProductsByStoreId(@Param("storeId") Long storeId); 
}
