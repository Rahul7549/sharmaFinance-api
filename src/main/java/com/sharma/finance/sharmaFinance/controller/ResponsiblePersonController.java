package com.sharma.finance.sharmaFinance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharma.finance.sharmaFinance.model.ResponsiblePerson;
import com.sharma.finance.sharmaFinance.service.ResponsiblePersonService;

@RestController
public class ResponsiblePersonController {
	
	@Autowired
	ResponsiblePersonService responsiblePersonService;
	
	@GetMapping("/responsible-Persons")
	public List<ResponsiblePerson> findResponsiblePersons(){
		return responsiblePersonService.findAllResponsiblePersons();
	}
}
