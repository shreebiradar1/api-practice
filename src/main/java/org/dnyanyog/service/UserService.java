package org.dnyanyog.service;

import java.util.List;

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

	public UserResponse saveUser(UserRequest request) {
		User userTable = new User();
		userTable.setId(request.getId());
		userTable.setFirstName(request.getFirstName());
		userTable.setLastName(request.getLastName());
		userTable.setEmail(request.getEmail());
		userTable.setMobile(request.getMobile());
		userRepo.save(userTable);

		response.setCode("0000");
		response.setMsg("Everthing is fine");
		response.setRequest(request);
		return response;
	}

//	// Update operation
//	public UserResponse updateUserbyid(long id,User request) {
//		Optional<User> userList = userRepo.findById(id);
//		if(userList.isEmpty()) {
//			response.setCode("911");
//			response.setMsg("User does not found");
//			return response;
//		} else {
//			userData = userList.get();
//		}
//		return response;
//		
//	}
	// Search operation
	public User getUserbyid(long id) {

		return userRepo.findById(id).orElse(null);
	}
	//Search by name
	public User getUserByName(String firstName) {
		
		return userRepo.findByFirstName(firstName);
	}

	// Delete operation
	public UserResponse removeUser(String name) {
		if (userRepo.findByFirstName(name) == null) {
			response.setCode("911");
			response.setMsg("User not present");
		}

		int result = userRepo.deleteByFirstName(name);
		if (result > 0) {
			response.setCode("0000");
			response.setMsg("User deleted successful");

//			return response;
		}
		return response;
	}

	// Display all
	public List<User> allUser() {
		return userRepo.findAll();
	}

}
