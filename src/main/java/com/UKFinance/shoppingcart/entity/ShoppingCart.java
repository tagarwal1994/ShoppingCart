package com.UKFinance.shoppingcart.entity;

import lombok.ToString;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@ToString
@Entity
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	@NotNull
	private int id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;

	private String productName;
	private int productQuantity;
	private float totalAmount;
	private String status;

	public ShoppingCart() {
	}

	public ShoppingCart(Product product, Customer customer, String productName, int productQuantity, float totalAmount,
			String status) {
		super();

		this.product = product;
		this.customer = customer;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
