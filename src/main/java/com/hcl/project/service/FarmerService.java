package com.hcl.project.service;

import java.util.List;

import com.hcl.project.model.Farmer;
import com.hcl.project.model.Item;
import jakarta.validation.Valid;

public interface FarmerService {
	 List<Farmer> findAll();
	 void save(@Valid Farmer farmer);
	 Farmer findById(Integer farmerId);
	 void addFarmerEquipment(Integer farmerId, Integer equipmentId);
	 void deleteFarmerEquipment(Integer farmerId, Integer equipmentId) ;
	 List<Item> getFarmerItems(Integer farmerId);
	 void updateFarmerItem(Integer farmerId, Item item) ;
	 void createFarmerItem(Integer farmerId, Item item);
	 void deleteFarmerItem(Integer farmerId, Integer itemId);
}
