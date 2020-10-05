package com.example.jpatest.data.persistence.repository;

import com.example.jpatest.data.persistence.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

//https://jojoldu.tistory.com/372


public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
}
