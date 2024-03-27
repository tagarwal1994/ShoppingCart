package com.UKFinance.shoppingcart.dto;

import java.util.Date;

public class ProductDTO {

	private int Id;
	private String productName;
	private String productBrand;
	private String productDescription;
	private int availableQuantity;
	private float productPrice;
	private String productImageUrl;
	private Date createDate;
	private int sellerId;

	public ProductDTO(int id, String productName, String productBrand, String productDescription, int availableQuantity,
			float productPrice, String productImageUrl, Date createDate) {
		super();
		Id = id;
		this.productName = productName;
		this.productBrand = productBrand;
		this.productDescription = productDescription;
		this.availableQuantity = availableQuantity;
		this.productPrice = productPrice;
		this.productImageUrl = productImageUrl;
		this.createDate = createDate;
	}

	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	
	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	@Override
	public String toString() {
		return "ProductDTO [Id=" + Id + ", productName=" + productName + ", productBrand=" + productBrand
				+ ", productDescription=" + productDescription + ", availableQuantity=" + availableQuantity
				+ ", productPrice=" + productPrice + ", productImageUrl=" + productImageUrl + ", createDate="
				+ createDate + ", sellerId=" + sellerId + ", getId()=" + getId() + ", getProductName()="
				+ getProductName() + ", getProductBrand()=" + getProductBrand() + ", getProductDescription()="
				+ getProductDescription() + ", getAvailableQuantity()=" + getAvailableQuantity()
				+ ", getProductPrice()=" + getProductPrice() + ", getProductImageUrl()=" + getProductImageUrl()
				+ ", getCreateDate()=" + getCreateDate() + ", getSellerId()=" + getSellerId() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}



}
