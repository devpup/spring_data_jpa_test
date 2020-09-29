package com.example.jpatest.data.persistence.entity;

import com.example.jpatest.data.dto.MemberDto;
import com.example.jpatest.data.dto.TeamDto;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.ObjectIdGenerators.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class/*, property = "id"*/) // 추가
@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_name")
    private String name;

    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;


//    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private LocalDateTime regDate;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;
}
