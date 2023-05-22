package com.hcl.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.project.model.Farmer;
import com.hcl.project.model.User;
import com.hcl.project.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/viewall/user")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
    }
	
	@PostMapping("/create/user")
    public ResponseEntity<String> User(@Valid @RequestBody User user) {
        userRepo.save(user);
        return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
    }
	
	
}
