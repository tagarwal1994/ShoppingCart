package com.UKFinance.shoppingcart.entity;

import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	@NotNull
	private int id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "seller_id", referencedColumnName = "id")
	private Seller seller;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_brand")
	private String productBrand;

	@Column(name = "product_description")
	private String productDescription;

	@Column(name = "quantity")
	private int availableQuantity;

	@Column(name = "product_price")
	private float productPrice;

	@Column(name = "product_image_url")
	private String productImageUrl;

	@Column(name = "creation_date")
	private Date createDate;

	@Column(name = "status")
	private String status;

	public Product(Seller seller, String productName, String productBrand, String productDescription,
			int availableQuantity, float productPrice, String productImageUrl, Date createDate, String status) {
		super();
		this.seller = seller;
		this.productName = productName;
		this.productBrand = productBrand;
		this.productDescription = productDescription;
		this.availableQuantity = availableQuantity;
		this.productPrice = productPrice;
		this.productImageUrl = productImageUrl;
		this.createDate = createDate;
		this.status = status;
	}

	public Product(String productName, String productBrand, String productDescription, int availableQuantity,
			float productPrice, String productImageUrl, Date createDate, String status) {
		super();
		this.productName = productName;
		this.productBrand = productBrand;
		this.productDescription = productDescription;
		this.availableQuantity = availableQuantity;
		this.productPrice = productPrice;
		this.productImageUrl = productImageUrl;
		this.createDate = createDate;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
