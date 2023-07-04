package com.clinic.app.entities;


import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
public class Cuestion {

	public Cuestion( String statement) {
		
		this.statement = statement;
	}
	private String statement;
}
