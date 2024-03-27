package com.UKFinance.shoppingcart.dto;

public class BillingAddressDTO {

	private int Id;
	private String addressLine1;
	private String addressLine2;

	private String firstName;
	private String lastName;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	private CustomerDTO customer;

	public BillingAddressDTO(String addressLine1, String addressLine2, String firstName, String lastName, String city,
			String state, String zipCode, String country, CustomerDTO customer) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.customer = customer;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "BillingAddressDTO [Id=" + Id + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + ", country=" + country + ", customer=" + customer + ", getId()=" + getId()
				+ ", getAddressLine1()=" + getAddressLine1() + ", getAddressLine2()=" + getAddressLine2()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getCity()=" + getCity()
				+ ", getState()=" + getState() + ", getZipCode()=" + getZipCode() + ", getCountry()=" + getCountry()
				+ ", getCustomer()=" + getCustomer() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}






}
