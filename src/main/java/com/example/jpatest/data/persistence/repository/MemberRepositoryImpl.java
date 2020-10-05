package com.example.jpatest.data.persistence.repository;

import com.example.jpatest.data.persistence.entity.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.jpatest.data.persistence.entity.QMember.member;


@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public List<Member> findByName(String name) {
        return queryFactory
                .selectFrom(member)
//                .join(member.team, team)
//                .fetchJoin()
                .where(member.name.eq(name))
                .fetch();
    }
}
