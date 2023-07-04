package com.clinic.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinic.app.entities.PhysicalEvaluationCuestion;

@Repository
public interface PhysicalEvaluationCuestionRepository extends JpaRepository<PhysicalEvaluationCuestion, Long>{

}
