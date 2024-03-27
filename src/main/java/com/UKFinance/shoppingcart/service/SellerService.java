package com.UKFinance.shoppingcart.service;

import java.util.List;

import com.UKFinance.shoppingcart.entity.Seller;

public interface SellerService {

	List<Seller> getAll();

	Seller addSeller(Seller seller);

	void deleteById(int id);

	Seller getSellerById(int id);

	Seller isSellerPresent(String sellerName);

}
