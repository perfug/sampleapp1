package com.octo.red.newsql.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.octo.red.newsql.dao.StockRepository;
import com.octo.red.newsql.model.InventoryRecord;

@Service
public class InventoryService {

	@PersistenceContext
	EntityManager entityManager;
	@Autowired
	StockRepository stockRepository;
	
	public List<InventoryRecord> list(long storeId) {
		List<InventoryRecord> result = new ArrayList<InventoryRecord>();
		List<Object[]> lines = stockRepository.getAllProductsByStoreId(storeId);
		if(lines != null) {
			for(Object[] l : lines) {
				result.add(new InventoryRecord((String) l[0], (Integer) l[1], (String) l[2], (Integer) l[3]));
			}
		}
		return result;
	}
}