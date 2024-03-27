package com.UKFinance.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UKFinance.shoppingcart.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> getByproductName(String productName);

	List<Product> getByproductBrand(String productBrand);
	
	void deleteById(int id);

	List<Product> getListOfProductsBySellerId(int id);

}
