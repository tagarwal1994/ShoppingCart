package com.UKFinance.shoppingcart.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UKFinance.shoppingcart.entity.BillingAddress;
import com.UKFinance.shoppingcart.entity.Customer;
import com.UKFinance.shoppingcart.entity.Product;
import com.UKFinance.shoppingcart.repository.BillingAddressRepository;
import com.UKFinance.shoppingcart.service.BillingAddressService;
import com.UKFinance.shoppingcart.service.CustomerService;

@Service
public class BillingAddressServiceImpl implements BillingAddressService {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BillingAddressRepository billingAddressRepository;

	@Override
	public Integer getAddressByCustomerId(int customer_Id) {

		Integer count = 0;
		Optional<Customer> customer = Optional.ofNullable(customerService.getById(customer_Id));

		List<BillingAddress> addressesResponse = billingAddressRepository.getAddressByCustomerId(customer_Id);

		if (customer.isPresent()) {

			count = addressesResponse.size();
			return count;
		}
		return null;
	}

	@Override
	public BillingAddress saveCustomer(BillingAddress billingAddress) {
		return billingAddressRepository.save(billingAddress);
	}

	@Override
	public BillingAddress getAddressById(int id) {
		Optional<BillingAddress> billingAddress = this.billingAddressRepository.findById(id);
		return billingAddress.isPresent() ? billingAddress.get() : null;
	}

}
