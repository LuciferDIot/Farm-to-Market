package com.hcl.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.project.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
