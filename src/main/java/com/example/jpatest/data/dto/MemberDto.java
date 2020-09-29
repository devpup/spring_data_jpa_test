package com.example.jpatest.data.dto;

import com.example.jpatest.data.persistence.entity.Member;
import com.example.jpatest.data.persistence.entity.MemberType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
public class MemberDto {
    private Long id;
    private String name;
    private int age;
    private Long teamId;
    private LocalDateTime regDate;
    private MemberType memberType;

    public static MemberDto from(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .age(member.getAge())
                .regDate(member.getRegDate())
                .memberType(member.getMemberType())
                .teamId(member.getTeam().getId())
                .build();
    }
}
