package com.hcl.project.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@DiscriminatorValue("trader_ID")
@Table(name = "trader")
public class Trader extends User {

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,targetEntity=Item.class, mappedBy = "trader")
	private List<Item> itemsList;
 

    public Trader() {

    }

 

    public Trader(int id, @NotBlank(message = "Name cannot be blank") String firstName,
            @NotBlank(message = "Surname cannot be blank") String lastName,
            @NotBlank(message = "Mobile no cannot be blank") String mobileNumber,
            @NotBlank(message = "City cannot be blank") String city,
            @NotBlank(message = "State cannot be blank") String state,
            @NotBlank(message = "Pincode cannot be blank") String pinCode,
            @NotBlank(message = "username cannot be blank") String userName,
            @NotBlank(message = "Password cannot be blank") String password) {
		super(id, firstName, lastName, userName, password, state, city, pinCode, mobileNumber);
        // TODO Auto-generated constructor stub
    }

 

    public List<Item> getItemsList() {
        return itemsList;
    }

 

    public void setItemsList(Item item) {
        this.itemsList.add(item);
    }

 

    @Override
    public String toString() {
        return "Trader [itemsList=" + itemsList + ", getID()=" + getUserId() + ", getName()=" + getFirstName()
                + ", getSurname()=" + getLastName() + ", getMobileNo()=" + getMobileNumber() + ", getCity()=" + getCity()
                + ", getState()=" + getState() + ", getPincode()=" + getPinCode()+ ", getUserName()=" + getUserName()
                + ", getPassword()=" + getPassword() + "]";
    }
    
}