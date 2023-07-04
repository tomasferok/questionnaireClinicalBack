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

import com.clinic.app.IServices.IPhysicalEvaluationCuestionService;
import com.clinic.app.entities.PhysicalEvaluationCuestion;

@RestController
@RequestMapping("/api")
public class PhysicalEvaluationController {

	@Autowired
	private IPhysicalEvaluationCuestionService medicalService;
	

	@GetMapping("/medicalCuestion")
	public List<PhysicalEvaluationCuestion>getAll(){
		
		return medicalService.getAll();
	}
	
	@PutMapping("/medicalCuestion/{id}")
	public PhysicalEvaluationCuestion update(@RequestBody PhysicalEvaluationCuestion medicalCuestion, @PathVariable Long id, RedirectAttributes flash) {
		PhysicalEvaluationCuestion actualCuestion = medicalService.getById(id);
		
		if(id > 0) {
			medicalCuestion = medicalService.getById(id);
			flash.addFlashAttribute("error", "This id doesn't exist on the BBDD!");
			
		}else {
			flash.addFlashAttribute("error", "The id hasn't be 0!");
		}
		
		actualCuestion.setStatement(medicalCuestion.getStatement());
		
		
		return medicalService.save(actualCuestion);
		
		
	}
	
		@PostMapping("/medicalCuestion")
	    public PhysicalEvaluationCuestion createLifeStyleCuestion(@RequestBody PhysicalEvaluationCuestion medicalCuestion) {
		 

	        return medicalService.save(medicalCuestion);

	    }
	 
	 @DeleteMapping("/medicalCuestion/{id}")
	    public void deleteMedicalCuestion(@PathVariable Long id) {
		 medicalService.remove(id);
	    }
}
