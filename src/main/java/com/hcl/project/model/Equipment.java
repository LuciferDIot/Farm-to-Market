package com.hcl.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Equipments")
public class Equipment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int equipmentId;
	
	@NotBlank(message = "Can't be empty or have blanks")
	@NotEmpty(message = "Can't be empty or have blanks")
	String equipmentName;
	
	@NotNull
	int count;
	
	@NotNull
	double rentPerDay;
	
	@NotBlank(message = "Can't be empty or have blanks")
	@NotEmpty(message = "Can't be empty or have blanks")
	String state;
	
	@NotBlank(message = "Can't be empty or have blanks")
	@NotEmpty(message = "Can't be empty or have blanks")
	String city;
	
	@NotBlank(message = "Can't be empty or have blanks")
	@NotEmpty(message = "Can't be empty or have blanks")
	String village;
	
	@NotBlank(message = "Can't be empty or have blanks")
	@NotEmpty(message = "Can't be empty or have blanks")
	String pinCode;
	
	@NotBlank(message = "Can't be empty or have blanks")
	@NotEmpty(message = "Can't be empty or have blanks")
	String contactPerson;
	
	@NotBlank(message = "Can't be empty or have blanks")
	@NotEmpty(message = "Can't be empty or have blanks")
	String mobileNumber;
	
	@NotBlank(message = "Can't be empty or have blanks")
	@NotEmpty(message = "Can't be empty or have blanks")
	String imageUrl;
	
	@ManyToOne
	@JoinColumn(name = "equipment_buyer_id")
	private Farmer equipment_buyer;
	
	@ManyToOne
	@JoinColumn(name = "euipment_maker_id")
	private EquipmentMaker euipment_maker;
	
	public Equipment() {}
	
	public Equipment(int equipmentId, String equipmentName, int count, double rentPerDay, String state, String city,
			String village, String pinCode, String contactPerson, String mobileNumber) {
		super();
		this.equipmentId = equipmentId;
		this.equipmentName = equipmentName;
		this.count = count;
		this.rentPerDay = rentPerDay;
		this.state = state;
		this.city = city;
		this.village = village;
		this.pinCode = pinCode;
		this.contactPerson = contactPerson;
		this.mobileNumber = mobileNumber;
	}

	public Farmer getEquipment_buyer() {
		return equipment_buyer;
	}

	public void setEquipment_buyer(Farmer equipmentBuyer) {
		this.equipment_buyer = equipmentBuyer;
	}

	public EquipmentMaker getEuipmentMaker() {
		return euipment_maker;
	}

	public void setEuipmentMaker(EquipmentMaker euipmentMaker) {
		this.euipment_maker = euipmentMaker;
	}

	public int getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getRentPerDay() {
		return rentPerDay;
	}
	public void setRentPerDay(double rentPerDay) {
		this.rentPerDay = rentPerDay;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	@Override
	public String toString() {
		return "Equipments [equipmentId=" + equipmentId + ", equipmentName=" + equipmentName + ", count=" + count
				+ ", rentPerDay=" + rentPerDay + ", state=" + state + ", city=" + city + ", village=" + village
				+ ", pinCode=" + pinCode + ", contactPerson=" + contactPerson + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
	

}
