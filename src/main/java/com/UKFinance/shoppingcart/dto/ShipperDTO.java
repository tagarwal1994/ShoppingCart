package com.UKFinance.shoppingcart.dto;

import java.math.BigInteger;
import java.util.Date;

public class ShipperDTO {

	private int Id;
	private String shipperName;
	private String businessAddress;
	private String businessEmail;
	private BigInteger phoneNumber;
	private String profilePictureUrl;
	private Date createDate;
	private String username;
	private String password;

	public ShipperDTO(int id, String shipperName, String businessAddress, String businessEmail, BigInteger phoneNumber,
			String profilePictureUrl, Date createDate, String username, String password) {
		super();
		Id = id;
		this.shipperName = shipperName;
		this.businessAddress = businessAddress;
		this.businessEmail = businessEmail;
		this.phoneNumber = phoneNumber;
		this.profilePictureUrl = profilePictureUrl;
		this.createDate = createDate;
		this.username = username;
		this.password = password;
	}
	
	

	public ShipperDTO() {
		super();
	}



	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getShipperName() {
		return shipperName;
	}

	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}

	public String getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}

	public String getBusinessEmail() {
		return businessEmail;
	}

	public void setBusinessEmail(String businessEmail) {
		this.businessEmail = businessEmail;
	}

	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}

	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ShipperDTO [Id=" + Id + ", shipperName=" + shipperName + ", businessAddress=" + businessAddress
				+ ", businessEmail=" + businessEmail + ", phoneNumber=" + phoneNumber + ", profilePictureUrl="
				+ profilePictureUrl + ", createDate=" + createDate + ", username=" + username + ", password=" + password
				+ ", getId()=" + getId() + ", getShipperName()=" + getShipperName() + ", getBusinessAddress()="
				+ getBusinessAddress() + ", getBusinessEmail()=" + getBusinessEmail() + ", getPhoneNumber()="
				+ getPhoneNumber() + ", getProfilePictureUrl()=" + getProfilePictureUrl() + ", getCreateDate()="
				+ getCreateDate() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
