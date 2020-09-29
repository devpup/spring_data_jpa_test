package com.example.jpatest.data.persistence.repository;

import com.example.jpatest.data.persistence.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
