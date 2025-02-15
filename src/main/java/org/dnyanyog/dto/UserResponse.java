package org.dnyanyog.dto;

import org.dnyanyog.entity.User;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserResponse {

	private String code;
	private String msg;
	private User user;

//	private List<Users> users;

	@Autowired
	private UserRequest request;

	public UserRequest getRequest() {
		return request;
	}

	public void setRequest(UserRequest request) {
		this.request = request;
	}

//	
//	public List<Users> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<Users> users) {
//		this.users = users;
//	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setRequest(User user) {
	this.user = user;
		
	}
}
