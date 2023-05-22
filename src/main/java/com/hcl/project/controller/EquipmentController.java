package com.hcl.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.project.model.Equipment;
import com.hcl.project.repository.EquipmentRepository;

import jakarta.validation.Valid;

@RestController
public class EquipmentController {
	
	@Autowired
	EquipmentRepository equipmentRepo;
	
	@GetMapping("/viewall/equipment")
    public ResponseEntity<List<Equipment>> getEquipment() {
        return new ResponseEntity<>(equipmentRepo.findAll(), HttpStatus.OK);
    }
	
	@PostMapping("/create/equipment")
    public ResponseEntity<String> createEquipment(@Valid @RequestBody Equipment equipment) {
        equipmentRepo.save(equipment);
        return new ResponseEntity<>("Equipment is created successfully", HttpStatus.CREATED);
    }
	
	@PutMapping("update/equipment/{id}")
    public ResponseEntity<String> updateEuipment(@PathVariable("id") Integer id, @RequestBody Equipment equipment) {
        equipment.setEquipmentId(id);
        equipmentRepo.save(equipment);
        return new ResponseEntity<>("Equipment is updated successsfully", HttpStatus.OK);
    }
	
	@DeleteMapping("/deleteEquipment/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        equipmentRepo.deleteById(id);
        return new ResponseEntity<>("Equipment is deleted successsfully", HttpStatus.OK);
    }

}
