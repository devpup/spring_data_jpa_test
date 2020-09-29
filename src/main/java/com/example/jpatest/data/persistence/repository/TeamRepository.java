package com.example.jpatest.data.persistence.repository;

import com.example.jpatest.data.persistence.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
