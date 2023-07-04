package com.clinic.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinic.app.entities.LifeStyleCuestion;

@Repository
public interface LifeStyleCuestionRepository extends JpaRepository<LifeStyleCuestion, Long>{

}
