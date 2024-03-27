package com.UKFinance.shoppingcart.service.Impl;

import com.UKFinance.shoppingcart.entity.Order;
import com.UKFinance.shoppingcart.entity.Product;
import com.UKFinance.shoppingcart.entity.ShoppingCart;
import com.UKFinance.shoppingcart.repository.OrderRepository;
import com.UKFinance.shoppingcart.repository.ProductRepository;
import com.UKFinance.shoppingcart.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

	
	@Autowired
    private OrderRepository orderRepository;
	
	@Autowired
    private ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order getOrderDetail(int orderId) {
        Optional<Order> order = this.orderRepository.findById(orderId);
        return order.isPresent() ? order.get() : null;
    }

	/*
	 * public float getCartAmount(List<ShoppingCart> shoppingCartList) {
	 * 
	 * float totalCartAmount = 0f; float singleCartAmount = 0f; int
	 * availableQuantity = 0;
	 * 
	 * for (ShoppingCart cart : shoppingCartList) {
	 * 
	 * int productId = cart.getProduct().getId(); Optional<Product> product =
	 * productRepository.findById(productId); if (product.isPresent()) { Product
	 * product1 = product.get(); if (product1.getAvailableQuantity() <
	 * cart.getProductQuantity()) { singleCartAmount = product1.getProductPrice() *
	 * product1.getAvailableQuantity();
	 * cart.setProductQuantity(product1.getAvailableQuantity()); } else {
	 * singleCartAmount = cart.getProductQuantity() * product1.getProductPrice();
	 * availableQuantity = product1.getAvailableQuantity() -
	 * cart.getProductQuantity(); } totalCartAmount = totalCartAmount +
	 * singleCartAmount; product1.setAvailableQuantity(availableQuantity);
	 * availableQuantity=0; cart.setProductName(product1.getProductName());
	 * cart.setTotalAmount(singleCartAmount); productRepository.save(product1); } }
	 * return totalCartAmount; }
	 */

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

	@Override
	public List<Order> getOrderListBySellerId(int sellerId) {
		return this.orderRepository.getOrderListBySellerId(sellerId);
	}
}
