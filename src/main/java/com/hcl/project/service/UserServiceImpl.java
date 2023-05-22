package com.hcl.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.project.model.User;
import com.hcl.project.repository.UserRepository;

import jakarta.validation.Valid;

public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;
	
    public List<User> getUsers() {
        return userRepo.findAll();
    }
	
    public void User(User user) {
        userRepo.save(user);
    }

}
