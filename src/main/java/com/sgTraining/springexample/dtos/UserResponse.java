package com.sgTraining.springexample.dtos;

import lombok.Data;

@Data
public class UserResponse {

	private boolean Status;
	private String error;
	private String message;
	
}
