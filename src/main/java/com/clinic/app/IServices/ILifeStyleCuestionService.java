package com.clinic.app.IServices;

import java.util.List;

import com.clinic.app.entities.LifeStyleCuestion;



public interface ILifeStyleCuestionService {

	List<LifeStyleCuestion>getAll();
	LifeStyleCuestion getById(Long id);
	void remove(Long id);
	LifeStyleCuestion save( LifeStyleCuestion lifeStyleCuestion);
	
}
