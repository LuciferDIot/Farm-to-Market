package com.hcl.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.project.exceptions.EquipmentNotFound;
import com.hcl.project.exceptions.ItemNotFound;
import com.hcl.project.exceptions.UserNotFound;
import com.hcl.project.model.Equipment;
import com.hcl.project.model.Farmer;
import com.hcl.project.model.Item;
import com.hcl.project.repository.EquipmentRepository;
import com.hcl.project.repository.FarmerRepository;
import com.hcl.project.repository.ItemRepository;

import jakarta.validation.Valid;

@Service
public class FarmerServiceImple implements FarmerService{

	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	FarmerRepository farmerRepository;
	
	@Autowired
	EquipmentRepository equipmentRepository;

	public List<Farmer> findAll() {
		return farmerRepository.findAll();
	}

	public void save(@Valid Farmer farmer) {
		farmerRepository.save(farmer);
		
	}

	public Farmer findById(Integer farmerId) {
		return farmerRepository.findById(farmerId).get();
	}

	public void addFarmerEquipment(Integer farmerId, Integer equipmentId) {
		Farmer farmer = farmerRepository.findById(farmerId).get();
		if(farmer.equals(null)) throw new UserNotFound("User not found");
		Equipment equipment = equipmentRepository.findById(equipmentId).get();
		if(equipment==null) throw new EquipmentNotFound("Equipment not found");
		
		
		farmer.getEquipmentsList().add(equipment);
		equipment.setEquipment_buyer(farmer);
		
		farmerRepository.save(farmer);
	}

	public void deleteFarmerEquipment(Integer farmerId, Integer equipmentId) {
		Farmer farmer = farmerRepository.findById(farmerId).get();
		if(farmer.equals(null)) throw new UserNotFound("User not found");
		Equipment equipment = equipmentRepository.findById(equipmentId).get();
		if(equipment==null) throw new EquipmentNotFound("Equipment not found");
		
		List<Equipment> equipments= farmer.getEquipmentsList();
		
		for(Equipment e: equipments) {
			if (equipment.getEquipmentId()==e.getEquipmentId()) {
				equipments.remove(e);
				break;
			}
		}
		
		equipment.setEquipment_buyer(null);
		farmerRepository.save(farmer);
		
	}

	public List<Item> getFarmerItems(Integer farmerId) {
		List<Item> itemsToSellItems = new ArrayList<>();
		Farmer farmer = farmerRepository.findById(farmerId).get();
		if(farmer.equals(null)) throw new UserNotFound("User not found");
		if(farmer.getItemsList().size()==0) throw new ItemNotFound("Item not found");
		
		for(Item i:farmer.getItemsList()) {
			if (i.getTrader()==null) {
				itemsToSellItems.add(i);
			}
		}
		return itemsToSellItems;
	}

	public void updateFarmerItem(Integer farmerId, Item item) {
		Farmer farmer = farmerRepository.findById(farmerId).get();
		if(farmer.equals(null)) throw new UserNotFound("User not found");
		List<Item> items = farmer.getItemsList();
		if(items.size()==0) throw new ItemNotFound("Item not found");
		
		item.setFarmer(farmer);
		for(Item e: items) {
			if (item.getItemId()==e.getItemId()) {
				e = item;
				item.setFarmer(farmer);
			}
		}
		farmerRepository.save(farmer);
		itemRepository.save(item);
	}

	public void createFarmerItem(Integer farmerId, Item item) {
		Farmer farmer = farmerRepository.findById(farmerId).get();
		if(farmer.equals(null)) throw new UserNotFound("User not found");
		farmer.getItemsList().add(item);
		item.setFarmer(farmer);
		
		farmerRepository.save(farmer);
	}

	public void deleteFarmerItem(Integer farmerId, Integer itemId) {
		Farmer farmer = farmerRepository.findById(farmerId).get();
		if(farmer.equals(null)) throw new UserNotFound("User not found");
		Item item = itemRepository.findById(itemId).get();
		if(item.equals(null)) throw new ItemNotFound("Item not found");
		
		farmer.getItemsList().remove(farmer.getItemsList().indexOf(item));
		farmerRepository.save(farmer);
		itemRepository.delete(item);
	}

}
