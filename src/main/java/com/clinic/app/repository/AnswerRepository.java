package com.clinic.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinic.app.entities.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
