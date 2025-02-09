package com.sharma.finance.sharmaFinance.service;

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
import com.sharma.finance.sharmaFinance.model.Member;
import com.sharma.finance.sharmaFinance.repository.MemberRepository;

@Service
public class MemberService {
	
	private static List<Member> members = new ArrayList<>();
	private static final Logger logger = LoggerFactory.getLogger(LoanPaymentService.class);

//    static {
//        members.add(new Member(1, "Bello", "bello@example.com", /*101*/ "Active"));
//        members.add(new Member(2, "James", "james@example.com", /*102*/ "Inactive"));
//    }
	
	@Autowired
	MemberRepository memberRepository;
	
	public ResponseEntity<?> findAlMember(){
		try {
			List<Member> members=memberRepository.findAll();
			if(members.isEmpty()) {
				return ResponseEntity.ok(Collections.emptyList());
			}
			return ResponseEntity.ok(members);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("error", "An unexpected error occurred while fetching members."));
		}
	}
	
	
	public ResponseEntity<?> findMemberById(Long memberId){
		try {
			return memberRepository.findById(memberId)
					.map(ResponseEntity::ok)
					.orElseGet(()->ResponseEntity.notFound().build());
			
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("Error","An unexpected error occured while fetching memeber."));
		}
	}
	
	
	public ResponseEntity<?> createNewMember(Member newMember){
		
		try {
			Member createdMember= memberRepository.save(newMember);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdMember);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				   .body(Map.of("Error","An unexpected error occured while saving the memeber."));
				
		}
		
	}
	
	
	@Transactional
	public ResponseEntity<?> updateMemeber(Long memberId, Member newMember){
		
		try {
			Member existingMember=memberRepository.findById(memberId)
					.orElseThrow(()-> new ResourceNotFoundException("Member not found with ID:"+memberId));
			
			existingMember.setContactInfo(newMember.getContactInfo());
			existingMember.setName(newMember.getName());
			existingMember.setStatus(newMember.getStatus());
			
			Member updatedMember= memberRepository.save(existingMember);
			
			return ResponseEntity.ok(updatedMember);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("Error", "An unexpected error occured while updating member"));
		}
	}
	
	
	@Transactional
	public ResponseEntity<?> deleteMemberById(Long memberId){
		
		try {
			Member existingMember =memberRepository.findById(memberId)
					.orElseThrow(()-> new ResourceNotFoundException("Member does not exist with ID:"+memberId));
			
			memberRepository.delete(existingMember);
			logger.info("Member deleted successfully with ID ",+memberId);
			return ResponseEntity.ok("Member deleted successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("Error", "An unexpected error occured while updating member"));

		}
		
	}

}
