package com.example.jpatest.service.impl;

import com.example.jpatest.data.dto.MemberDto;
import com.example.jpatest.data.dto.TeamDto;
import com.example.jpatest.data.persistence.entity.Member;
import com.example.jpatest.data.persistence.entity.MemberType;
import com.example.jpatest.data.persistence.entity.Team;
import com.example.jpatest.data.persistence.repository.MemberRepository;
import com.example.jpatest.data.persistence.repository.TeamRepository;
import com.example.jpatest.service.JpaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service("jpaService")
public class JpaServiceImpl implements JpaService {

    private final MemberRepository memberRepository;
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

    @Override
    public List<MemberDto> getMemberList() {
         return memberRepository.findAll().stream()
                 .map(MemberDto::from)
                 .collect(Collectors.toList());
    }

    @Override
    public List<TeamDto> getTeamList() {
        return teamRepository.findAll().stream()
                .map(TeamDto::from)
                .collect(Collectors.toList());
    }

}
