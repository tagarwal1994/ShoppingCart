package com.UKFinance.shoppingcart.controller;

import java.util.Date;

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

import com.UKFinance.shoppingcart.dto.OrderDTO;
import com.UKFinance.shoppingcart.dto.ShoppingCartDTO;
import com.UKFinance.shoppingcart.entity.BillingAddress;
import com.UKFinance.shoppingcart.entity.Customer;
import com.UKFinance.shoppingcart.entity.Order;
import com.UKFinance.shoppingcart.entity.Product;
import com.UKFinance.shoppingcart.entity.Seller;
import com.UKFinance.shoppingcart.service.BillingAddressService;
import com.UKFinance.shoppingcart.service.CustomerService;
import com.UKFinance.shoppingcart.service.OrderService;
import com.UKFinance.shoppingcart.service.ProductService;
import com.UKFinance.shoppingcart.service.SellerService;
import com.UKFinance.shoppingcart.service.ShoppingCartService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	private Logger logger = LoggerFactory.getLogger(OrderController.class);

	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private BillingAddressService billingAddressService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;

	@PostMapping("/placeorder")
	public ResponseEntity<String> placeOrder(@RequestBody OrderDTO orderDTO) {

		logger.info("Request Payload " + orderDTO.toString());

		Date creationDate = new Date();

		for (ShoppingCartDTO dto : orderDTO.getCartItems()) {

			Customer customer = customerService.getById(dto.getCustomerId());
			Product product = productService.getProductById(dto.getProduct().getId());
			Seller seller = sellerService.getSellerById(product.getSeller().getId());
			BillingAddress billingAddress = billingAddressService.getAddressById(orderDTO.getBillingAddressId());

			Order order = new Order(orderDTO.getOrderDescription(), customer, product, seller, null, billingAddress,
					dto.getProduct().getProductName(), dto.getProductQuantity(), dto.getTotalAmount(), creationDate,
					"Ready to Ship", "order placed", "shipping request not recived");
			order = orderService.saveOrder(order);

			/****************************************/
			// send notification to buyer order place successfully with order details.
			// send notification to seller to ship the order with order details.

			/***************************************/

			shoppingCartService.updateCartStatusById(dto.getId());

		}
		return new ResponseEntity<>("Order Placed successfully..!!", HttpStatus.OK);

	}

	@GetMapping(value = "/getOrder/{orderId}")
	public ResponseEntity<OrderDTO> getOrderDetails(@PathVariable int orderId) {

		Order order = orderService.getOrderDetail(orderId);

		OrderDTO orderDTO = new OrderDTO();
		
		ShoppingCartDTO scartDTO = new ShoppingCartDTO();
		scartDTO.setProductQuantity(order.getProductQuantity());
		scartDTO.setTotalAmount(order.getTotalAmount());

		orderDTO.setOrderDescription(order.getOrderDescription());
		orderDTO.setBillingAddressId(order.getBillingAddress().getId());

		return ResponseEntity.ok(orderDTO);
	}

}
