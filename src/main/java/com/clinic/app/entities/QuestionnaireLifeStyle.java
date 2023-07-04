package com.clinic.app.entities;

import java.io.Serializable;
import java.util.List;
import com.clinic.app.enums.QuestionnaireType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="questionnaires_lifestyle")
@Data
public class QuestionnaireLifeStyle extends Questionnaire implements Serializable{

	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public QuestionnaireLifeStyle() {
	        super(QuestionnaireType.LifeStyleQuestionnaire);
	    }

	    @JsonCreator
	    public QuestionnaireLifeStyle(@JsonProperty("type") QuestionnaireType type) {
	        super(type);
	    }
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	@ManyToMany(targetEntity = LifeStyleCuestion.class)
    @JoinColumn(name = "questionnaireLifestyle_id")
	private List<LifeStyleCuestion>cuestions;
	
	
}
