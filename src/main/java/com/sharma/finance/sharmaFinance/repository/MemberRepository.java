package com.sharma.finance.sharmaFinance.repository;

//import java.lang.reflect.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sharma.finance.sharmaFinance.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
