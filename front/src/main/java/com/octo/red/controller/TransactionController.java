package com.octo.red.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.octo.red.newsql.model.SaleOperation;
import com.octo.red.newsql.model.TotalVo;
import com.octo.red.newsql.services.TransactionService;

@Controller
public class TransactionController {

	private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
	
	@Autowired
	TransactionService service;
	
	@RequestMapping(value = "/transaction", method = RequestMethod.GET)
	public @ResponseBody Model getTransaction(
			@RequestParam("countryCode") String countryCode,
			@RequestParam("productId") Long productId, 
			@RequestParam("storeId") Long storeId, 
			@RequestParam(value="txId", required=false) Long txId, //Don't use a native type, it can be null 
			Model model) {
		
		logger.info("Request received [countryCode={}, productId={}, storeId={}, txId={}] on /transaction", 
				new Object[]{countryCode, productId, storeId, txId});
		
		if(productId == null) {
			throw new IllegalArgumentException("productId must not be null");
		}
		if(storeId == null) {
			throw new IllegalArgumentException("storeId must not be null");
		}
		
		SaleOperation saleOperation = service.buy(countryCode, productId, storeId, txId);
		
		model.addAttribute("txId", saleOperation.getSaleTransaction().getId());
		model.addAttribute("amount", saleOperation.getAmount().toPlainString());
		model.addAttribute("currency", saleOperation.getCurrency());
		
		return model;
	}
	
	@RequestMapping(value = "/total", method = RequestMethod.GET)
	public @ResponseBody Model getTotal(@RequestParam("txId") Long txId, Model model) {
		logger.info("Request received [txId={}] on /total", new Object[]{txId});

		if(txId == null) {
			throw new IllegalArgumentException("txId must not be null");
		}
		TotalVo totalVo = service.computeTotal(txId);
		model.addAttribute("amount", totalVo.getAmount().toPlainString());
		model.addAttribute("currency", totalVo.getCurrency());
		
		return model;
	}
	
}
