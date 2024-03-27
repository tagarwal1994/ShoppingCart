package com.UKFinance.shoppingcart.service;

import com.UKFinance.shoppingcart.entity.BillingAddress;

public interface BillingAddressService {

	Integer getAddressByCustomerId(int customer_Id);

	BillingAddress saveCustomer(BillingAddress billingAddress);

	BillingAddress getAddressById(int id);
	
	

}
