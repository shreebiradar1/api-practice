package org.dnyanyog.service;

import java.util.List;
import java.util.Optional;

import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.entity.User;
import org.dnyanyog.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	UserResponse response;

	@Autowired
	User userData;

	public UserResponse saveUser(UserRequest request) {
		User userTable = new User();
		userTable.setId(request.getId());
		userTable.setFirstName(request.getFirstName());
		userTable.setLastName(request.getLastName());
		userTable.setEmail(request.getEmail());
		userTable.setMobile(request.getMobile());
		userTable.setLoginName(request.getLoginName());
		userTable.setPassword(request.getPassword());
		userRepo.save(userTable);

		response.setCode("0000");
		response.setMsg("Everthing is fine");
		response.setRequest(request);
		return response;
	}

	// Search operation
	public User getUserbyid(long id) {
				
		return userRepo.findById(id).orElse(null);
	}

	//Delete operation
	public UserResponse removeUser(long id) {
		userRepo.deleteById(id);
		response.setCode("0000");
		response.setMsg("User deleted successfull");
		return response;
	}

	//Display all
	public List<User> allUser(){
		return userRepo.findAll();
	}

}
