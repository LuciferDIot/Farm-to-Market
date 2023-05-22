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
@Table(name= "items")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int itemId;
	
	@NotEmpty(message = "Can't be empty or have blanks")
	String itemName;
	String photoUrl;
	
	String Description;
	
	@NotNull
	double quantity;
	
	@ManyToOne
	@JoinColumn(name = "farmer_id")
	private Farmer farmer_id;

	@ManyToOne
	@JoinColumn(name = "trader_id")
	private Trader trader;
	
	
	public Farmer getFarmer() {
		return farmer_id;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer_id = farmer;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public Item() {}

	public Item(int itemId, String itemName, String photoUrl, String description, double quantity) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.photoUrl = photoUrl;
		Description = description;
		this.quantity = quantity;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", photoUrl=" + photoUrl + ", Description="
				+ Description + ", quantity=" + quantity + "]";
	}
	
	

}
