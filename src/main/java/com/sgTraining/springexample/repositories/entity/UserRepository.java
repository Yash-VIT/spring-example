package com.sgTraining.springexample.repositories.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	void deleteByUserId(String id);
	
	User findByUserId(String id);

}
