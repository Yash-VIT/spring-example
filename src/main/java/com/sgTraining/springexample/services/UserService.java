package com.sgTraining.springexample.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sgTraining.springexample.dtos.UserDto;
import com.sgTraining.springexample.mapper.UserMapper;
import com.sgTraining.springexample.repositories.entity.User;
import com.sgTraining.springexample.repositories.entity.UserRepository;

@Component
public class UserService {


//	private List<UserDto> userDto= new ArrayList<>();

//	public UserService() {
//		userDto.add(new UserDto(1,"X","x.com"));
//		userDto.add(new UserDto(2,"Y","y.com"));
//		userDto.add(new UserDto(3,"Z","z.com"));
//	}

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public UserService() {
		this.userRepository = userRepository;
	}

	public List<UserDto> getAllUsers(){
		
//		return userDto;
		
		return userRepository.findAll().parallelStream().map(user->userMapper.map(user, UserDto.class)).collect(Collectors.toList());
		
	}
	
	public boolean createUser(UserDto userDto) {
//		userDto.add(userData);
		
		User entity = userMapper.map(userDto, User.class);
		entity.setUserId(UUID.randomUUID().toString());
		
		userRepository.save(entity);
		return true;
	}
	
	public boolean removeUser(String id) throws Exception{
		
//		UserResponse response = new UserResponse();
//		
//		Optional<UserDto> optionalUserDto = userDto.stream().filter(u->u.getId() == id).findFirst();
//		userDto.remove(optionalUserDto.get());
//		
//		if(!optionalUserDto.isPresent()) {
//			response.setStatus(false);
//			response.setError("Invalid User Data");
////			return ResponseEntity.ok(response); 
//		}
//		
//		response.setStatus(true);
//		response.setMessage("User Deleted Data Successfully");
//		response.setError(null);
//		
//		return ResponseEntity.ok(response);
		
		User user = userRepository.findByUserId(id);
		userRepository.delete(user);
		
//		userRepository.deleteByUserId(id);
		
		return true;
		
	}
	
	public boolean udpateUserEmail(String email,String userId) {
		
		User user = userRepository.findByUserId(userId);
		user.setEmail(email);
		userRepository.save(user);
		return true;
		
	}
	
	
}
