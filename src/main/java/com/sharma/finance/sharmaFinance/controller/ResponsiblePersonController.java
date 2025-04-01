package com.sharma.finance.sharmaFinance.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sharma.finance.sharmaFinance.model.ResponsiblePerson;
import com.sharma.finance.sharmaFinance.service.ResponsiblePersonService;

import io.swagger.v3.oas.models.responses.ApiResponse;

@RestController
public class ResponsiblePersonController {
	
	@Autowired
	ResponsiblePersonService responsiblePersonService;
	
	@GetMapping("/responsible-Persons")
	public ResponseEntity<?> findResponsiblePersons(){
		return responsiblePersonService.findAllResponsiblePersons();
	}
	
	@GetMapping("/responsible-Persons/{personId}")
	public ResponseEntity<?> findResponsiblePersonById( @PathVariable Long personId){
		return responsiblePersonService.findResponsiblePersonById(personId);
	}
	
	@PostMapping("/responsible-Persons")
	public ResponseEntity<?> createResponsiblePerson( @RequestBody ResponsiblePerson person){
		return responsiblePersonService.createResponsiblePerson(person);
	}
	//create the responsible person
//	{
//		"responsibleId": 0,
//			"name": "string",
//			"contactInfo": "string 123"
//	}
	@PutMapping("/responsible-Persons/{personid}")
	public ResponseEntity<?> updateResponsiblePersion(@PathVariable Long personid,  @RequestBody ResponsiblePerson person){
		return responsiblePersonService.updateResponsiblePersion(personid, person);
	}
	
	@DeleteMapping("/responsible-Persons/{personId}")
	public ResponseEntity<?> deleteResponsiblePersionById( @PathVariable Long personId){
		return responsiblePersonService.deleteResponsiblePersonById(personId);
        
	}
	
}
