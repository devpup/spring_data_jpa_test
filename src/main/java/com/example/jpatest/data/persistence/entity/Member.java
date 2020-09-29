package com.example.jpatest.data.persistence.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
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
