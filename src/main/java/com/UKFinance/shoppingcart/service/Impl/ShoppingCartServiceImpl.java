package com.UKFinance.shoppingcart.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UKFinance.shoppingcart.entity.ShoppingCart;
import com.UKFinance.shoppingcart.repository.ShoppingCartRepository;
import com.UKFinance.shoppingcart.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@Override
	public ShoppingCart saveCartDetails(ShoppingCart shoppingCart) {
		return shoppingCartRepository.save(shoppingCart);
	}

	@Override
	public List<ShoppingCart> getAllCartItemsByCustomerId(int id) {

		List<ShoppingCart> shoppingcartItems = shoppingCartRepository.getAllCartItemsByCustomerId(id);
		return shoppingcartItems;
	}

	@Override
	public void updateCartStatusById(int id) {

		shoppingCartRepository.updateCartStatusById(id);
		
		/*
		 * ShoppingCart cartfromdb = shoppingCartRepository.getcartbyId(id); // crush
		 * the variables of the object found
		 * cartfromdb.setStatus("Order Placed by Customer");
		 * shoppingCartRepository.save(cartfromdb);
		 */
	}

}
