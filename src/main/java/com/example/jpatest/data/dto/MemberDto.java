package com.example.jpatest.data.dto;

import com.example.jpatest.data.persistence.entity.Member;
import com.example.jpatest.data.persistence.entity.MemberType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
public class MemberDto {
    private Long id;
    private String name;
    private int age;
    private Long teamId;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
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
