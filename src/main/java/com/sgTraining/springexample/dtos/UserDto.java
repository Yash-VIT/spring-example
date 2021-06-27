package com.sgTraining.springexample.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Creating Entity for User mapping

//Using AllArgConstructor to generate constructor using Lombok and NoArgsConstructor for Default Constructor.
//Data annotation from Lombok helps in automatic getter-setter generation

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
	
	private String userId;
	private String name;
	private String email;
	

}
