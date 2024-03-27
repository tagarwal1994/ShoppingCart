package com.UKFinance.shoppingcart.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.ToString;

@ToString
@Entity
@Table(name = "myorder")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	@NotNull
	private int id;

	private String orderDescription;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "seller_id", referencedColumnName = "id")
	private Seller seller;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "shipper_id", referencedColumnName = "id")
	private Shipper shipper;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "billing_address_id", referencedColumnName = "id")
	private BillingAddress billingAddress;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_quantity")
	private int productQuantity;

	@Column(name = "total_amount")
	private float totalAmount;

	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "seller_status")
	private String sellerStatus;

	@Column(name = "customer_status")
	private String customerStatus;

	@Column(name = "shipper_status")
	private String shipperStatus;

	public Order() {
	}

	public Order(String orderDescription, Customer customer, Product product, Seller seller, Shipper shipper,
			BillingAddress billingAddress, String productName, int productQuantity, float totalAmount,
			Date creationDate, String sellerStatus, String customerStatus, String shipperStatus) {
		super();
		this.orderDescription = orderDescription;
		this.customer = customer;
		this.product = product;
		this.seller = seller;
		this.shipper = shipper;
		this.billingAddress = billingAddress;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.totalAmount = totalAmount;
		this.creationDate = creationDate;
		this.sellerStatus = sellerStatus;
		this.customerStatus = customerStatus;
		this.shipperStatus = shipperStatus;
	}
	
	


	public Order(Shipper shipper, String sellerStatus, String customerStatus, String shipperStatus) {
		super();
		this.shipper = shipper;
		this.sellerStatus = sellerStatus;
		this.customerStatus = customerStatus;
		this.shipperStatus = shipperStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getSellerStatus() {
		return sellerStatus;
	}

	public void setSellerStatus(String sellerStatus) {
		this.sellerStatus = sellerStatus;
	}

	public String getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}

	public String getShipperStatus() {
		return shipperStatus;
	}

	public void setShipperStatus(String shipperStatus) {
		this.shipperStatus = shipperStatus;
	}

	public Shipper getShipper() {
		return shipper;
	}

	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}

}
