package com.sgTraining.springexample.mapper;

import org.springframework.stereotype.Component;

import com.sgTraining.springexample.dtos.UserDto;
import com.sgTraining.springexample.repositories.entity.User;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class UserMapper extends ConfigurableMapper{
	
	@Override
	protected void configure(MapperFactory factory) {
		// TODO Auto-generated method stub
//		super.configure(factory);
		
		factory.registerClassMap(factory.classMap(User.class, UserDto.class).byDefault().toClassMap());
		
	}
	
}
