package com.UKFinance.shoppingcart.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.UKFinance.shoppingcart.dto.OrderShippingDTO;
import com.UKFinance.shoppingcart.dto.ProductDTO;
import com.UKFinance.shoppingcart.dto.ProductDetailsUpdateRequestDTO;
import com.UKFinance.shoppingcart.dto.SellerDTO;
import com.UKFinance.shoppingcart.entity.Order;
import com.UKFinance.shoppingcart.entity.Product;
import com.UKFinance.shoppingcart.entity.Seller;
import com.UKFinance.shoppingcart.entity.Shipper;
import com.UKFinance.shoppingcart.service.OrderService;
import com.UKFinance.shoppingcart.service.ProductService;
import com.UKFinance.shoppingcart.service.SellerService;
import com.UKFinance.shoppingcart.service.ShipperService;
import com.UKFinance.shoppingcart.util.ECommerceMessage;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/seller")
public class SellerController {

	@Autowired
	private SellerService sellerService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ShipperService shipperService;

	@Autowired
	private OrderService orderService;

	private Logger logger = LoggerFactory.getLogger(SellerController.class);

	@GetMapping("/getAllSeller")
	public ResponseEntity<List<SellerDTO>> getAllSeller() {

		List<SellerDTO> sellerDTO = new ArrayList<SellerDTO>();

		List<Seller> sellerList = sellerService.getAll();

		for (Seller seller : sellerList) {
			SellerDTO sellerDTO1 = new SellerDTO();

			sellerDTO1.setId(seller.getId());
			sellerDTO1.setSellerName(seller.getSellerName());
			sellerDTO1.setBusinessAddress(seller.getBusinessAddress());
			sellerDTO1.setBusinessEmail(seller.getBusinessEmail());
			sellerDTO1.setPhoneNumber(seller.getPhoneNumber());
			sellerDTO1.setProfilePictureUrl(seller.getProfilePictureUrl());
			sellerDTO1.setCreateDate(seller.getCreateDate());
		}

		return ResponseEntity.ok(sellerDTO);
	}

	@PostMapping("/addSeller")
	public ResponseEntity<?> add(@Valid @RequestBody SellerDTO sellerCreateDTO) {

		logger.info("Request Payload " + sellerCreateDTO.toString());

		Seller seller = new Seller(sellerCreateDTO.getSellerName(), sellerCreateDTO.getBusinessAddress(),
				sellerCreateDTO.getBusinessEmail(), sellerCreateDTO.getPhoneNumber(),
				sellerCreateDTO.getProfilePictureUrl(), sellerCreateDTO.getCreateDate());
		seller = sellerService.addSeller(seller);

		logger.info("Seller added successfully..!!");
		logger.info("Seller added successfully..!!");

		return ResponseEntity.ok(ECommerceMessage.SELLER_SAVED);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id) {
		sellerService.deleteById(id);
		return ResponseEntity.ok(ECommerceMessage.SELLER_DELETED);
	}

	@GetMapping("/getSellerById/{id}")
	public ResponseEntity<SellerDTO> getById(@PathVariable int id) {

		SellerDTO sellerDetail = new SellerDTO();

		Seller seller = sellerService.getSellerById(id);

		sellerDetail.setId(seller.getId());
		sellerDetail.setSellerName(seller.getSellerName());
		sellerDetail.setBusinessAddress(seller.getBusinessAddress());
		sellerDetail.setBusinessEmail(seller.getBusinessEmail());
		sellerDetail.setPhoneNumber(seller.getPhoneNumber());
		sellerDetail.setProfilePictureUrl(seller.getProfilePictureUrl());
		sellerDetail.setCreateDate(seller.getCreateDate());

		return ResponseEntity.ok(sellerDetail);
	}

	@PostMapping("/addProduct")
	public ResponseEntity<?> add(@RequestBody ProductDTO productCreateDto) {

		logger.info("Request Payload " + productCreateDto.toString());

		Date createDate = new Date();

		Seller seller = sellerService.getSellerById(productCreateDto.getSellerId());

		Product product = new Product(seller, productCreateDto.getProductName(), productCreateDto.getProductBrand(),
				productCreateDto.getProductDescription(), productCreateDto.getAvailableQuantity(),
				productCreateDto.getProductPrice(), productCreateDto.getProductImageUrl(), createDate, "ACTIVE");
		product = productService.saveProduct(product);

		logger.info("Product added successfully..!!");

		return ResponseEntity.ok(ECommerceMessage.PRODUCT_SAVED);
	}

	@GetMapping("/getProductById/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable int id) {
		Product product = productService.getProductById(id);

		ProductDTO productDto = new ProductDTO();

		productDto.setId(product.getId());
		productDto.setProductName(product.getProductName());
		productDto.setProductBrand(product.getProductBrand());
		productDto.setProductDescription(product.getProductDescription());
		productDto.setAvailableQuantity(product.getAvailableQuantity());
		productDto.setProductPrice(product.getProductPrice());
		productDto.setProductImageUrl(product.getProductImageUrl());
		return ResponseEntity.ok(productDto);
	}

	@DeleteMapping("/deleteproductById/{id}")
	public ResponseEntity<?> deleteByid(@PathVariable int id) {
		this.productService.deleteById(id);
		return ResponseEntity.ok(ECommerceMessage.PRODUCT_DELETED);
	}

	@PutMapping("/updateProductDetails")
	public ResponseEntity<?> updateByProductDetails(@RequestBody ProductDetailsUpdateRequestDTO updateRequestDTO) {

		productService.updateProductDetail(updateRequestDTO);

		return ResponseEntity.ok("success");
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody SellerDTO sellerReisterDTO) {

		logger.info("Request Payload " + sellerReisterDTO.toString());

		Seller seller = sellerService.isSellerPresent(sellerReisterDTO.getSellerName());

		if (seller != null) {
			logger.info("Seller already present..!!");
			return new ResponseEntity<>("Seller" + sellerReisterDTO.getSellerName() + " already exist", HttpStatus.OK);
		}

		else {

			Seller seller1 = new Seller(sellerReisterDTO.getSellerName(), sellerReisterDTO.getBusinessAddress(),
					sellerReisterDTO.getBusinessEmail(), sellerReisterDTO.getPhoneNumber(),
					sellerReisterDTO.getProfilePictureUrl(), sellerReisterDTO.getCreateDate(),
					sellerReisterDTO.getUsername(), sellerReisterDTO.getPassword());
			seller1 = sellerService.addSeller(seller1);

			/**********
			 * send notification to seller for successfull registration with their username
			 *******/

			logger.info("Seller added successfully..!!");

			return ResponseEntity.ok(ECommerceMessage.SELLER_SAVED);
			// return new ResponseEntity<>("Details added successfully..!!", HttpStatus.OK);

		}

	}

	@PostMapping("/orderShipping")
	public ResponseEntity<String> orderShipping(@RequestBody OrderShippingDTO orderShippingDTO) {
		Shipper shipper = shipperService.getShipperById(orderShippingDTO.getShipperId());

		Order order = new Order(shipper, "Order Shipped", "Yet to Dispatch", "Ready to Deliver");
		order = orderService.saveOrder(order);

		/**********
		 * send notification to Shipper for Deliver the order with Order details.
		 *******************************/

		return ResponseEntity.ok(ECommerceMessage.ORDER_SHIPPED);

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
