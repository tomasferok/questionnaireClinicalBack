package com.clinic.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.app.IServices.IPhysicalEvaluationCuestionService;
import com.clinic.app.entities.PhysicalEvaluationCuestion;
import com.clinic.app.repository.PhysicalEvaluationCuestionRepository;

@Service
public class MedicalCuestionService implements IPhysicalEvaluationCuestionService{

	@Autowired
	PhysicalEvaluationCuestionRepository medicalRepository;
	
	@Override
	public List<PhysicalEvaluationCuestion> getAll() {
		// TODO Auto-generated method stub
		return medicalRepository.findAll();
	}

	@Override
	public PhysicalEvaluationCuestion getById(Long id) {
		// TODO Auto-generated method stub
		return medicalRepository.findById(id).orElse(null);
	}

	@Override
	public void remove(Long id) {
		medicalRepository.deleteById(id);
		
	}

	@Override
	public PhysicalEvaluationCuestion save(PhysicalEvaluationCuestion medicalCuestion) {
		// TODO Auto-generated method stub
		return medicalRepository.save(medicalCuestion);
	}

}
