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

import com.clinic.app.IServices.ILifeStyleCuestionService;
import com.clinic.app.entities.LifeStyleCuestion;



@RestController
@RequestMapping("/api")
public class LifeStyleController {
	@Autowired
	private ILifeStyleCuestionService lifeStyleCuestionService;
	

	@GetMapping("/lifeCuestion")
	public List<LifeStyleCuestion>getAll(){
		
		return lifeStyleCuestionService.getAll();
	}
	
	@PutMapping("/lifeCuestion/{id}")
	public LifeStyleCuestion update(@RequestBody LifeStyleCuestion lifeStyleCuestion, @PathVariable Long id, RedirectAttributes flash) {
		LifeStyleCuestion actualCuestion = lifeStyleCuestionService.getById(id);
		
		if(id > 0) {
			lifeStyleCuestion = lifeStyleCuestionService.getById(id);
			flash.addFlashAttribute("error", "This id doesn't exist on the BBDD!");
			
		}else {
			flash.addFlashAttribute("error", "The id hasn't be 0!");
		}
		
		actualCuestion.setStatement(lifeStyleCuestion.getStatement());
		
		
		return lifeStyleCuestionService.save(actualCuestion);
		
		
	}
	
		@PostMapping("/lifeCuestion")
	    public LifeStyleCuestion createLifeStyleCuestion(@RequestBody LifeStyleCuestion lifeStyleCuestion) {
		 

	        return lifeStyleCuestionService.save(lifeStyleCuestion);

	    }
	 
	 @DeleteMapping("/lifeCuestion/{id}")
	    public void deleteLifeStyleCuestion(@PathVariable Long id) {
		 lifeStyleCuestionService.remove(id);
	    }
	
}
