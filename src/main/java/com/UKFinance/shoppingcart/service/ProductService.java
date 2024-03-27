package com.UKFinance.shoppingcart.service;

import java.util.List;
import java.util.Map;

import com.UKFinance.shoppingcart.dto.ProductDetailsUpdateRequestDTO;
import com.UKFinance.shoppingcart.entity.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product saveProduct(Product product);

	Product getProductById(int id);

	List<Product> getByproductName(String productName);

	List<Product> getByproductBrand(String productBrand);

	void deleteById(int id);

	Map<Integer, Object> searchByProduct(String productName);

	void updateProductDetail(ProductDetailsUpdateRequestDTO updateRequestDTO);

	List<Product> getListOfProductsBySellerId(int id);
	
	
	

}
