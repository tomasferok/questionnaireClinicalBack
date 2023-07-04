package com.clinic.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinic.app.entities.QuestionnaireLifeStyle;

@Repository
public interface QuestionnaireLifeStyleRepository extends JpaRepository<QuestionnaireLifeStyle, Long>{

}
