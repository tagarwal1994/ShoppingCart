package com.UKFinance.shoppingcart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.UKFinance.shoppingcart.entity.Product;

@RestController
@RequestMapping("/api")
public class ShoppingCartRestController {


	private Logger logger = LoggerFactory.getLogger(ShoppingCartRestController.class);

	/*
	 * @GetMapping(value = "/getOrder/{orderId}") public ResponseEntity<Order>
	 * getOrderDetails(@PathVariable int orderId) {
	 * 
	 * Order order = orderService.getOrderDetail(orderId); return
	 * ResponseEntity.ok(order); }
	 */

	/*
	 * @PostMapping("/placeOrder") public ResponseEntity<ResponseOrderDTO>
	 * placeOrder(@RequestBody OrderDTO orderDTO) { logger.info("Request Payload " +
	 * orderDTO.toString()); ResponseOrderDTO responseOrderDTO = new
	 * ResponseOrderDTO(); float amount =
	 * orderService.getCartAmount(orderDTO.getCartItems());
	 * 
	 * Customer customer = new Customer(orderDTO.getCustomerName(),
	 * orderDTO.getCustomerEmail(), null, null, null, amount, null, null); Integer
	 * customerIdFromDb = customerService.isCustomerPresent(customer); if
	 * (customerIdFromDb != null) { customer.setId(customerIdFromDb);
	 * logger.info("Customer already present in db with id : " + customerIdFromDb);
	 * } else { customer = customerService.saveCustomer(customer);
	 * logger.info("Customer saved.. with id : " + customer.getId()); } Order order
	 * = new Order(orderDTO.getOrderDescription(), customer,
	 * orderDTO.getCartItems()); order = orderService.saveOrder(order);
	 * logger.info("Order processed successfully..");
	 * 
	 * responseOrderDTO.setAmount(amount);
	 * responseOrderDTO.setDate(DateUtil.getCurrentDateTime());
	 * responseOrderDTO.setInvoiceNumber(new Random().nextInt(1000));
	 * responseOrderDTO.setOrderId(order.getId());
	 * responseOrderDTO.setOrderDescription(orderDTO.getOrderDescription());
	 * 
	 * logger.info("test push..");
	 * 
	 * return ResponseEntity.ok(responseOrderDTO); }
	 */


	@GetMapping(value = "/getAllProduct3PartyAPI")
	public ResponseEntity<Product[]> getAllProduct3PartyAPI() {

		String uri = "http://localhost:8080/api/getAllProducts";

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Product[]> response = restTemplate.getForEntity(uri, Product[].class);
		Product[] productList = response.getBody();

		for (Product p : productList) {
			System.out.println(p.getProductName() + ":" + p.getAvailableQuantity());
		}
		// return Arrays.asList(productList);
		return ResponseEntity.ok(productList);
	}

}
