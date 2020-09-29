package com.example.jpatest.service.impl;

import com.example.jpatest.data.persistence.entity.Member;
import com.example.jpatest.data.persistence.entity.MemberType;
import com.example.jpatest.data.persistence.repository.MemberRepository;
import com.example.jpatest.service.JpaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor
@Service("jpaService")
public class JpaServiceImpl implements JpaService {

    private final MemberRepository memberRepository;

    @PostConstruct
    private void init() {
        memberRepository.save(Member.builder()
                .name("memberA")
                .age(10)
                .memberType(MemberType.USER)
                .build()
        );

        memberRepository.save(Member.builder()
                .name("memberB")
                .age(20)
                .memberType(MemberType.USER)
                .build()
        );
    }

    @Override
    public List<Member> getMemberList() {
        return memberRepository.findAll();
    }
}
