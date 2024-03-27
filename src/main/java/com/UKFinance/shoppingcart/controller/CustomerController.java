package com.UKFinance.shoppingcart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.UKFinance.shoppingcart.dto.CustomerDTO;
import com.UKFinance.shoppingcart.entity.Customer;
import com.UKFinance.shoppingcart.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	private Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody CustomerDTO customerDTO) {

		logger.info("Request Payload " + customerDTO.toString());

		Integer response = checkCustomeralreadyExist(customerDTO);

		if (response != null) {
			logger.info("Customer already present..!!");
			return new ResponseEntity<>("Customer" + customerDTO.getFristName() + " already exist", HttpStatus.OK);
		}

		else {
			Customer customer = new Customer(customerDTO.getTitle(), customerDTO.getFristName(),
					customerDTO.getMiddleName(), customerDTO.getLastName(), customerDTO.getEmail(),
					customerDTO.getPhoneNumber(), customerDTO.getUserName(), customerDTO.getPassword());
			customer = customerService.saveCustomer(customer);

			/**********
			 * send notification to customer for successfull registration with their
			 * username
			 *******/

			logger.info("Customer added successfully..!!");
			return new ResponseEntity<>("Details added successfully..!!", HttpStatus.OK);
		}

	}

	private Integer checkCustomeralreadyExist(CustomerDTO customerdto2) {

		Customer customer = new Customer(customerdto2.getEmail());
		Integer customerIdFromDb = customerService.isCustomerPresent(customer);
		return customerIdFromDb;

	}
	
	
	@GetMapping("/initiateRequestToPay")
	public ResponseEntity<String> initiateRequrestToPay(@PathVariable String paymentMode) {

		if (paymentMode.equalsIgnoreCase("CBM - CBM")) {
			String url = "A";
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(url, String.class);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		if (paymentMode.equalsIgnoreCase("CBM - rCBDC")) {
			String url = "B";
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(url, String.class);
			return new ResponseEntity<>(result, HttpStatus.OK);

		}
		if (paymentMode.equalsIgnoreCase("rCBDC - CBM")) {
			String url = "C";
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(url, String.class);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			String url = "D";
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(url, String.class);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}

	}
	

}
