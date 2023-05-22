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
import com.hcl.project.model.Farmer;
import com.hcl.project.model.Item;
import com.hcl.project.service.FarmerServiceImple;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/farmer")
public class FarmerController {
	static Logger lg = Logger.getLogger(FarmerController.class.getName());
	
	@Autowired
	FarmerServiceImple farmerServiceImple;
	
	@GetMapping("/viewall")
    public ResponseEntity<List<Farmer>> getFarmer() {
		lg.info("View All Farmers");
        return new ResponseEntity<>(farmerServiceImple.findAll(), HttpStatus.OK);
    }
	
	@PostMapping("/create")
    public ResponseEntity<String> createFarmer(@Valid @RequestBody Farmer farmer) {
        farmerServiceImple.save(farmer);
		lg.info("Create Farmer");
        return new ResponseEntity<>("Farmer is created successfully", HttpStatus.CREATED);
    }
	
	@GetMapping("/{farmerId}/viewEquipment")
	public ResponseEntity<List<Equipment>> getFarmerEquipments(@PathVariable("farmerId") Integer farmerId){
		Farmer farmer = farmerServiceImple.findById(farmerId);
		lg.info("Bought equipments of Farmer");
		return new ResponseEntity<>(farmer.getEquipmentsList(), HttpStatus.OK);
	}
	
	@PutMapping("/{farmerId}/add/{equipmentId}")
	public ResponseEntity<String> addFarmerEquipment(
			@PathVariable("farmerId")Integer farmerId,
			@PathVariable("equipmentId")Integer equipmentId){
		farmerServiceImple.addFarmerEquipment(farmerId, equipmentId);
		lg.info("Buy a equipment for the Farmer");
		return new ResponseEntity<>("Equipment is added to Farmer list", HttpStatus.OK);	
	}
	
	@DeleteMapping("/{farmerId}/delete/equipment/{equipmentId}")
	public ResponseEntity<String> deleteFarmerEquipment(@PathVariable("farmerId")Integer farmerId,@PathVariable("equipmentId")Integer equipmentId){
		farmerServiceImple.deleteFarmerEquipment(farmerId, equipmentId);
		lg.info("return equipment of the Farmer");
		return new ResponseEntity<>("Equipment is deleted", HttpStatus.OK);	
	}
	
	@GetMapping("/{farmerId}/viewItem")
	public ResponseEntity<List<Item>> getFarmerItems(@PathVariable("farmerId") Integer farmerId){
		List<Item> items = farmerServiceImple.getFarmerItems(farmerId);
		lg.info("Get farmer items");
		return new ResponseEntity<>(items, HttpStatus.OK);
	}
	
	@PutMapping("/{farmerId}/item/update/{itemId}")
	public ResponseEntity<String> updateFarmerItem(@PathVariable("farmerId")Integer farmerId,@PathVariable("itemId")Integer itemId,@RequestBody Item item){
		item.setItemId(itemId);
		farmerServiceImple.updateFarmerItem(farmerId,item);
		lg.info("Update farmer added item");
		return new ResponseEntity<>("Item is updated", HttpStatus.OK);	
	}
	
	
	@PostMapping("/{farmerId}/create/item")
	public ResponseEntity<String> createFarmerItem(@PathVariable("farmerId")Integer farmerId,@RequestBody Item item){
		farmerServiceImple.createFarmerItem(farmerId, item);
		lg.info("Add new farmer item");
		return new ResponseEntity<>("Item is created", HttpStatus.OK);	
	}
	
	@DeleteMapping("/{farmerId}/delete/item/{itemId}")
	public ResponseEntity<String> deleteFarmerItem(@PathVariable("farmerId")Integer farmerId,@PathVariable("itemId")Integer itemId){
		farmerServiceImple. deleteFarmerItem(farmerId, itemId);
		lg.info("Delete farmer added item");
		return new ResponseEntity<>("Item is deleted", HttpStatus.OK);	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
