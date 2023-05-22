package com.hcl.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.project.model.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer>{

}
