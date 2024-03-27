package com.UKFinance.shoppingcart.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

import com.UKFinance.shoppingcart.dto.ProductDTO;
import com.UKFinance.shoppingcart.dto.ProductDetailsUpdateRequestDTO;
import com.UKFinance.shoppingcart.entity.Product;
import com.UKFinance.shoppingcart.service.ProductService;
import com.UKFinance.shoppingcart.util.ECommerceMessage;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	private Logger logger = LoggerFactory.getLogger(ProductController.class);

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody ProductDTO productCreateDto) {

		logger.info("Request Payload " + productCreateDto.toString());

		Date createDate = new Date();
		Product product = new Product(productCreateDto.getProductName(), productCreateDto.getProductBrand(),
				productCreateDto.getProductDescription(), productCreateDto.getAvailableQuantity(),
				productCreateDto.getProductPrice(), productCreateDto.getProductImageUrl(), createDate, "ACTIVE");
		product = productService.saveProduct(product);

		logger.info("Product added successfully..!!");

		return ResponseEntity.ok(ECommerceMessage.PRODUCT_SAVED);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<ProductDTO> getById(@PathVariable int id) {
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

	@GetMapping(value = "/getAllProducts")
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		List<Product> productList = productService.getAllProducts();

		List<ProductDTO> ProductDTO = new ArrayList<ProductDTO>();
		for (Product productList1 : productList) {

			ProductDTO productDTO1 = new ProductDTO();
			productDTO1.setId(productList1.getId());
			productDTO1.setAvailableQuantity(productList1.getAvailableQuantity());
			productDTO1.setProductBrand(productList1.getProductBrand());
			productDTO1.setProductDescription(productList1.getProductDescription());
			productDTO1.setProductName(productList1.getProductName());
			productDTO1.setProductPrice(productList1.getProductPrice());
			productDTO1.setProductImageUrl(productList1.getProductImageUrl());

			ProductDTO.add(productDTO1);
		}

		return ResponseEntity.ok(ProductDTO);
	}

	@GetMapping("/getByProductName/{productName}")
	public ResponseEntity<List<ProductDTO>> getByproductName(@PathVariable String productName) {

		List<Product> products = productService.getByproductName(productName);

		if (products.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		List<ProductDTO> ProductDTO = new ArrayList<ProductDTO>();
		for (Product productList1 : products) {

			ProductDTO productDTO1 = new ProductDTO();
			productDTO1.setId(productList1.getId());
			productDTO1.setAvailableQuantity(productList1.getAvailableQuantity());
			productDTO1.setProductBrand(productList1.getProductBrand());
			productDTO1.setProductDescription(productList1.getProductDescription());
			productDTO1.setProductName(productList1.getProductName());
			productDTO1.setProductPrice(productList1.getProductPrice());
			productDTO1.setProductImageUrl(productList1.getProductImageUrl());

			ProductDTO.add(productDTO1);
		}

		return ResponseEntity.ok(ProductDTO);
	}

	@GetMapping("/getByProductBrand/{productBrand}")
	public ResponseEntity<List<ProductDTO>> getByproductBrand(@PathVariable String productBrand) {
		List<Product> products = productService.getByproductBrand(productBrand);

		if (products.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		List<ProductDTO> ProductDTO = new ArrayList<ProductDTO>();
		for (Product productList1 : products) {

			ProductDTO productDTO1 = new ProductDTO();
			productDTO1.setId(productList1.getId());
			productDTO1.setAvailableQuantity(productList1.getAvailableQuantity());
			productDTO1.setProductBrand(productList1.getProductBrand());
			productDTO1.setProductDescription(productList1.getProductDescription());
			productDTO1.setProductName(productList1.getProductName());
			productDTO1.setProductPrice(productList1.getProductPrice());
			productDTO1.setProductImageUrl(productList1.getProductImageUrl());

			ProductDTO.add(productDTO1);
		}

		return ResponseEntity.ok(ProductDTO);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteByid(@PathVariable int id) {
		this.productService.deleteById(id);
		return ResponseEntity.ok(ECommerceMessage.PRODUCT_DELETED);
	}

	@GetMapping("/searchByProduct/{productName}")
	public ResponseEntity<?> searchByProduct(@PathVariable String productName) {
		Map<Integer, Object> result = productService.searchByProduct(productName);
		return ResponseEntity.ok(result);
	}

	@PutMapping("/update-product-details")
	public ResponseEntity<?> updateByProductDetails(@RequestBody ProductDetailsUpdateRequestDTO updateRequestDTO) {

		productService.updateProductDetail(updateRequestDTO);

		return ResponseEntity.ok("success");
	}

}
