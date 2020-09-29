package com.example.jpatest.data.persistence.repository;

import com.example.jpatest.data.persistence.entity.Member;
import com.example.jpatest.data.persistence.entity.QMember;
import com.example.jpatest.data.persistence.entity.QTeam;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.jpatest.data.persistence.entity.QMember.*;
import static com.example.jpatest.data.persistence.entity.QTeam.*;

@Repository
public class MemberRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public MemberRepositorySupport(JPAQueryFactory queryFactory) {
        super(Member.class);
        this.queryFactory = queryFactory;
    }

    public List<Member> findByName(String name) {
        return queryFactory
                .selectFrom(member)
//                .join(member.team, team)
//                .fetchJoin()
                .where(member.name.eq(name))
                .fetch();
    }
}
