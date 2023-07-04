package com.clinic.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.app.IServices.ILifeStyleCuestionService;
import com.clinic.app.IServices.IQuestionnaireLifeStyleService;
import com.clinic.app.entities.QuestionnaireLifeStyle;
import com.clinic.app.repository.AnswerRepository;
import com.clinic.app.repository.QuestionnaireLifeStyleRepository;

@Service
public class QuestionnaireLifeStyleService implements IQuestionnaireLifeStyleService{

	@Autowired
	QuestionnaireLifeStyleRepository questionnaireLifeStyleService;
	@Autowired
	AnswerRepository answerRepository;
	@Autowired
	ILifeStyleCuestionService lifeStyleCuestionService;
	
	@Override
	public List<QuestionnaireLifeStyle> getAll() {
		// TODO Auto-generated method stub
		return questionnaireLifeStyleService.findAll();
	}

	@Override
	public QuestionnaireLifeStyle getById(Long id) {
		// TODO Auto-generated method stub
		return questionnaireLifeStyleService.findById(id).orElse(null);
	}

	@Override
	public void remove(Long id) {
		questionnaireLifeStyleService.deleteById(id);

	}

	@Override
	public QuestionnaireLifeStyle save(QuestionnaireLifeStyle questionnaireLifeStyle) {
		 questionnaireLifeStyle.getCuestions().stream().forEach(cuestion->{
			 lifeStyleCuestionService.save(cuestion);
		 });
		        
		        
		   
		return questionnaireLifeStyleService.save(questionnaireLifeStyle);
	}

}
