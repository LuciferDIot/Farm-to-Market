package com.hcl.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.project.model.User;

@Service
public interface UserService {
	
	public List<User> getUsers();
	
    public void User(User user);

}
