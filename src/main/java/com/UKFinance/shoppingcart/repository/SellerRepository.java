package com.UKFinance.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UKFinance.shoppingcart.entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {

	Seller findBySellerName(String sellerName);

}
