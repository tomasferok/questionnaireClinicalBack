package com.clinic.app.IServices;

import java.util.List;

import com.clinic.app.entities.PhysicalEvaluationCuestion;

public interface IPhysicalEvaluationCuestionService {

	List<PhysicalEvaluationCuestion>getAll();
	PhysicalEvaluationCuestion getById(Long id);
	void remove(Long id);
	PhysicalEvaluationCuestion save(PhysicalEvaluationCuestion medicalCuestion);
}
