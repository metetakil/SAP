package com.mtakil.sap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mtakil.sap.entity.Aday;
import com.mtakil.sap.repo.AdayRepository;


@RestController
public class AdayController {

	private static final Logger logger = LoggerFactory.getLogger(AdayController.class);
	
	@Autowired
	private AdayRepository adayRepository;
	
	@GetMapping("/sap/aday")
	public Aday getAday(@RequestParam(value="tcno", required = true) String tcno) {
		logger.info("Received getAday request for " + tcno);
		Aday aday = adayRepository.findByTcno(tcno);
		
		return aday;
	}
	
}