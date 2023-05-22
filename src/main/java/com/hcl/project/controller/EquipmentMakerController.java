package com.hcl.project.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.project.model.Equipment;
import com.hcl.project.model.EquipmentMaker;
import com.hcl.project.service.EquipmentMakerServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/equipmentMaker")
public class EquipmentMakerController {
	static Logger lg = Logger.getLogger(EquipmentMakerController.class.getName());
	
	@Autowired
	EquipmentMakerServiceImpl equipmentMakerServiceImpl;
	
	@PostMapping("/create")
    public ResponseEntity<String> createEquipmentMaker(@Valid @RequestBody EquipmentMaker equipmentMaker) {
        equipmentMakerServiceImpl.createEquipmentMaker(equipmentMaker);
        lg.info("Created Equipment Maker");
        return new ResponseEntity<>("Equipment maker is created successfully", HttpStatus.CREATED);
    }
	
	@PostMapping("/{equipmentMakerId}/create/equipment")
	public ResponseEntity<String> createEquipment(@PathVariable("equipmentMakerId") Integer equipmentMakerId,@RequestBody Equipment equipment){
		equipmentMakerServiceImpl.createEquipment(equipmentMakerId, equipment);
        lg.info("Created Equipment on equipmentMakerId"+equipmentMakerId);
		return new ResponseEntity<>("Equipment is created", HttpStatus.OK);	
	}
	
	@GetMapping("/{equipmentMakerId}/viewAllEquipment")
	public ResponseEntity<List<Equipment>> getEquipmentList(@PathVariable("equipmentMakerId") Integer equipmentMakerId){
		List<Equipment> equipmentList = equipmentMakerServiceImpl.getEquipmentList(equipmentMakerId);
		lg.info("Get Equipment List");
		return new ResponseEntity<>(equipmentList, HttpStatus.OK);
	}	
	
	@PutMapping("/{equipmentMakerId}/update/{equipmentId}")
	public ResponseEntity<String> updateEquipment(@PathVariable ("equipmentMakerId") Integer equipmentMakerId,@PathVariable ("equipmentId") Integer equipmentId,@RequestBody Equipment equipment){
		equipmentMakerServiceImpl.updateEquipment(equipmentId, equipment,equipmentMakerId);
		lg.info("Update Equipment");
		return new ResponseEntity<>("Equipment is updated successsfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/{equipmentMakerId}/delete/{equipmentId}")
	public ResponseEntity<String> deleteEquipment(@PathVariable ("equipmentMakerId") Integer equipmentMakerId,@PathVariable ("equipmentId") Integer equipmentId){
		equipmentMakerServiceImpl.deleteEquipment(equipmentMakerId, equipmentId);
		lg.info("Delete Equipment");
		return new ResponseEntity<>("Equipment is deleted successsfully", HttpStatus.OK);
	}
	
	
	

}
