package com.clinic.app.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.clinic.app.enums.QuestionnaireType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="questionnaires")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Questionnaire implements Serializable{
	
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Enumerated(EnumType.STRING)
	    private QuestionnaireType type;
	
	    public Questionnaire(QuestionnaireType type) {
	        this.type = type;
	    }
	
}
