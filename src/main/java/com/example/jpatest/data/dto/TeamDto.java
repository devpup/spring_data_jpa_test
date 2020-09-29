package com.example.jpatest.data.dto;

import com.example.jpatest.data.persistence.entity.Member;
import com.example.jpatest.data.persistence.entity.Team;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Setter
@Getter
public class TeamDto {
    private Long id;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<Long> members = new ArrayList<>();

    static public TeamDto from(Team team) {
        return TeamDto.builder()
                .id(team.getId())
                .name(team.getName())
                .members(team.getMembers().stream()
                        .map(Member::getId)
                        .collect(Collectors.toList()))
                .build();
    }

    static public TeamDto fromExMember(Team team) {
        return TeamDto.builder()
                .id(team.getId())
                .name(team.getName())
                .build();
    }
}
