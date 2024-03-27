package com.UKFinance.shoppingcart.dto;

import java.math.BigInteger;

public class CustomerDTO {

	private int Id;
	private String title;
	private String fristName;
	private String middleName;
	private String lastName;
	private String email;
	private BigInteger phoneNumber;
	private String userName;
	private String password;

	public CustomerDTO(int id, String title, String fristName, String middleName, String lastName, String email,
			BigInteger phoneNumber, String userName, String password) {
		super();
		Id = id;
		this.title = title;
		this.fristName = fristName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	@Override
	public String toString() {
		return "CustomerDTO [Id=" + Id + ", title=" + title + ", fristName=" + fristName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", userName="
				+ userName + ", password=" + password + ", getId()=" + getId() + ", getTitle()=" + getTitle()
				+ ", getFristName()=" + getFristName() + ", getMiddleName()=" + getMiddleName() + ", getLastName()="
				+ getLastName() + ", getEmail()=" + getEmail() + ", getPhoneNumber()=" + getPhoneNumber()
				+ ", getUserName()=" + getUserName() + ", getPassword()=" + getPassword() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
