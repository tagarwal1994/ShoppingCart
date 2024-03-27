package com.UKFinance.shoppingcart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UKFinance.shoppingcart.dto.BillingAddressDTO;
import com.UKFinance.shoppingcart.entity.BillingAddress;
import com.UKFinance.shoppingcart.entity.Customer;
import com.UKFinance.shoppingcart.service.BillingAddressService;
import com.UKFinance.shoppingcart.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/billingAddress")
@RequiredArgsConstructor
public class BillingAddressController {

	@Autowired
	private BillingAddressService billingAddressService;
	
	@Autowired
	private CustomerService customerService;

	private Logger logger = LoggerFactory.getLogger(BillingAddressController.class);

	@PostMapping("/addBillingAddress")
	public ResponseEntity<String> addBillingAddress(@RequestBody BillingAddressDTO billingAddressDTO) {

		logger.info("Request Payload " + billingAddressDTO.toString());

		Integer count = billingAddressService.getAddressByCustomerId(billingAddressDTO.getCustomer().getId());

		if (count < 3) {

			Customer customer = customerService.getById(billingAddressDTO.getCustomer().getId());
			String fullAddress = billingAddressDTO.getAddressLine1() + billingAddressDTO.getAddressLine2();
			BillingAddress billingAddress = new BillingAddress(customer, fullAddress, billingAddressDTO.getCity(),
					billingAddressDTO.getState(), billingAddressDTO.getZipCode(), billingAddressDTO.getCountry(), fullAddress, fullAddress);
			billingAddress = billingAddressService.saveCustomer(billingAddress);

			logger.info("Address added successfully..!!");
			return new ResponseEntity<>("Address added successfully..!!", HttpStatus.OK);
		} else {

			logger.info("Address limit exceeded..!!");
			return new ResponseEntity<>("address limit exceeded..!!", HttpStatus.OK);

		}

	}

}
