package com.UKFinance.shoppingcart.service;

import java.util.List;

import com.UKFinance.shoppingcart.entity.ShoppingCart;

public interface ShoppingCartService {

	ShoppingCart saveCartDetails(ShoppingCart shoppingCart);

	List<ShoppingCart> getAllCartItemsByCustomerId(int id);

	void updateCartStatusById(int id);

}
