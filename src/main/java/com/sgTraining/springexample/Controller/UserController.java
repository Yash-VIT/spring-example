package com.sgTraining.springexample.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgTraining.springexample.dtos.UserDto;
import com.sgTraining.springexample.services.UserService;

@RequestMapping("/users")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping
	public List<UserDto> getAllUsers(){
		return userService.getAllUsers();
	}
	
	
	@PostMapping
	public boolean createUser(@RequestBody UserDto userData) {
		return userService.createUser(userData);
	}
	
	@DeleteMapping("{id}")
	public boolean removeUser(@PathVariable String id) throws Exception{
		return userService.removeUser(id);
	}
	
	@PutMapping("{id}")
	public boolean udpateUserEmail(@RequestBody String email,@PathVariable String id){
		return userService.udpateUserEmail(email, id);
	}
}
