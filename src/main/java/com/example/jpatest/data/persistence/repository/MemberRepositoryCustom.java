package com.example.jpatest.data.persistence.repository;

import com.example.jpatest.data.persistence.entity.Member;

import java.util.List;

//2번 방법 Custom와 Impl를 이용

public interface MemberRepositoryCustom {
    List<Member> findByName(String name);
}
