package com.clinic.app.entities;


import java.io.Serializable;
import java.util.List;

import com.clinic.app.enums.TypesLifeStyleCuestions;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="lifeStyleCuestion")
@Data
public class LifeStyleCuestion extends Cuestion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonCreator
    public LifeStyleCuestion(String statement) {
        super(statement);
    }

    public LifeStyleCuestion() {
        // Constructor sin argumentos
    }
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Enumerated(EnumType.STRING)
	private TypesLifeStyleCuestions types;
	@OneToMany(mappedBy = "lifeStyleCuestion")
	@JsonManagedReference
	private List<Answer> answers;
}
