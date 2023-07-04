package com.clinic.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.clinic.app.IServices.IQuestionnaireLifeStyleService;
import com.clinic.app.entities.QuestionnaireLifeStyle;

@RestController
@RequestMapping("/api")
public class QuestionnaireLifeStyleController {

	@Autowired
	private IQuestionnaireLifeStyleService questionnaireLifeStyleService;
	

	@GetMapping("/questionnaireLifeStyle")
	public List<QuestionnaireLifeStyle>getAll(){
		
		return questionnaireLifeStyleService.getAll();
	}
	
	@GetMapping("/questionnaireLifeStyle/{id}")
	public QuestionnaireLifeStyle getById(@PathVariable Long id){
		
		return questionnaireLifeStyleService.getById(id);
	}
	
	@PutMapping("/questionnaireLifeStyle/{id}")
	public QuestionnaireLifeStyle update(@RequestBody QuestionnaireLifeStyle questionnaireLifeStyle, @PathVariable Long id, RedirectAttributes flash) {
		QuestionnaireLifeStyle actualQuestionnaire = questionnaireLifeStyleService.getById(id);
		
		if(id > 0) {
			questionnaireLifeStyle = questionnaireLifeStyleService.getById(id);
			flash.addFlashAttribute("error", "This id doesn't exist on the BBDD!");
			
		}else {
			flash.addFlashAttribute("error", "The id hasn't be 0!");
		}
		
		actualQuestionnaire.setCuestions(questionnaireLifeStyle.getCuestions());
		
		
		return questionnaireLifeStyleService.save(actualQuestionnaire);
		
		
	}
	
		@PostMapping("/questionnaireLifeStyle")
	    public QuestionnaireLifeStyle createQuestionnaireLifeStyle(@RequestBody QuestionnaireLifeStyle questionnaireLifeStyle) {
		 

	        return questionnaireLifeStyleService.save(questionnaireLifeStyle);

	    }
	 
	 @DeleteMapping("/questionnaireLifeStyle/{id}")
	    public void deleteQuestionnaire(@PathVariable Long id) {
		 questionnaireLifeStyleService.remove(id);
	    }
}
