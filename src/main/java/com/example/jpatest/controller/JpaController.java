package com.example.jpatest.controller;

import com.example.jpatest.data.dto.MemberDto;
import com.example.jpatest.data.dto.TeamDto;
import com.example.jpatest.service.JpaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class JpaController {

    private final JpaService jpaService;

    @GetMapping("/members")
    public List<MemberDto> members() {
        return jpaService.getMemberList();
    }

    @GetMapping("/teams")
    public List<TeamDto> teams() {
        return jpaService.getTeamList();
    }

}
