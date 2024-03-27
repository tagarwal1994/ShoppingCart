package com.UKFinance.shoppingcart.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UKFinance.shoppingcart.dto.ProductDetailsUpdateRequestDTO;
import com.UKFinance.shoppingcart.entity.Product;
import com.UKFinance.shoppingcart.repository.ProductRepository;
import com.UKFinance.shoppingcart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getAllProducts() {
		return this.productRepository.findAll();
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public Product getProductById(int id) {
		Optional<Product> product = this.productRepository.findById(id);
		return product.isPresent() ? product.get() : null;
	}

	@Override
	public List<Product> getByproductName(String productName) {
		return this.productRepository.getByproductName(productName);
	}

	@Override
	public List<Product> getByproductBrand(String productBrand) {
		return this.productRepository.getByproductBrand(productBrand);
	}

	@Override
	public void deleteById(int id) {
		this.productRepository.deleteById(id);

	}

	@Override
	public Map<Integer, Object> searchByProduct(String productName) {
		Map<Integer, Object> searchResult = new HashMap<>();
		List<Product> products = new ArrayList<>();

		for (Product product : productRepository.findAll()) {
			if (product.getProductName().contains(productName)) {
				products.add(product);
				searchResult.put(products.size(), products);
				return searchResult;
			}
		}
		return null;
	}

	@Override
	public void updateProductDetail(ProductDetailsUpdateRequestDTO updateRequestDTO) {
		Optional<Product> product = productRepository.findById(updateRequestDTO.getId());

		product.ifPresent(value -> value.getProductDescription());
		product.ifPresent(value -> value.getAvailableQuantity());
		product.ifPresent(value -> value.getProductPrice());
		product.ifPresent(value -> value.getProductImageUrl());
		productRepository.save(product.get());

	}

	@Override
	public List<Product> getListOfProductsBySellerId(int id) {
		return this.productRepository.getListOfProductsBySellerId(id);
	}
}
