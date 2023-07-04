package com.clinic.app.entities;

import java.io.Serializable;

import com.clinic.app.enums.AnswerType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="answers")
@Data
public class Answer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private AnswerType type;
	private String answer;
	@ManyToOne
	@JoinColumn(name = "lifeStyleCuestion_id")
	@JsonBackReference
	private LifeStyleCuestion lifeStyleCuestion;
}
