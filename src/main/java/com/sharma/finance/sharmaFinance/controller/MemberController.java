package com.sharma.finance.sharmaFinance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharma.finance.sharmaFinance.model.LoanPayment;
import com.sharma.finance.sharmaFinance.model.Member;
import com.sharma.finance.sharmaFinance.service.LoanPaymentService;
import com.sharma.finance.sharmaFinance.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/member")
	public List<Member> findAllMember(){
		return memberService.findAlMember();
	}
}
