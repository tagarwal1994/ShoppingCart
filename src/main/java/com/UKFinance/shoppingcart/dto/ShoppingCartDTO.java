package com.UKFinance.shoppingcart.dto;

public class ShoppingCartDTO {

	private int Id;
	private int productQuantity;
	private float totalAmount;
	private ProductDTO product;
	private int customerId;
	private String status;

	public ShoppingCartDTO(int id, int productQuantity, float totalAmount, ProductDTO product, String status) {
		super();
		Id = id;
		this.productQuantity = productQuantity;
		this.totalAmount = totalAmount;
		this.product = product;
		this.status = status;
	}

	public ShoppingCartDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "ShoppingCartDTO [Id=" + Id + ", productQuantity=" + productQuantity + ", totalAmount=" + totalAmount
				+ ", product=" + product + ", customerId=" + customerId + ", status=" + status + ", getId()=" + getId()
				+ ", getProductQuantity()=" + getProductQuantity() + ", getTotalAmount()=" + getTotalAmount()
				+ ", getProduct()=" + getProduct() + ", getStatus()=" + getStatus() + "]";
	}

}
