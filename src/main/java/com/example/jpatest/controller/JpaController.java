package com.example.jpatest.controller;

import com.example.jpatest.data.persistence.entity.Member;
import com.example.jpatest.service.JpaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class JpaController {

    private final JpaService jpaService;

    @GetMapping("/members")
    List<Member> members() {
        return jpaService.getMemberList();
    }

}
