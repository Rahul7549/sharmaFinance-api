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

	@Autowired
	MemberRepository memberRepository;

	public ResponseEntity<?> findAlMember() {
		
			List<Member> members = memberRepository.findAll();
			if (members.isEmpty()) {
				return ResponseEntity.ok(Collections.emptyList());
			}
			return ResponseEntity.ok(members);
		
	}

	public ResponseEntity<?> findMemberById(Long memberId) {
		
			return memberRepository.findById(memberId).map(ResponseEntity::ok)
					.orElseThrow(() -> new ResourceNotFoundException("Member doesn't exist with ID"+memberId));

		
	}

	public ResponseEntity<?> createNewMember(Member newMember) {

		
			Member createdMember = memberRepository.save(newMember);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(createdMember);
		

	}

	@Transactional
	public ResponseEntity<?> updateMemeber(Long memberId, Member newMember) {

		
			Member existingMember = memberRepository.findById(memberId)
					.orElseThrow(() -> new ResourceNotFoundException("Member not found with ID:" + memberId));

			existingMember.setContactInfo(newMember.getContactInfo());
			existingMember.setName(newMember.getName());
			existingMember.setStatus(newMember.getStatus());

			Member updatedMember = memberRepository.save(existingMember);

			return ResponseEntity.ok(updatedMember);

		
	}

	@Transactional
	public ResponseEntity<?> deleteMemberById(Long memberId) {

		
			Member existingMember = memberRepository.findById(memberId)
					.orElseThrow(() -> new ResourceNotFoundException("Member does not exist with ID:" + memberId));

			memberRepository.delete(existingMember);
			logger.info("Member deleted successfully with ID ", +memberId);
			return ResponseEntity.ok("Member deleted successfully");
		

	}

}
