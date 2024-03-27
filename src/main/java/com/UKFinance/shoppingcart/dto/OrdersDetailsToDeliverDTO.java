package com.UKFinance.shoppingcart.dto;

import java.math.BigInteger;

public class OrdersDetailsToDeliverDTO {

	private int orderNumber;
	private String productName;
	private int productQuantity;
	private String CustomerName;
	private BigInteger customerPhoneNumber;
	private String deliveryAddress;

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
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

	public BigInteger getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(BigInteger customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	@Override
	public String toString() {
		return "OrdersDetailsToDeliverDTO [orderNumber=" + orderNumber + ", productName=" + productName
				+ ", productQuantity=" + productQuantity + ", CustomerName=" + CustomerName + ", customerPhoneNumber="
				+ customerPhoneNumber + ", deliveryAddress=" + deliveryAddress + ", getOrderNumber()="
				+ getOrderNumber() + ", getProductName()=" + getProductName() + ", getProductQuantity()="
				+ getProductQuantity() + ", getCustomerPhoneNumber()=" + getCustomerPhoneNumber()
				+ ", getDeliveryAddress()=" + getDeliveryAddress() + ", getCustomerName()=" + getCustomerName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
