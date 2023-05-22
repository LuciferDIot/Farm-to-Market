package com.hcl.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.project.model.Farmer;
import com.hcl.project.model.User;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Integer>{

}
