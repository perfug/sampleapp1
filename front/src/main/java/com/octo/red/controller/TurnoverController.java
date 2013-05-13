package com.octo.red.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.octo.red.newsql.model.TurnoverVo;
import com.octo.red.newsql.services.TurnoverService;

@Controller
public class TurnoverController {

	private static final Logger logger = LoggerFactory.getLogger(TurnoverController.class);
	
	@Autowired
	private TurnoverService turnoverService;
	
	@RequestMapping(value = "/turnover", method = RequestMethod.GET)
	public @ResponseBody List<TurnoverVo> getTurnover(@RequestParam("groupId") int groupId) {
		
		logger.info("Request received [groupId={}] on /turnover", groupId);
		
		List<TurnoverVo> result = turnoverService.computeTurnover(groupId);
		return result;
	}
	
}
