package com.hcl.project.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("equipment_maker")
public class EquipmentMaker extends User {
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,targetEntity=Equipment.class, mappedBy = "euipment_maker")
	List<Equipment> equipmentsList;
	
	public EquipmentMaker(){}

	public EquipmentMaker(int Id, String firstName, String lastName, String userName, String password, String state,
			String city, String pinCode, String mobileNumber) {
		super(Id, firstName, lastName, userName, password, state, city, pinCode, mobileNumber);
	}
	
	public EquipmentMaker(int userId, String firstName, String lastName, String userName, String password, String state,
			String city, String pinCode, String mobileNumber,List<Equipment> equipmentsList) {
		super(userId, firstName, lastName, userName, password, state, city, pinCode, mobileNumber);
		this.equipmentsList = equipmentsList;
	}

	public List<Equipment> getEquipmentsList() {
		return equipmentsList;
	}

	public void setEquipmentsList(List<Equipment> equipmentsList) {
		this.equipmentsList = equipmentsList;
	}

	@Override
	public String toString() {
		return "EuipmentMaker [equipmentsList=" + equipmentsList + ", userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", userName=" + userName + ", password=" + password + ", state=" + state
				+ ", city=" + city + ", pinCode=" + pinCode + ", mobileNumber=" + mobileNumber + "]";
	}

}
