package com.clinic.app.IServices;

import java.util.List;

import com.clinic.app.entities.QuestionnaireLifeStyle;

public interface IQuestionnaireLifeStyleService {

	List<QuestionnaireLifeStyle>getAll();
	QuestionnaireLifeStyle getById(Long id);
	void remove(Long id);
	QuestionnaireLifeStyle save(QuestionnaireLifeStyle questionnaireLifeStyle);
}
