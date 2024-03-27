package com.UKFinance.shoppingcart.dto;

import java.math.BigInteger;
import java.util.Date;

public class SellerDTO {

	private int Id;
	private String SellerName;
	private String businessAddress;
	private String businessEmail;
	private BigInteger phoneNumber;
	private String profilePictureUrl;
	private Date createDate;
	private String username;
	private String password;

	public SellerDTO(int id, String sellerName, String businessAddress, String businessEmail, BigInteger phoneNumber,
			String profilePictureUrl, Date createDate) {
		super();
		Id = id;
		SellerName = sellerName;
		this.businessAddress = businessAddress;
		this.businessEmail = businessEmail;
		this.phoneNumber = phoneNumber;
		this.profilePictureUrl = profilePictureUrl;
		this.createDate = createDate;
	}

	public SellerDTO(String sellerName, String businessAddress, String businessEmail, BigInteger phoneNumber,
			String profilePictureUrl, Date createDate) {
		super();
		SellerName = sellerName;
		this.businessAddress = businessAddress;
		this.businessEmail = businessEmail;
		this.phoneNumber = phoneNumber;
		this.profilePictureUrl = profilePictureUrl;
		this.createDate = createDate;
	}

	public SellerDTO(int id, String sellerName, String businessAddress, String businessEmail, BigInteger phoneNumber,
			String profilePictureUrl, Date createDate, String username, String password) {
		super();
		Id = id;
		SellerName = sellerName;
		this.businessAddress = businessAddress;
		this.businessEmail = businessEmail;
		this.phoneNumber = phoneNumber;
		this.profilePictureUrl = profilePictureUrl;
		this.createDate = createDate;
		this.username = username;
		this.password = password;
	}

	public SellerDTO() {
		super();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getSellerName() {
		return SellerName;
	}

	public void setSellerName(String sellerName) {
		SellerName = sellerName;
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
		return "SellerDTO [Id=" + Id + ", SellerName=" + SellerName + ", businessAddress=" + businessAddress
				+ ", businessEmail=" + businessEmail + ", phoneNumber=" + phoneNumber + ", profilePictureUrl="
				+ profilePictureUrl + ", createDate=" + createDate + ", username=" + username + ", password=" + password
				+ ", getId()=" + getId() + ", getSellerName()=" + getSellerName() + ", getBusinessAddress()="
				+ getBusinessAddress() + ", getBusinessEmail()=" + getBusinessEmail() + ", getPhoneNumber()="
				+ getPhoneNumber() + ", getProfilePictureUrl()=" + getProfilePictureUrl() + ", getCreateDate()="
				+ getCreateDate() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
