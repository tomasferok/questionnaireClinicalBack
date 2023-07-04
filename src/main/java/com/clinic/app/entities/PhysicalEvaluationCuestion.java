package com.clinic.app.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class PhysicalEvaluationCuestion extends Cuestion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonCreator
	public PhysicalEvaluationCuestion(String statement) {
		super(statement);
		// TODO Auto-generated constructor stub
	}
	public PhysicalEvaluationCuestion() {
		
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String type;
	@OneToMany
	private List<Answer> answers;

}
