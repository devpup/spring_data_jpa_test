package com.example.jpatest.service;

import com.example.jpatest.data.persistence.entity.Member;

import java.util.List;

public interface JpaService {
    List<Member> getMemberList();
}
