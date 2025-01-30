package com.sharma.finance.sharmaFinance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharma.finance.sharmaFinance.model.ResponsiblePerson;

@Service
public class ResponsiblePersonService {
	
	private static List<ResponsiblePerson> responsiblePersons = new ArrayList<>();
    static {
        responsiblePersons.add(new ResponsiblePerson(101, "Alice", "alice@example.com"));
        responsiblePersons.add(new ResponsiblePerson(102, "Bob", "bob@example.com"));
    }
	
	

}
