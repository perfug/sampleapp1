package com.octo.red.newsql.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.octo.red.newsql.model.SaleOperation;

public interface SaleOperationRepository  extends CrudRepository<SaleOperation, Long>, JpaSpecificationExecutor<SaleOperation> {

	@Query("select SUM(op.amount), op.currency from SaleOperation op where op.groupId=:groupId and op.date >= :date group by op.currency order by SUM(op.amount) desc")
	public List<Object[]> aggregateAmount(@Param("groupId") int groupId, @Param("date") Date date); 
}
