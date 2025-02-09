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

import com.sharma.finance.sharmaFinance.model.LoanPayment;
import com.sharma.finance.sharmaFinance.model.Member;
import com.sharma.finance.sharmaFinance.service.LoanPaymentService;
import com.sharma.finance.sharmaFinance.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/members")
	public ResponseEntity<?> findAllMember(){
		return memberService.findAlMember();
	}
	
	@GetMapping("/members/{memberId}")
	public ResponseEntity<?> findMemberById(@PathVariable Long memberId){
		return memberService.findMemberById(memberId);
	}
	
	@PostMapping("/members")
	public ResponseEntity<?> createNewMember(@RequestBody Member newMember){
		return memberService.createNewMember(newMember);
	}
	
	@PutMapping("members/{memberId}")
	public ResponseEntity<?> updateMember(@PathVariable Long memberId, @RequestBody Member newMember){
		return memberService.updateMemeber(memberId, newMember);
	}
	
	@DeleteMapping("/members/{memberId}")
	public ResponseEntity<?> deleteMemberById(@PathVariable Long memberId){
		return memberService.deleteMemberById(memberId);
	}
}
