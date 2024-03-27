package com.UKFinance.shoppingcart.dto;

public class ProductDetailsUpdateRequestDTO {

	private int Id;
	private String productDescription;
	private int availableQuantity;
	private float productPrice;
	private String productImageUrl;

	public ProductDetailsUpdateRequestDTO(int id, String productDescription, int availableQuantity, float productPrice,
			String productImageUrl) {
		super();
		Id = id;
		this.productDescription = productDescription;
		this.availableQuantity = availableQuantity;
		this.productPrice = productPrice;
		this.productImageUrl = productImageUrl;
	}

	public ProductDetailsUpdateRequestDTO(String productDescription, int availableQuantity, float productPrice,
			String productImageUrl) {
		super();
		this.productDescription = productDescription;
		this.availableQuantity = availableQuantity;
		this.productPrice = productPrice;
		this.productImageUrl = productImageUrl;
	}

	public ProductDetailsUpdateRequestDTO() {
		super();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	@Override
	public String toString() {
		return "ProductDetailsUpdateRequestDTO [Id=" + Id + ", productDescription=" + productDescription
				+ ", availableQuantity=" + availableQuantity + ", productPrice=" + productPrice + ", productImageUrl="
				+ productImageUrl + ", getId()=" + getId() + ", getProductDescription()=" + getProductDescription()
				+ ", getAvailableQuantity()=" + getAvailableQuantity() + ", getProductPrice()=" + getProductPrice()
				+ ", getProductImageUrl()=" + getProductImageUrl() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
