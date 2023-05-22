package com.hcl.project.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("farmer_ID")
public class Farmer extends User{
	
	@JsonIgnore
	@OneToMany(mappedBy = "equipment_buyer", fetch = FetchType.LAZY)
	List<Equipment> equipmentsList;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "farmer_id", fetch = FetchType.LAZY )
	List<Item> itemsList;
	
	public Farmer() {}

	public Farmer(int userId, String firstName, String lastName, String userName, String password, String state,
			String city, String pinCode, String mobileNumber) {
		super(userId, firstName, lastName, userName, password, state, city, pinCode, mobileNumber);
	}

	public List<Equipment> getEquipmentsList() {
		return equipmentsList;
	}

	public void setEquipmentsList(List<Equipment> equipmentsList) {
		this.equipmentsList = equipmentsList;
	}
	public List<Item> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<Item> itemsList) {
		this.itemsList = itemsList;
	}

	@Override
	public String toString() {
		return "Farmer [equipmentsList=" + equipmentsList + ", userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", userName=" + userName + ", password=" + password + ", state=" + state
				+ ", city=" + city + ", pinCode=" + pinCode + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
	

}
