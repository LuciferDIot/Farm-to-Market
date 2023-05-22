package com.hcl.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.project.model.Equipment;
import com.hcl.project.repository.EquipmentRepository;


@Service
public class EquipmentServiceImpl implements EquipmentService{
	
	@Autowired
	EquipmentRepository equipmentRepo;
	
    public List<Equipment> getEquipment() {
        return equipmentRepo.findAll();
    }
	
    public void createEquipment(Equipment equipment) {
        equipmentRepo.save(equipment);
    }
	
    public void updateEuipment(Integer id,Equipment equipment) {
        equipment.setEquipmentId(id);
        equipmentRepo.save(equipment);
    }
	
    public void delete(Integer id) {
        equipmentRepo.deleteById(id);
    }

}
