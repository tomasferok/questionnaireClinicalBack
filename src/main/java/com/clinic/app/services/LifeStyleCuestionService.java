package com.clinic.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.app.IServices.ILifeStyleCuestionService;
import com.clinic.app.entities.Answer;
import com.clinic.app.entities.LifeStyleCuestion;
import com.clinic.app.repository.AnswerRepository;
import com.clinic.app.repository.LifeStyleCuestionRepository;

@Service
public class LifeStyleCuestionService implements ILifeStyleCuestionService {

	@Autowired
	LifeStyleCuestionRepository lifeStyleRepository;
	@Autowired
	AnswerRepository answerRepository;
	
	@Override
	public List<LifeStyleCuestion> getAll() {
		// TODO Auto-generated method stub
		return lifeStyleRepository.findAll();
	}

	@Override
	public LifeStyleCuestion getById(Long id) {
		// TODO Auto-generated method stub
		return lifeStyleRepository.findById(id).orElse(null);
	}

	@Override
	public void remove(Long id) {
		lifeStyleRepository.deleteById(id);
		
	}

	@Override
	public LifeStyleCuestion save(LifeStyleCuestion lifeStyleCuestion) {
		 LifeStyleCuestion savedCuestion = lifeStyleRepository.save(lifeStyleCuestion);
	        
	        for (Answer answer : lifeStyleCuestion.getAnswers()) {
	            answer.setLifeStyleCuestion(savedCuestion);
	            answerRepository.save(answer);
	        }
		return savedCuestion;
	}


}
