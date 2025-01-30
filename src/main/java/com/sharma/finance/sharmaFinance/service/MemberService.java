package com.sharma.finance.sharmaFinance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharma.finance.sharmaFinance.model.Member;

@Service
public class MemberService {
	
	private static List<Member> members = new ArrayList<>();
    static {
        members.add(new Member(1, "Bello", "bello@example.com", /*101*/ "Active"));
        members.add(new Member(2, "James", "james@example.com", /*102*/ "Inactive"));
    }
	
	

}
