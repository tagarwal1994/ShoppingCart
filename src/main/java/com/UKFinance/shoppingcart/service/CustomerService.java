package com.UKFinance.shoppingcart.service;

import org.springframework.stereotype.Service;

import com.UKFinance.shoppingcart.entity.Customer;
import com.UKFinance.shoppingcart.exception.NotFoundException;
import com.UKFinance.shoppingcart.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Integer isCustomerPresent(Customer customer) {
		Customer customer1 = customerRepository.getCustomerByEmailAndFirstName(customer.getEmail(),
				customer.getFirstName());
		return customer1 != null ? customer1.getId() : null;
	}

	public Customer getById(int customer_Id) {
		return customerRepository.findById(customer_Id)
				.orElseThrow(() -> new NotFoundException("user couldn't be found by following id: " + customer_Id));
	}

	public Customer isUserPresent(String userName) {
		return customerRepository.findByUserName(userName);
	}
}
