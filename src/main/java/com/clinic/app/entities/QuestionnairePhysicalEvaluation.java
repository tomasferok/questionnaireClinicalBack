package com.clinic.app.entities;

import java.io.Serializable;
import java.util.List;

import com.clinic.app.enums.QuestionnaireType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="questionnaires_medical")
@Data
public class QuestionnairePhysicalEvaluation extends Questionnaire implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@JsonCreator
	public QuestionnairePhysicalEvaluation(@JsonProperty("type") QuestionnaireType type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	public QuestionnairePhysicalEvaluation() {
		super(QuestionnaireType.PhysicalEvaluationQuestionnaire);
	}
	
	@ManyToMany(targetEntity = PhysicalEvaluationCuestion.class)
    @JoinColumn(name = "questionnaireMedical_id")
	private List<PhysicalEvaluationCuestion>cuestions;
	
}
