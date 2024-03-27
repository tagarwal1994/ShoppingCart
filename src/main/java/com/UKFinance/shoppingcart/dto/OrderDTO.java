package com.UKFinance.shoppingcart.dto;

import java.util.List;

public class OrderDTO {

	private String orderDescription;
	private int billingAddressId;
	private List<ShoppingCartDTO> cartItems;

	public OrderDTO() {
	}

	public OrderDTO(String orderDescription, int billingAddressId, List<ShoppingCartDTO> cartItems) {
		super();
		this.orderDescription = orderDescription;
		this.billingAddressId = billingAddressId;
		this.cartItems = cartItems;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public int getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(int billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	public List<ShoppingCartDTO> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<ShoppingCartDTO> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderDescription=" + orderDescription + ", billingAddressId=" + billingAddressId
				+ ", cartItems=" + cartItems + ", getOrderDescription()=" + getOrderDescription()
				+ ", getBillingAddressId()=" + getBillingAddressId() + ", getCartItems()=" + getCartItems()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
