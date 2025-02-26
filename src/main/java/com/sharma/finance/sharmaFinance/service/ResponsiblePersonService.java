package com.sharma.finance.sharmaFinance.service;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharma.finance.sharmaFinance.exception.ResourceNotFoundException;
import com.sharma.finance.sharmaFinance.model.Payment;
import com.sharma.finance.sharmaFinance.model.ResponsiblePerson;
import com.sharma.finance.sharmaFinance.repository.ResponsiblePersonRepository;

@Service
public class ResponsiblePersonService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoanPaymentService.class);
	private static List<ResponsiblePerson> responsiblePersons = new ArrayList<>();
    static {
        responsiblePersons.add(new ResponsiblePerson(101, "Alice", "alice@example.com"));
        responsiblePersons.add(new ResponsiblePerson(102, "Bob", "bob@example.com"));
    }
	
	@Autowired
	ResponsiblePersonRepository responsiblePersonRepository;
	
	public ResponseEntity<?> findAllResponsiblePersons(){
		try {
			List<ResponsiblePerson> responsiblePersons=responsiblePersonRepository.findAll();
			if(responsiblePersons.isEmpty()) {
				return ResponseEntity.ok(Collections.emptyList());
			}
			return ResponseEntity.ok(responsiblePersons);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("Error","An unexpected error occured while fetching all Responsible person."));
		}
		
		//return responsiblePersons;
	}
	
	public ResponseEntity<?> findResponsiblePersonById(long personaId) {
		try {
			return responsiblePersonRepository.findById(personaId)
					.map(ResponseEntity::ok)
					.orElseGet(()-> ResponseEntity.notFound().build());
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("Error","An unexpected error occured while fetching all Responsible person."));

		}
	}
	
	
	public ResponseEntity<?> createResponsiblePerson(ResponsiblePerson newResponsiblePerson){
		try {
			logger.info("person ",newResponsiblePerson);
			ResponsiblePerson responsiblePerson=responsiblePersonRepository.save(newResponsiblePerson);
			return ResponseEntity.status(HttpStatus.CREATED).body(responsiblePerson);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("Error","An unexpected error occured while creating new Responsible Person."));

		}
	}
	
	public ResponseEntity<?> updateResponsiblePersion(Long personId, ResponsiblePerson newResponsiblePerson){
		try {
			ResponsiblePerson existingPerson=responsiblePersonRepository.findById(personId)
					.orElseThrow(()-> new ResourceNotFoundException("Responsible Person does not exist with ID:"+personId));
		    existingPerson.setContactInfo(newResponsiblePerson.getContactInfo());
		    existingPerson.setName(newResponsiblePerson.getName());
		    ResponsiblePerson updatedPerson= responsiblePersonRepository.save(existingPerson);
			return ResponseEntity.ok(updatedPerson);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("Error","An unexpected error occured while updating Responsible person."));

		}
	}
	
	@Transactional
    public ResponseEntity<?> deleteResponsiblePersionById(Long personId){
    	try {
    		ResponsiblePerson person =responsiblePersonRepository.findById(personId)
        			.orElseThrow(()-> new ResourceNotFoundException("Responsible does not exist with ID:"+personId));
    		responsiblePersonRepository.delete(person);
        	
        	return ResponseEntity.ok("Responsible deleted sucessfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("Error","An unexpected error occured while fetching all payments."));

		}
    }

	
	

}
