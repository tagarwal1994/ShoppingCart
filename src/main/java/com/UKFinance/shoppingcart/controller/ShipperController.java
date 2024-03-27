package com.UKFinance.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.UKFinance.shoppingcart.dto.OrdersDetailsToDeliverDTO;
import com.UKFinance.shoppingcart.dto.ShipperDTO;
import com.UKFinance.shoppingcart.entity.BillingAddress;
import com.UKFinance.shoppingcart.entity.Customer;
import com.UKFinance.shoppingcart.entity.Order;
import com.UKFinance.shoppingcart.entity.Shipper;
import com.UKFinance.shoppingcart.service.BillingAddressService;
import com.UKFinance.shoppingcart.service.CustomerService;
import com.UKFinance.shoppingcart.service.OrderService;
import com.UKFinance.shoppingcart.service.ShipperService;
import com.UKFinance.shoppingcart.util.ECommerceMessage;

@RestController
@RequestMapping("/api/shipper")
public class ShipperController {

	private Logger logger = LoggerFactory.getLogger(ShipperController.class);

	@Autowired
	private ShipperService shipperService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private BillingAddressService billingAddressService;
	
	@Autowired
	private CustomerService customerService;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody ShipperDTO shipperRegisterDTO) {
		logger.info("Request Payload " + shipperRegisterDTO.toString());

		Shipper shipper = shipperService.isShipperPresent(shipperRegisterDTO.getShipperName());

		if (shipper != null) {
			logger.info("Shipper already present..!!");
			return new ResponseEntity<>("Shipper" + shipperRegisterDTO.getShipperName() + " already exist",
					HttpStatus.OK);
		}

		else {

			Shipper shipper1 = new Shipper(shipperRegisterDTO.getShipperName(), shipperRegisterDTO.getBusinessAddress(),
					shipperRegisterDTO.getBusinessEmail(), shipperRegisterDTO.getPhoneNumber(),
					shipperRegisterDTO.getProfilePictureUrl(), shipperRegisterDTO.getCreateDate(),
					shipperRegisterDTO.getUsername(), shipperRegisterDTO.getPassword());
			shipper1 = shipperService.addShipper(shipper1);

			/**********
			 * send notification to Shipper for successfull registration with their username
			 *******/

			logger.info("shipper added successfully..!!");

			return ResponseEntity.ok(ECommerceMessage.SHIPPER_SAVED);
			// return new ResponseEntity<>("Details added successfully..!!", HttpStatus.OK);

		}

	}

	@GetMapping("/getOrdersDetailsToDeliver")
	public ResponseEntity<List<OrdersDetailsToDeliverDTO>> getOrdersDetailsToDeliver(@PathVariable int sellerId) {

		List<OrdersDetailsToDeliverDTO> ordersDetailsToDeliverDTO = new ArrayList<OrdersDetailsToDeliverDTO>();

		List<Order> orderList = orderService.getOrderListBySellerId(sellerId);

		for (Order orderList1 : orderList) {
			BillingAddress billingAddress = billingAddressService
					.getAddressById(orderList1.getBillingAddress().getId());

			String deliveryAddress = billingAddress.getAddress() + " " + billingAddress.getCity() + " "
					+ billingAddress.getState() + " " + billingAddress.getCountry() + " " + billingAddress.getZipCode();
			String customerName = billingAddress.getFirstName() + " " + billingAddress.getLastName();

			Customer customer = customerService.getById(orderList1.getCustomer().getId());

			OrdersDetailsToDeliverDTO dto = new OrdersDetailsToDeliverDTO();

			dto.setOrderNumber(orderList1.getId());
			dto.setProductName(orderList1.getProductName());
			dto.setProductQuantity(orderList1.getProductQuantity());
			dto.setCustomerPhoneNumber(customer.getPhoneNumber());
			dto.setDeliveryAddress(deliveryAddress);
			dto.setCustomerName(customerName);

			ordersDetailsToDeliverDTO.add(dto);

		}

		return ResponseEntity.ok(ordersDetailsToDeliverDTO);

	}



}
