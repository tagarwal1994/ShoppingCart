package com.UKFinance.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UKFinance.shoppingcart.dto.LoginRequestDTO;
import com.UKFinance.shoppingcart.dto.ProductDTO;
import com.UKFinance.shoppingcart.dto.SellerDetailsDTO;
import com.UKFinance.shoppingcart.dto.ShipperDTO;
import com.UKFinance.shoppingcart.dto.ShoppingCartDTO;
import com.UKFinance.shoppingcart.entity.Customer;
import com.UKFinance.shoppingcart.entity.Product;
import com.UKFinance.shoppingcart.entity.Seller;
import com.UKFinance.shoppingcart.entity.Shipper;
import com.UKFinance.shoppingcart.entity.ShoppingCart;
import com.UKFinance.shoppingcart.service.CustomerService;
import com.UKFinance.shoppingcart.service.ProductService;
import com.UKFinance.shoppingcart.service.SellerService;
import com.UKFinance.shoppingcart.service.ShipperService;
import com.UKFinance.shoppingcart.service.ShoppingCartService;

@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private ShipperService shipperService;

	@PostMapping("/customer")
	public ResponseEntity<List<ShoppingCartDTO>> customerLogin(@RequestBody LoginRequestDTO loginRequestDTO) {

		Customer customer = customerService.isUserPresent(loginRequestDTO.getUserName());
		if (customer != null) {
			String password1 = customer.getPassword();
			String password2 = loginRequestDTO.getPassword();

			if (!password1.equalsIgnoreCase(password2)) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {

				for (ShoppingCartDTO dto : loginRequestDTO.getShoppingCartDTO()) {

					Product product = productService.getProductById(dto.getProduct().getId());
					ShoppingCart shoppingCart = new ShoppingCart(product, customer, dto.getProduct().getProductName(),
							dto.getProductQuantity(), dto.getTotalAmount(), "Order Pending");
					shoppingCart = shoppingCartService.saveCartDetails(shoppingCart);

				}

				List<ShoppingCart> shoppingCart = new ArrayList<ShoppingCart>();
				shoppingCart = shoppingCartService.getAllCartItemsByCustomerId(customer.getId());

				List<ShoppingCartDTO> shoppingCartDTO = new ArrayList<ShoppingCartDTO>();
				for (ShoppingCart cart : shoppingCart) {

					ShoppingCartDTO sCartDTO = new ShoppingCartDTO();
					ProductDTO productDTO = new ProductDTO();
					Product product = productService.getProductById(cart.getProduct().getId());
					productDTO.setId(product.getId());
					productDTO.setAvailableQuantity(product.getAvailableQuantity());
					productDTO.setProductBrand(product.getProductBrand());
					productDTO.setProductDescription(product.getProductDescription());
					productDTO.setProductName(product.getProductName());
					productDTO.setProductPrice(product.getProductPrice());
					productDTO.setProductImageUrl(product.getProductImageUrl());

					sCartDTO.setId(cart.getId());
					sCartDTO.setProductQuantity(cart.getProductQuantity());
					sCartDTO.setTotalAmount(cart.getTotalAmount());
					sCartDTO.setProduct(productDTO);
					sCartDTO.setCustomerId(cart.getCustomer().getId());

					shoppingCartDTO.add(sCartDTO);
				}

				return ResponseEntity.ok(shoppingCartDTO);
			}
		}

		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/sellerDetails")
	public ResponseEntity<SellerDetailsDTO> sellerLogin(@PathVariable String sellerName) {

		Seller seller = sellerService.isSellerPresent(sellerName);

		if (seller != null) {
			SellerDetailsDTO dto = new SellerDetailsDTO();

			dto.setId(seller.getId());
			dto.setSellerName(seller.getSellerName());
			dto.setBusinessAddress(seller.getBusinessAddress());
			dto.setBusinessEmail(seller.getBusinessEmail());
			dto.setPhoneNumber(seller.getPhoneNumber());
			dto.setProfilePictureUrl(seller.getProfilePictureUrl());
			dto.setCreateDate(seller.getCreateDate());

			List<Product> products = new ArrayList<Product>();

			products = productService.getListOfProductsBySellerId(seller.getId());

			if (products.isEmpty()) {
				dto.setProducts(null);
			} else {
				dto.setProducts(products);
			}

			return ResponseEntity.ok(dto);

		}

		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/shipperDetails")
	public ResponseEntity<ShipperDTO> shipperLogin(@PathVariable String shipperName) {
		Shipper shipper = shipperService.isShipperPresent(shipperName);

		if (shipper != null) {
			ShipperDTO dto = new ShipperDTO();

			dto.setId(shipper.getId());
			dto.setShipperName(shipper.getShipperName());
			dto.setBusinessAddress(shipper.getBusinessAddress());
			dto.setBusinessEmail(shipper.getBusinessEmail());
			dto.setPhoneNumber(shipper.getPhoneNumber());
			dto.setProfilePictureUrl(shipper.getProfilePictureUrl());
			dto.setCreateDate(shipper.getCreateDate());

			return ResponseEntity.ok(dto);

		}

		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}
