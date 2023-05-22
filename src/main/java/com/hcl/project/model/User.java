package com.hcl.project.model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name = "Person_ID")
@Table(name = "Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userId;
	
	@NotBlank(message = "Can't be empty or have blanks")
	@NotEmpty(message = "Can't be empty or have blanks")
	String firstName;
	
	@NotBlank(message = "Can't be empty or have blanks")
	@NotEmpty(message = "Can't be empty or have blanks")
	String lastName;
	
	@NotBlank(message = "Can't be empty or have blanks")
	@NotEmpty(message = "Can't be empty or have blanks")
	String userName;
	
	@NotBlank(message = "Can't be empty or have blanks")
	@NotEmpty(message = "Can't be empty or have blanks")
	String password;
	
	@NotBlank(message = "Can't be empty or have blanks")
	@NotEmpty(message = "Can't be empty or have blanks")
	String state;
	
	@NotBlank(message = "Can't be empty or have blanks")
	@NotEmpty(message = "Can't be empty or have blanks")
	String city;
	
	@NotBlank(message = "Can't be empty or have blanks")
	@NotEmpty(message = "Can't be empty or have blanks")
	String  pinCode;
	
	@NotBlank(message = "Can't be empty or have blanks")
	@NotEmpty(message = "Can't be empty or have blanks")
	String mobileNumber;
	
	public User(){}
	
	


	public User(int id, @NotBlank(message = "Name cannot be blank") String firstName,
			@NotBlank(message = "Surname cannot be blank") String lastName,
			@NotBlank(message = "username cannot be blank") String userName,
			@NotBlank(message = "Password cannot be blank") String password,
			@NotBlank(message = "State cannot be blank") String state,
			@NotBlank(message = "City cannot be blank") String city,
			@NotBlank(message = "Pincode cannot be blank") String pinCode,
			@NotBlank(message = "Mobile no cannot be blank") String mobileNumber) {
		super();
		this.userId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.state = state;
		this.city = city;
		this.pinCode = pinCode;
		this.mobileNumber = mobileNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", state=" + state + ", city=" + city + ", pinCode=" + pinCode
				+ ", mobileNumber=" + mobileNumber + "]";
	}
	
	
	

}
