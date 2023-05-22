package com.hcl.project.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.hcl.project.model.Equipment;

@Service
public interface EquipmentService {
	
	
	public List<Equipment> getEquipment();
	
    public void createEquipment(Equipment equipment);
	
    public void updateEuipment(Integer id,Equipment equipment);
	
    public void delete(Integer id);

}
