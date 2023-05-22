package com.hcl.project.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.project.exceptions.EquipmentNotFound;
import com.hcl.project.exceptions.UserNotFound;
import com.hcl.project.model.Equipment;
import com.hcl.project.model.EquipmentMaker;
import com.hcl.project.repository.EquipmentMakerRepository;
import com.hcl.project.repository.EquipmentRepository;

@Service
public class EquipmentMakerServiceImpl implements EquipmentMakerService {
	
	
	@Autowired
	EquipmentRepository equipmentRepo;
	
	
	@Autowired
	EquipmentMakerRepository equipmentMakerRepo;
	
    public void createEquipmentMaker(EquipmentMaker equipmentMaker) {
        equipmentMakerRepo.save(equipmentMaker);
    }
	
	public void createEquipment(Integer equipmentMakerId,Equipment equipment){
		EquipmentMaker equipmentMaker = equipmentMakerRepo.findById(equipmentMakerId).get();
		if(equipmentMaker.equals(null)) throw new UserNotFound("User not found");
		equipmentMaker.getEquipmentsList().add(equipment);
		equipment.setEuipmentMaker(equipmentMaker);
		equipmentMakerRepo.save(equipmentMaker);	
	}
	
	public List<Equipment> getEquipmentList(Integer equipmentMakerId){
		List<Equipment> notRentedEquipments = new ArrayList<>();
		EquipmentMaker equipmentMaker = equipmentMakerRepo.findById(equipmentMakerId).get();
		if(equipmentMaker.equals(null)) throw new UserNotFound("User not found");
		
		for(Equipment equipment : equipmentMaker.getEquipmentsList()) {
			if (equipment.getEquipment_buyer()==null) {
				notRentedEquipments.add(equipment);
			}
		}
		return notRentedEquipments;
	}	
	
	public void updateEquipment(Integer equipmentId,Equipment equipment, Integer equipmentMakerId){
		EquipmentMaker maker = equipmentMakerRepo.findById(equipmentMakerId).get();
		if(maker.equals(null)) throw new UserNotFound("User not found");
		
		equipment.setEquipmentId(equipmentId);
		equipment.setEuipmentMaker(maker);
		equipmentRepo.save(equipment);
		
	}
	
	public void deleteEquipment(Integer equipmentMakerId,Integer equipmentId){
		EquipmentMaker equipmentMaker = equipmentMakerRepo.findById(equipmentMakerId).get();
		if(equipmentMaker.equals(null)) throw new UserNotFound("User not found");
		
		Equipment equipment = equipmentRepo.findById(equipmentId).get();
		if(equipment.equals(null)) throw new EquipmentNotFound("User not found");
		
		equipmentMaker.getEquipmentsList().remove(equipmentMaker.getEquipmentsList().indexOf(equipment));
		equipmentMakerRepo.save(equipmentMaker);

	}

}
