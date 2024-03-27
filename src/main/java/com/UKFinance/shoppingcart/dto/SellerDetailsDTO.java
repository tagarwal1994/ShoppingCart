package com.UKFinance.shoppingcart.dto;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.UKFinance.shoppingcart.entity.Product;

public class SellerDetailsDTO {

	private int Id;
	private String SellerName;
	private String businessAddress;
	private String businessEmail;
	private BigInteger phoneNumber;
	private String profilePictureUrl;
	private Date createDate;

	private List<Product> products;

	public SellerDetailsDTO(int id, String sellerName, String businessAddress, String businessEmail, BigInteger phoneNumber,
			String profilePictureUrl, Date createDate, List<Product> products) {
		super();
		Id = id;
		SellerName = sellerName;
		this.businessAddress = businessAddress;
		this.businessEmail = businessEmail;
		this.phoneNumber = phoneNumber;
		this.profilePictureUrl = profilePictureUrl;
		this.createDate = createDate;
		this.products = products;
	}

	public SellerDetailsDTO(String sellerName, String businessAddress, String businessEmail, BigInteger phoneNumber,
			String profilePictureUrl, Date createDate, List<Product> products) {
		super();
		SellerName = sellerName;
		this.businessAddress = businessAddress;
		this.businessEmail = businessEmail;
		this.phoneNumber = phoneNumber;
		this.profilePictureUrl = profilePictureUrl;
		this.createDate = createDate;
		this.products = products;
	}

	public SellerDetailsDTO() {
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "SellerDetailsDTO [Id=" + Id + ", SellerName=" + SellerName + ", businessAddress=" + businessAddress
				+ ", businessEmail=" + businessEmail + ", phoneNumber=" + phoneNumber + ", profilePictureUrl="
				+ profilePictureUrl + ", createDate=" + createDate + ", products=" + products + ", getId()=" + getId()
				+ ", getSellerName()=" + getSellerName() + ", getBusinessAddress()=" + getBusinessAddress()
				+ ", getBusinessEmail()=" + getBusinessEmail() + ", getPhoneNumber()=" + getPhoneNumber()
				+ ", getProfilePictureUrl()=" + getProfilePictureUrl() + ", getCreateDate()=" + getCreateDate()
				+ ", getProducts()=" + getProducts() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
