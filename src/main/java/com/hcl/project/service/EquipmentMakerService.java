package com.hcl.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.project.model.Equipment;
import com.hcl.project.model.EquipmentMaker;

@Service
public interface EquipmentMakerService {
	
	public void createEquipmentMaker(EquipmentMaker equipmentMaker);
	
	public void createEquipment(Integer equipmentMakerId,Equipment equipment);
	
	public List<Equipment> getEquipmentList(Integer equipmentMakerId);	
	
	public void updateEquipment(Integer equipmentId,Equipment equipment, Integer equipmentMakerId);
	
	public void deleteEquipment(Integer equipmentMakerId,Integer equipmentId);
	

}
