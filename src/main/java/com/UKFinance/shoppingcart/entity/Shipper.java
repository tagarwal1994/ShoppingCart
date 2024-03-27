package com.UKFinance.shoppingcart.entity;

import java.math.BigInteger;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Shipper {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	@NotNull
	private int id;

	@Column(name = "shipper_name")
	private String shipperName;

	@Column(name = "business_address")
	private String businessAddress;

	@Column(name = "business_email")
	private String businessEmail;

	@Column(name = "phone_number")
	private BigInteger phoneNumber;

	@Column(name = "profile_picture_url")
	private String profilePictureUrl;

	@Column(name = "create_date")
	private Date createDate;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	public Shipper(String shipperName, String businessAddress, String businessEmail, BigInteger phoneNumber,
			String profilePictureUrl, Date createDate, String userName, String password) {
		super();
		this.shipperName = shipperName;
		this.businessAddress = businessAddress;
		this.businessEmail = businessEmail;
		this.phoneNumber = phoneNumber;
		this.profilePictureUrl = profilePictureUrl;
		this.createDate = createDate;
		this.userName = userName;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	

}
