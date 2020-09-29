package com.example.jpatest.service.impl;

import com.example.jpatest.data.dto.MemberDto;
import com.example.jpatest.data.dto.TeamDto;
import com.example.jpatest.data.persistence.entity.Member;
import com.example.jpatest.data.persistence.entity.MemberType;
import com.example.jpatest.data.persistence.entity.Team;
import com.example.jpatest.data.persistence.repository.MemberRepository;
import com.example.jpatest.data.persistence.repository.MemberRepositorySupport;
import com.example.jpatest.data.persistence.repository.TeamRepository;
import com.example.jpatest.service.ExceptionFunction;
import com.example.jpatest.service.JpaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service("jpaService")
public class JpaServiceImpl implements JpaService {

    private final MemberRepository memberRepository;
    private final MemberRepositorySupport memberRepositorySupport;
    private final TeamRepository teamRepository;

    @PostConstruct
    private void init() {
        Team team = Team.builder()
                .name("Team1")
                .build();
        teamRepository.save(team);

        memberRepository.save(Member.builder()
                .name("memberA")
                .age(10)
                .memberType(MemberType.USER)
                .team(team)
                .build()
        );

        memberRepository.save(Member.builder()
                .name("memberB")
                .age(20)
                .memberType(MemberType.USER)
                .team(team)
                .build()
        );
    }

    @Transactional
    @Override
    public List<MemberDto> getMemberList() {
        queryDSLTest();

         return memberRepository.findAll().stream()
                 .map(MemberDto::from)
                 .collect(Collectors.toList());
    }
    @Transactional
    @Override
    public List<TeamDto> getTeamList() {
        return teamRepository.findAll().stream()
                .map(TeamDto::from)
                .collect(Collectors.toList());
    }

    public void queryDSLTest() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Member> memberList = memberRepositorySupport.findByName("memberA");

        System.out.println("==================");
        memberList.stream()
                .map(MemberDto::from)
                .map(wrap(objectMapper::writeValueAsString))
                .forEach(System.out::println);
        System.out.println("==================");
    }

    public static <T, R> Function<T, R> wrap(ExceptionFunction<T, R> f) {
        return (T r) -> {
            try {
                return f.apply(r);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
