package com.example.jpatest.service;

import com.example.jpatest.data.dto.MemberDto;
import com.example.jpatest.data.dto.TeamDto;

import java.util.List;

public interface JpaService {
    List<MemberDto> getMemberList();
    List<TeamDto> getTeamList();
}
