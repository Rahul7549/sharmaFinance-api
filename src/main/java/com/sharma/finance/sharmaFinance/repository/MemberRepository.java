package com.sharma.finance.sharmaFinance.repository;

//import java.lang.reflect.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sharma.finance.sharmaFinance.model.Member;


public interface MemberRepository extends JpaRepository<Member, Integer> {

}
